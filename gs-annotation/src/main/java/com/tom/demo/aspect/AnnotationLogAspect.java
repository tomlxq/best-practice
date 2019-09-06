package com.tom.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/3
 */
@Component //声明是被Spring IOC来管理
@Aspect //声明是一个需要动态织入一个切面的类
@Slf4j
public class AnnotationLogAspect {
    @Pointcut(value = "execution(* com.tom.demo.service..*(..))")
    public void myPointCut() {
    }

    @Before("myPointCut()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("{} before", name);
    }

    @Around("myPointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        String name = pjp.getSignature().getName();
        Object retVal = pjp.proceed();
        log.info("{} around, retVal:{}", name, retVal);


    }

    @After("myPointCut()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("{} after", name);
    }

    @AfterReturning(value = "myPointCut()", returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, Object retVal) {
        String name = joinPoint.getSignature().getName();
        log.info("{} afterReturning  retVal:{}", name, retVal);
    }

    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        log.info("{} afterThrowing {}", name, e.getMessage());
    }

}
