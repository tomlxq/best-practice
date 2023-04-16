package com.example.principle.pkcreate.absfactorybuild;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/14
 */
public interface CarFactory {
    //生产SUV
    public ICar createSuv();

    //生产商务车
    public ICar createVan();
}
