package com.example.demo.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class WildFakeDuck extends WildTurkey implements Duck {
    @Override
    public void quack() {
        super.sing();
    }

    @Override
    public void go() {
        super.fly();
    }
}
