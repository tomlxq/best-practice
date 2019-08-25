package com.example.demo.template;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class Tea extends Bevegrage {
    @Override
    protected void putIngredients() {
        System.out.println("放入辅料：茉莉");
    }

    @Override
    protected void putMeterial() {
        System.out.println("放入茶");
    }
}
