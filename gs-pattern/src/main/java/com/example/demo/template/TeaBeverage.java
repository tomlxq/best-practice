package com.example.demo.template;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class TeaBeverage extends Beverage {
    @Override
    protected void addCondiments() {
        System.out.println("放入辅料：茉莉");
    }

    @Override
    protected void brew() {
        System.out.println("放入茶");
    }
}
