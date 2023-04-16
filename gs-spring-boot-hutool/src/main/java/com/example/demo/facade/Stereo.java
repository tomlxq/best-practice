package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class Stereo {
    private Stereo() {
    }

    private static class LazyClazz {
        private static final Stereo INSTANCE = new Stereo();
    }

    public static Stereo getInstance() {
        return LazyClazz.INSTANCE;
    }

    void on() {
        System.out.println("影响打开了");
    }

    void off() {
        System.out.println("影响关闭了");
    }
}
