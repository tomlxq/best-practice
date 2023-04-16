package com.example.demo.abserver.milk;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class MilkSiteTest {
    public static void main(String[] args) {
        MilkSite milkSite=new ConcreteMilkSite();
        Customer tom=new CustomerTom();
        Customer jack=new CustomerJack();
        milkSite.addCustomer(jack);
        milkSite.addCustomer(tom);
        milkSite.providerMilk();
        System.out.println("tom不想订牛奶了");
        milkSite.removeCustomer(tom);
        milkSite.providerMilk();
    }
}
