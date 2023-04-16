package com.example.demo.proxy.javaapi;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/23
 */
@AllArgsConstructor
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean myPerson;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(myPerson, args);
    }
}
