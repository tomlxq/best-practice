package com.example.demo.abserver.milk;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class ConcreteMilkSite extends MilkSite {
    @Override
    public void providerMilk() {
        System.out.println("奶站有牛奶提供了，通知外送给用户");
        notifyCustomers();
    }
}
