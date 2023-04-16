package com.example.demo.factory.abs;

import com.example.demo.factory.Car;
import com.example.demo.factory.func.AudiFactory;
import com.example.demo.factory.func.Factory;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class DefaultFactory extends AbstractFactory {
    Factory defaultFactory = new AudiFactory();

    @Override
    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
