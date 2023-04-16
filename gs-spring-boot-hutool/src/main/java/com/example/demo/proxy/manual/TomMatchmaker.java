package com.example.demo.proxy.manual;

import com.example.demo.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * 代理类的执行
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
        return TomProxy.newProxyInstance(new TomClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是手写代理媒婆，海选女朋友");
        method.invoke(this.target,args);
        return proxy;
    }
}
