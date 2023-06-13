package com.tom.redislimiter.aspect;


import com.google.common.collect.ImmutableList;
import com.tom.redislimiter.annotation.MyRedisLimiter;
import com.tom.redislimiter.enums.LimitType;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * redis限流切面类
 *
 * @author TomLuo
 * @date 2023年05月27日 20:39
 */
@Aspect
@Component
@Slf4j
public class RedisLimitAspect {
    private static final String UNKNOWN = "unknown";
    private static final String LIMIT_LUA_PATH = "limit.lua";
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private RedisTemplate<String, Serializable> limitRedisTemplate;
    private DefaultRedisScript<Number> redisScript;

    @PostConstruct
    public void init() {
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Number.class);
        ClassPathResource classPathResource = new ClassPathResource(LIMIT_LUA_PATH);
        try {
            classPathResource.getInputStream();//探测资源是否存在
            redisScript.setScriptSource(new ResourceScriptSource(classPathResource));
        } catch (IOException e) {
            logger.error("未找到文件：{}", LIMIT_LUA_PATH);
            redisScript.setScriptText(buildLuaScript());
        }
    }

    @Around("execution(public * *(..)) && @annotation(com.tom.redislimiter.annotation.MyRedisLimiter)")
    public Object limit(ProceedingJoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        MyRedisLimiter limitAnnotation = method.getAnnotation(MyRedisLimiter.class);
        LimitType limitType = limitAnnotation.limitType();
        int limitPeriod = limitAnnotation.period();
        int limitCount = limitAnnotation.count();

        String key = getKey(limitAnnotation, limitType);
        ImmutableList<String> keys = ImmutableList.of(StringUtils.join(limitAnnotation.prefix(), key));
        try {
            Number count = limitRedisTemplate.execute(redisScript, keys, limitCount, limitPeriod);
            logger.info("try to access, this time count is {} for key: {}", count, key);
            if (count != null && count.intValue() <= limitCount) {
                return pjp.proceed();
            } else {
                demote();//降级
                return null;
            }
        } catch (Throwable e) {
            if (e instanceof RuntimeException) {
                throw new RuntimeException(e.getLocalizedMessage());
            }
            throw new RuntimeException("服务器出现异常，请稍后再试");
        }
    }

    private String getKey(MyRedisLimiter limitAnnotation, LimitType limitType) {
        String key;
        switch (limitType) {
            case IP:
                key = getIpAddress();
                break;
            case CUSTOMER:
                key = limitAnnotation.key();
                break;
            default:
                key = null;
        }
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("key不可为空");
        }
        return key;
    }
    public String getIpAddress() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private void demote() {
        logger.info("try to access fail, this request will be demoted");
//        throw new RuntimeException("限流了");
        response.setHeader("Content-Type", "text/html;charset=UTF8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.println("访问失败，请稍后再试...");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    public String buildLuaScript() {
        return "local count" +
                "\ncount = redis.call('get',KEYS[1])" +
                // 不超过最大值，则直接返回
                "\nif count and tonumber(count) > tonumber(ARGV[1]) then" +
                "\nreturn count;" +
                "\nend" +
                // 执行计算器自加
                "\ncount = redis.call('incr',KEYS[1])" +
                "\nif tonumber(count) == 1 then" +
                // 从第一次调用开始限流，设置对应键值的过期
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn count;";
    }
}
