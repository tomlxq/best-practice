package com.example.demo.factory.func;

import com.example.demo.factory.Bwm;
import com.example.demo.factory.Car;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class BwmFactory implements  Factory {
    @Override
    public Car getCar() {
        return new Bwm();
    }
}
