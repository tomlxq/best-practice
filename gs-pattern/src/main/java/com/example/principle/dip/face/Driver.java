package com.example.principle.dip.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Driver implements IDriver {
    //司机的主要职责就是驾驶汽车
    public void drive(ICar car) {
        car.run();
    }
}