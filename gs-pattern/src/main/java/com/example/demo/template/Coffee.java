package com.example.demo.template;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class Coffee extends Bevegrage {
    @Override
    protected void putIngredients() {
        System.out.println("放入辅料：牛奶和糖");
    }

    @Override
    protected void putMeterial() {
        System.out.println("放入coffee");
    }
}
