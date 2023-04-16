package com.example.demo.factory.simple;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getCard("Benz"));
    }
}
