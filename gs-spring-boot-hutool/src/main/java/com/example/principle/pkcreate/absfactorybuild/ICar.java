package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */

public interface ICar {
    //汽车的生产商，也就是牌子
    public String getBand();

    //汽车的型号
    public String getModel();
}