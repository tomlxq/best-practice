package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public abstract class AbsBenz implements ICar {
    private final static String BENZ_BAND = "奔驰汽车";

    public String getBand() {
        return BENZ_BAND;
    }

    //具体型号由实现类完成
    public abstract String getModel();
}