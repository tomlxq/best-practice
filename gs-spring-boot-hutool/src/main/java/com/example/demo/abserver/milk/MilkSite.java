package com.example.demo.abserver.milk;

import java.util.Vector;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public abstract class MilkSite {
    Vector<Customer> vectors = new Vector<>();

    void addCustomer(Customer o) {
        vectors.add(o);
    }

    void removeCustomer(Customer o) {
        if (vectors.contains(o)) {
            vectors.remove(o);
        }
    }

    void notifyCustomers() {
        vectors.forEach(c -> {
            c.haveMilk();
        });
    }

    /**
     * 实现自己的业务逻辑-提供牛奶并通知客户
     */
    public abstract void providerMilk();
}
