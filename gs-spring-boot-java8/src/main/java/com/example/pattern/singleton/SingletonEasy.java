package com.example.pattern.singleton;

/**
 * 1. 懒汉式单例--简单版本
 * 在大部分情况下是没问题的，但是当突然有一天有多个访问者（线程）同时去获取对象实例时，
 *
 * if (instance == null) {
 *     instance = new SingletonEasy();
 * }
 *
 * 他们发现都不存在instance，然后就会导致 创建多个同样的实例的问题
 *
 * @author TomLuo
 * @date 2023年05月21日 22:58
 */
public class SingletonEasy  {
    private static SingletonEasy instance;

    private SingletonEasy() {}//将构造器 私有化，防止外部调用

    public static SingletonEasy getInstance() {
        if (instance == null) {
            instance = new SingletonEasy();
        }
        return instance;
    }
}