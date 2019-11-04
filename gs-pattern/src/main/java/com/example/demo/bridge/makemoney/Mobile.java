package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class Mobile implements Product {
    @Override
    public void produce() {
        System.out.println("开始生产手机");
    }

    @Override
    public void sell() {
        System.out.println("手机卖钱了");
    }
}
