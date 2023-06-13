package com.example.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalTime;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月27日 12:59
 */
@Slf4j
public class CGLibRetryProxyHandler implements MethodInterceptor {

    private Object target;//需要代址的日标对室

//生写仁藏方法


    @Override
    public Object intercept(Object obj, Method method, Object[] arr, MethodProxy proxy) throws Throwable {

        int times = 0;

        while (times < RetryConstant.MAX_TIMES) {

            try {

                return method.invoke(target, arr);

            } catch (Exception e) {

                times++;

                log.info("cglib retry :{},time:{}", times, LocalTime.now());
                if (times >= RetryConstant.MAX_TIMES) {

                    throw new RuntimeException(e);
                }
            }

//证时一秒

            try {

                Thread.sleep(1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;

    }
//定义获取代理时象方法

    public Object getCglibProxy(Object objectTarget) {
        this.target = objectTarget;

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);

        Object result = enhancer.create();
        return result;

    }


}

