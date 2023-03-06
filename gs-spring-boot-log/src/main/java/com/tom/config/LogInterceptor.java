package com.tom.config;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * LogInterceptor 自定义日志拦截器 LogInterceptor.java
 * <p>
 * 用途：每一次链路，线程维度，添加最终的链路ID TRACE_ID
 * MDC(Mapped Diagnostic Context)诊断上下文映射，是@Slf4j提供的一个支持动态打印日志信息的工具
 *
 * @author TomLuo
 * @date 2023年03月06日 21:37
 */
public class LogInterceptor implements HandlerInterceptor {

    private static final String TRACE_ID = "TRACE_ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tid = UUID.randomUUID().toString().replace("-", "");
        //可以考虑让客户端传入链路ID，但需保证一定的复杂度唯一性；如果没使用默认UUID自动生成
        if (!StringUtils.isEmpty(request.getHeader(TRACE_ID))) {
            tid = request.getHeader(TRACE_ID);
        }
        MDC.put(TRACE_ID, tid);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        MDC.remove(TRACE_ID);
    }

}