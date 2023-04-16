package com.example.demo.factory.func;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());
         factory = new BwmFactory();
        System.out.println(factory.getCar());
    }
}
