package com.example.demo.template;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class CoffeeBeverage extends Beverage {
    @Override
    protected void addCondiments() {
        System.out.println("放入辅料：牛奶和糖");
    }

    @Override
    protected void brew() {
        System.out.println("放入coffee");
    }

    @Override
    public boolean wantAddCondiments() {
        return false;
    }
}
