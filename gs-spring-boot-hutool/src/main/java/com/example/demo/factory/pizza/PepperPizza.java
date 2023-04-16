package com.example.demo.factory.pizza;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public class PepperPizza extends Pizza {
    public PepperPizza() {
        super("Pepper");
    }
    @Override
    public void prepare() {
        System.out.println("准备食材，放"+this.getName()+"到pizza中");
    }
}
