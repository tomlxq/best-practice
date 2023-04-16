package com.example.demo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class Matchmaker implements InvocationHandler {
    private Person target;

    public Object getInstance(Person p) {
        this.target = p;
        Class<? extends Person> clazz = p.getClass();
        System.out.println(p.getClass());
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，海选女朋友");
        method.invoke(this.target,args);
        return proxy;
    }
}
