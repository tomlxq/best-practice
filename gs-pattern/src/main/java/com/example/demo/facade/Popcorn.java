package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class Popcorn {
    private Popcorn() {
    }

    private static class LazyClazz {
        private static final Popcorn INSTANCE = new Popcorn();
    }

    public static Popcorn getInstance() {
        return LazyClazz.INSTANCE;
    }

    void buy() {
        System.out.println("购买好爆米花，找好座位，开吃");
    }

    void throwRubbish() {
        System.out.println("扔掉爆米花包装盒到垃圾桶");
    }
}
