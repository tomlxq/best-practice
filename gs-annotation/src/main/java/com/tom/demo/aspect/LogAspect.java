package com.tom.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/3
 */
public class LogAspect {


    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " before");
    }


    public void around(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " around");
    }


    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " after");
    }


    public void afterReturning(JoinPoint joinPoint, Object retVal) {
        System.out.println(retVal);
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " afterReturning");
    }

    public void afterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + " aferThrowing");
    }

}
