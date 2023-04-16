package com.example.principle.dip.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public interface IDriver {
    //是司机就应该会驾驶汽车
    public void drive(ICar car);
}
