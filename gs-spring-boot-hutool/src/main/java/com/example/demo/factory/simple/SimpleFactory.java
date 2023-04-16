package com.example.demo.factory.simple;

import com.example.demo.factory.Audi;
import com.example.demo.factory.Bwm;
import com.example.demo.factory.Benz;
import com.example.demo.factory.Car;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/22
 */
public class SimpleFactory {
    /**
     * 符合标准，统一管理，专业管理
     *
     * @param name
     * @return
     */
    public Car getCard(String name) {
        if (name.equalsIgnoreCase("Benz")) {
            return new Benz();
        } else if (name.equalsIgnoreCase("Bwm")) {
            return new Bwm();
        } else if (name.equalsIgnoreCase("Audi")) {
            return new Audi();
        } else {
            System.out.println("不支持其它车型生产");
            return null;
        }
    }
}
