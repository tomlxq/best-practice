package com.example.principle.pkwrapper.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
public class Actor implements IActor {
    @Override
    public void playAct() {
        System.out.println("普通演员也要表演，不然没有饭吃");
    }
}
