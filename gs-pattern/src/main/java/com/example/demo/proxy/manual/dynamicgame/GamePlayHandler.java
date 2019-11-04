package com.example.demo.proxy.manual.dynamicgame;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class GamePlayHandler implements InvocationHandler {
    Object proxy;

    public GamePlayHandler(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.proxy, args);
    }
}
