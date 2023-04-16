package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public class BenzFactory implements CarFactory {
    //生产SUV
    public ICar createSuv() {
        return new BenzSuv();
    }

    //生产商务车
    public ICar createVan() {
        return new BenzVan();
    }
}