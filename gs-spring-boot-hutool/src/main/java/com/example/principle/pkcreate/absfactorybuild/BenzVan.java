package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public class BenzVan extends AbsBenz {
    private final static String R_SERIES = "R系列商务车";

    public String getModel() {
        return R_SERIES;
    }
}
