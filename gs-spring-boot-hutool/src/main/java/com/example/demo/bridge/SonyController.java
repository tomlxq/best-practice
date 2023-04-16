package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class SonyController implements Control {
    @Override
    public void on() {
        System.out.println("索尼电视开机");
    }

    @Override
    public void off() {
        System.out.println("索尼电视关机");
    }

    @Override
    public void setChannel(int ch) {
        System.out.println("索尼电视频道开到" + ch);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("索尼电视音量开到" + volume);
    }
}
