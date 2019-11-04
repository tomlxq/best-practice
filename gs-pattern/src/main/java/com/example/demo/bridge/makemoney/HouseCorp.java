package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class HouseCorp extends Corp {
    public HouseCorp(Product product) {
        super(product);
    }

    @Override
    protected void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚钱了");
    }
}
