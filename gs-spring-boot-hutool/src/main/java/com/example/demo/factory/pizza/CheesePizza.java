package com.example.demo.factory.pizza;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public class CheesePizza extends Pizza {
    public CheesePizza() {
        super("Cheese");
    }
    @Override
    public void prepare() {
        System.out.println("准备食材，放"+this.getName()+"到pizza中");
    }
}
