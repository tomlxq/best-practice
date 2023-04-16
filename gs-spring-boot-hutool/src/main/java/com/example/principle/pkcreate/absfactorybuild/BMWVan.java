package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public class BMWVan extends AbsBMW {
    private final static String SEVENT_SEARIES = "7系列车型商务车";

    public String getModel() {
        return SEVENT_SEARIES;
    }
}
