package com.example;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;

/**
 * LoggerContextFilter
 *
 * @author TomLuo
 * @date 2023年06月06日 4:45
 */
@Slf4j
public class LoggerContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    //发送邮件通知相关部门


    //发送短信通知相关部门
    public void sendNotificationSMS(String phoneNumber, String content) {
        //调用第三方短信API发送短信
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        try {
            log.info("Request Received. URI: {}", requestURI);
            chain.doFilter(request, response);
        } catch(Exception e) {
            log.error("Exception occurred while processing request. URI: {}", requestURI, e);
            throw e;
        } finally {
            log.info("Request Completed. URI: {} Response Status: {}", requestURI, httpResponse.getStatus());
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}