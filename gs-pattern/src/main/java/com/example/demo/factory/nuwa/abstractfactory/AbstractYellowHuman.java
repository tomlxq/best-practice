package com.example.demo.factory.nuwa.abstractfactory;



/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/15
 */
public abstract class AbstractYellowHuman implements Human {
    @Override
    public void talk() {
        System.out.println("黄色人种会说话了，但说的是双字节的话！");
    }

    @Override
    public void color() {
        System.out.println("黄色人种造出来了，皮肤颜色是黄色的！");
    }
}
