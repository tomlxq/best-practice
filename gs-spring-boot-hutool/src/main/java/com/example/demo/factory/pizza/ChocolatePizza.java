package com.example.demo.factory.pizza;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/14
 */
public class ChocolatePizza extends Pizza {
    public ChocolatePizza() {
        super("Chocolate");
    }
    @Override
    public void prepare() {
        System.out.println("准备食材，放"+this.getName()+"到pizza中");
    }
}
