package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class Curtain {
    private Curtain() {
    }

    private static class LazyClazz {
        private static final Curtain INSTANCE = new Curtain();
    }

    public static Curtain getInstance() {
        return LazyClazz.INSTANCE;
    }

    void fell() {
        System.out.println("幕布降下来了");
    }

    void rise() {
        System.out.println("幕布上升了");
    }
}
