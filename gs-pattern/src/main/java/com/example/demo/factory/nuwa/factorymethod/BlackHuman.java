package com.example.demo.factory.nuwa.factorymethod;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/15
 */
public class BlackHuman implements Human {
    @Override
    public void talk() {
        System.out.println("黑人会说话了，一般人听不懂！");
    }

    @Override
    public void color() {
        System.out.println("黑色人种造出来了，皮肤颜色是黑色的！");
    }
}
