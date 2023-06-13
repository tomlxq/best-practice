package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年06月04日 22:12
 */
public class RateLimitInterceptor extends HandlerInterceptorAdapter {
    private static final int DEFAULT_RATE_LIMIT_COUNT = 100; //默认每秒允许100次请求
    private static final int DEFAULT_RATE_LIMIT_TIME_WINDOW = 1000; //默认时间窗口为1秒
    private Map<String, Long> requestCountMap = new ConcurrentHashMap<>();
    private int rateLimitTimeWindow;
    private int rateLimitCount;

    public RateLimitInterceptor(){
        this(DEFAULT_RATE_LIMIT_TIME_WINDOW, DEFAULT_RATE_LIMIT_COUNT);
    }

    public RateLimitInterceptor(int timeWindow, int limitCount){
        this.rateLimitTimeWindow = timeWindow;
        this.rateLimitCount = limitCount;
    }

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String key = request.getRemoteAddr() + ":" + request.getRequestURI();
        long now = System.currentTimeMillis();
        if(requestCountMap.containsKey(key)){
            long last = requestCountMap.get(key);
            if(now - last < rateLimitTimeWindow){
                if(requestCountMap.get(key) >= rateLimitCount){
                    response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                    return false;
                }
                requestCountMap.put(key, requestCountMap.get(key) + 1);
            }else{
                requestCountMap.put(key, now);
            }
        }else{
            requestCountMap.put(key, now);
        }
        return true;
    }
}