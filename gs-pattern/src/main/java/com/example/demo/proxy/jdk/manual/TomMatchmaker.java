package com.example.demo.proxy.jdk.manual;

import com.example.demo.proxy.jdk.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TomMatchmaker implements TomInvocationHandler {
    private Person target;
    public Object getInstance(Person p) {
        this.target = p;
        Class<? extends Person> clazz = p.getClass();
        System.out.println(p.getClass());
        return TomProxy.newProxyInstance(/*clazz.getClassLoader()*/null, clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
