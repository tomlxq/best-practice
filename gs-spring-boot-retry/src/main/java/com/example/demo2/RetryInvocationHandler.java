package com.example.demo2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年05月27日 8:18
 */
@Slf4j
@RequiredArgsConstructor
public class RetryInvocationHandler implements InvocationHandler {
    private final Object subject;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int times = 0;
        while (times < RetryConstant.MAX_TIMES) {
            try {
                return method.invoke(subject, args);
            } catch (Exception e) {
                times++;
                log.info("times:{},time:{}", times, LocalTime.now());
                if (times >= RetryConstant.MAX_TIMES) {
                    throw new RuntimeException(e);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static Object getProxy(Object realSubject) {
        InvocationHandler handler = new RetryInvocationHandler(realSubject);
        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
    }
}