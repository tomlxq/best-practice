package com.example.demo.proxy.manual.dynamicgame;

import java.lang.reflect.Proxy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class DynamicProxy {
    public static <T> T newProxyInstance(T target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] classes = target.getClass().getInterfaces();
        MyInvocationHandler handler = new MyInvocationHandler(target);
        return (T) Proxy.newProxyInstance(classLoader, classes, handler);
    }
}
