package com.example.demo.strategy.duck;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class GagaQuackBehavior implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Gaga quack");
    }
}
