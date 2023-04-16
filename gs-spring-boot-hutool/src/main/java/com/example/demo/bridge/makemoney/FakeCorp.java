package com.example.demo.bridge.makemoney;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class FakeCorp extends Corp {
    public FakeCorp(Product product) {
        super(product);
    }

    @Override
    protected void makeMoney() {
        super.makeMoney();
        System.out.println("山寨公司赚钱了");
    }
}
