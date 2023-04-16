package com.example.demo.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理
 *
 * @author TomLuo
 * @date 2019/8/19
 */
public class CGLibMatchmaker implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我是媒婆，海选女朋友");
        return proxy.invokeSuper(target, args);
    }

    public Object getInstance(Object target) {
        Enhancer enhancer = new Enhancer();
        Class<?> clazz = target.getClass();
        System.out.println(clazz);
        //将目标类设置成父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //返回子类作为代理对象
        return enhancer.create();
    }
}
