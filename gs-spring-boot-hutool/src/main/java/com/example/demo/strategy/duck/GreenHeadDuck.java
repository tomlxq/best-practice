package com.example.demo.strategy.duck;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class GreenHeadDuck extends Duck {
    public GreenHeadDuck(){
        flyBehavior=new HighFlyBehavior();
    }
    @Override
    void display() {
        System.out.println("Green duck");
    }
}
