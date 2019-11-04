package com.example.demo.facade;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/19
 */
public class DvdPlayer {
    private DvdPlayer() {
    }

    private static class LazyClazz {
        private static final DvdPlayer INSTANCE = new DvdPlayer();
    }

    public static DvdPlayer getInstance() {
        return LazyClazz.INSTANCE;
    }

    public void play() {
        System.out.println("电影开始播放");
    }

    public void close() {
        System.out.println("电影播放结束");
    }

    public void pause() {
        System.out.println("电影播放暂停");
    }

}
