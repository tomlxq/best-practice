package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public abstract class Corp {
    Product product;

    public Corp(Product product) {
        this.product = product;
    }

    protected void makeMoney() {
        this.product.produce();
        this.product.sell();
    }
}
