package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public class BenzSuv extends AbsBenz {
    private final static String G_SERIES = "G系列SUV";

    public String getModel() {
        return G_SERIES;
    }
}
