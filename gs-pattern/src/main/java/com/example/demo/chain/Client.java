package com.example.demo.chain;

import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/31
 */
@NoArgsConstructor
public class Client {
    public PurchaseRequest sendRequest(String name, int price, int num) {
        return new PurchaseRequest(name, price, num);
    }
}
