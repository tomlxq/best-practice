package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class Tour implements Product {
    @Override
    public void produce() {
        System.out.println("开始建旅游项目");
    }

    @Override
    public void sell() {
        System.out.println("旅游项目赚钱了");
    }
}
