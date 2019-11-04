package com.example.demo.adapter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class WildTurkey implements Turkey {
    @Override
    public void sing() {
        System.out.println("火鸡唱歌了");
    }

    @Override
    public void fly() {
        System.out.println("火鸡长距离飞了");
    }
}
