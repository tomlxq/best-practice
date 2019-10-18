package com.example.demo.strategy.duck;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class RedHeadDuck extends Duck {
    public RedHeadDuck(){
        flyBehavior=new LowFlyBehavior();
        quackBehavior=new GagaQuackBehavior();
    }
    @Override
    void display() {
        System.out.println("Red duck");
    }
}
