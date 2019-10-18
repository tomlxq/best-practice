package com.example.demo.abserver.milk;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class CustomerTom implements Customer {
    @Override
    public void haveMilk() {
        System.out.println("牛奶送到，Tom 可以喝牛奶了");
    }
}
