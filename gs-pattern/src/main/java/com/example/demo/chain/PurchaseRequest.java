package com.example.demo.chain;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/31
 */
@Data
public class PurchaseRequest {
    private String name;
    private float price = 0;
    private float num = 0;
    private String id;

    public PurchaseRequest(String name, float price, float num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public float getTotal() {
        return this.price * this.num;
    }
}
