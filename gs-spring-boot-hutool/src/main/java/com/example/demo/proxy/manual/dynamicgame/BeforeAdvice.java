package com.example.demo.proxy.manual.dynamicgame;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/24
 */
public class BeforeAdvice implements Advice {
    @Override
    public void exe() {
        System.out.println("前置通知！");
    }
}
