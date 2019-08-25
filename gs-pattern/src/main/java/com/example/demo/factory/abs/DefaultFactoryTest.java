package com.example.demo.factory.abs;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class DefaultFactoryTest {
    public static void main(String[] args) {
        DefaultFactory defaultFactory = new DefaultFactory();
        System.out.println(defaultFactory.getCar());
        System.out.println(defaultFactory.getCar("Benz"));
    }
}
