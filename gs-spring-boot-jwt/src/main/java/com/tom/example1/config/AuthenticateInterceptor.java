package com.tom.example1.config;

import com.tom.model.UserTokenDTO;
import com.tom.lib.JWTUtil;
import com.tom.service.RedisService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * AuthenticateInterceptor
 *
 * @author TomLuo
 * @date 2023年04月22日 17:46
 */
@Slf4j
@RequiredArgsConstructor
public class AuthenticateInterceptor implements HandlerInterceptor {
    final RedisService redisService;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String authToken = request.getHeader("Authorization");
        String token = authToken.substring("Bearer".length() + 1).trim();
        UserTokenDTO userTokenDTO = JWTUtil.parseToken(token);
        //1.判断请求是否有效
        if (redisService.get(userTokenDTO.getId()) == null
                || !redisService.get(userTokenDTO.getId()).equals(token)) {
            return false;
        }

        //2.判断是否需要续期
        if (redisService.getExpireTime(userTokenDTO.getId()) < 1 * 60 * 30) {
            redisService.set(userTokenDTO.getId(), token);
            log.error("update token info, id is:{}, user info is:{}", userTokenDTO.getId(), token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}