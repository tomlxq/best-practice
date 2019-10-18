package com.example.demo.strategy.duck;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class HighFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("High fly");
    }
}
