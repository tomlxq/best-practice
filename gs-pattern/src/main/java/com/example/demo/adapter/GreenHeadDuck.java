package com.example.demo.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class GreenHeadDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("鸭子嘎嘎叫");
    }

    @Override
    public void go() {
        System.out.println("鸭子飞很短的距离");
    }
}
