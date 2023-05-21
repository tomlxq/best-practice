package com.example.pattern.singleton;

/**
 * 5. 饿汉式单例
 *
 * @author TomLuo
 * @date 2023年05月21日 23:12
 */
public class SingleHungry {
    private static SingleHungry instance = new SingleHungry();

    private SingleHungry() {
    }

    public static SingleHungry getInstance() {
        return instance;
    }
}