package com.example.demo.factory.abs;

import com.example.demo.factory.Audi;
import com.example.demo.factory.Benz;
import com.example.demo.factory.Bwm;
import com.example.demo.factory.Car;
import com.example.demo.factory.func.AudiFactory;
import com.example.demo.factory.func.BenzFactory;
import com.example.demo.factory.func.BwmFactory;
import com.example.demo.factory.func.Factory;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public abstract class AbstractFactory {
    /**
     * 工厂的规范
     * @return
     */
    protected abstract Car getCar();
    public Car getCar(String name){
        if (name.equalsIgnoreCase("Benz")) {
            return new BenzFactory().getCar();
        } else if (name.equalsIgnoreCase("Bwm")) {
            return new BwmFactory().getCar();
        } else if (name.equalsIgnoreCase("Audi")) {
            return new AudiFactory().getCar();
        } else {
            System.out.println("不支持其它车型生产");
            return null;
        }
    }
}
