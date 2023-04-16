package com.example.principle.pkdecoratoradapter.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class StrongBehavior extends Decorator {
    //强化谁
    public StrongBehavior(Swan _swan) {
        super(_swan);
    }

    //会飞行了
    public void fly() {
        System.out.println("会飞行了！");
    }
}
