package com.example;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年06月04日 22:05
 */
@Service
// 鉴权拦截器
public class  AuthInterceptor extends HandlerInterceptorAdapter {

    //@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !checkToken(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    private boolean checkToken(String token) {
        // 验证Token是否合法，是否过期等
        return true;
    }
}