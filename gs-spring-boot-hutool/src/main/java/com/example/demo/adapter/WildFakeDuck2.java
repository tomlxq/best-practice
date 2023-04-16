package com.example.demo.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class WildFakeDuck2 implements Duck {
    Turkey turkey;

    public WildFakeDuck2(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.sing();
    }

    @Override
    public void go() {
        turkey.fly();
    }
}
