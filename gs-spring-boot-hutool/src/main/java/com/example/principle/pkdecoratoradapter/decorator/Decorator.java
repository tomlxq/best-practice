package com.example.principle.pkdecoratoradapter.decorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public class Decorator implements Swan {
    private Swan swan;

    //修饰的是谁
    public Decorator(Swan _swan) {
        this.swan = _swan;
    }

    public void cry() {
        swan.cry();
    }

    public void desAppearance() {
        swan.desAppearance();
    }

    public void fly() {
        swan.fly();
    }
}
