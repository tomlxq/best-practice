package com.example.demo.proxy.manual.dynamicgame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Advice beforeAdvice = new BeforeAdvice();
        beforeAdvice.exe();
        return method.invoke(this.target, args);
    }
}
