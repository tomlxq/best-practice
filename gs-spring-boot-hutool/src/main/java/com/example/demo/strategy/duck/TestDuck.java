package com.example.demo.strategy.duck;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class TestDuck {
    public static void main(String[] args) {
        Duck redHeadDuck=new RedHeadDuck();
        Duck greenHeadDuck=new GreenHeadDuck();

        redHeadDuck.display();
        redHeadDuck.fly();
        redHeadDuck.quack();


        greenHeadDuck.fly();
        greenHeadDuck.display();


    }
}
