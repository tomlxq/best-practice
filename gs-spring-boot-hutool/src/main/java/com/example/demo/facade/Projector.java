package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class Projector {
    private Projector() {
    }

    private static class LazyClazz {
        private static final Projector INSTANCE = new Projector();
    }

    public static Projector getInstance() {
        return LazyClazz.INSTANCE;
    }

    void on() {
        System.out.println("投影仪打开");
    }

    void off() {
        System.out.println("投影仪关闭");
    }

    void adjust() {
        System.out.println("投影仪调整");
    }
}
