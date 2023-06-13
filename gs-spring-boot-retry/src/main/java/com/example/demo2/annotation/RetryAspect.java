package com.example.demo2.annotation;

import com.example.demo2.RetryExhaustedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * RetryAspect
 *
 * @author TomLuo
 * @date 2023年05月27日 13:17
 */
@Slf4j
@Aspect
@Component
public class RetryAspect {
    @Pointcut("@annotation(com.example.demo2.annotation.Retryable)")
    private void retryMethodCall() {
    }

    @Around("retryMethodCall()")
    public Object retry(ProceedingJoinPoint joinPoint) throws InterruptedException {
        Retryable retry = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Retryable.class);
        int maxRetryTimes = retry.retryCount();
        int retryInterval = retry.retryInterval();
        Throwable error = new RuntimeException();
        for (int retryTimes = 1; retryTimes <= maxRetryTimes; retryTimes++) {
            try {
                Object result = joinPoint.proceed();
                return result;
            } catch (Throwable throwable) {
                error = throwable;

                log.warn("调用发生异常，开始重试，retryTimes：{}", retryTimes);

            }
            Thread.sleep(retryInterval * 1600);
        }
        throw new RetryExhaustedException("重试次数耗尽", error);
    }
}