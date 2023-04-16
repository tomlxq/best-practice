package com.example.demo.factory.nuwa.factorymethod;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/15
 */
public abstract class AbstractHumanFactory {
    public  abstract <T extends Human> T createHuman(Class<T> c);
}
