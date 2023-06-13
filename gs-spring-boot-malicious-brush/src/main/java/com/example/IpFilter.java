package com.example;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * IP封禁
 *
 * @author TomLuo
 * @date 2023年06月04日 22:11
 */
public class IpFilter extends OncePerRequestFilter {
    private static final Set<String> IP_SET = new HashSet<>();

    static {
        IP_SET.add("192.168.1.100");
        IP_SET.add("127.0.0.1");
        //添加其他需要封禁的IP
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String ipAddress = request.getRemoteAddr();
        if(IP_SET.contains(ipAddress)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        filterChain.doFilter(request, response);
    }
}