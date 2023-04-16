package com.example.demo.factory.nuwa.factorymethod;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/15
 */
public class WhiteHuman implements Human {
    @Override
    public void talk() {
        System.out.println("白人会说话了，但说的是单字节的话！");
    }

    @Override
    public void color() {
        System.out.println("白色人种造出来了，皮肤颜色是白色的！");
    }
}
