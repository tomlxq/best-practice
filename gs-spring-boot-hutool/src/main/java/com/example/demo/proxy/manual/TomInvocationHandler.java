package com.example.demo.proxy.manual;

import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public interface TomInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
