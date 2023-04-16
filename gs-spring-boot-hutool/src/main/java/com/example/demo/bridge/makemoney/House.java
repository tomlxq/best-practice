package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class House implements Product {
    @Override
    public void produce() {
        System.out.println("开始盖公寓");
    }

    @Override
    public void sell() {
        System.out.println("公寓卖钱了");
    }
}
