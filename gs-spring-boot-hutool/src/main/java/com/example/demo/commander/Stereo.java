package com.example.demo.commander;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
@Data
public class Stereo {
    public static final long MAX_VOLUME = 10L;
    int volume = 0;


    void on() {
        System.out.println("打开音响了");
    }

    void off() {
        System.out.println("关闭音响了");
    }

    void increaseVolume() {
        if (volume < MAX_VOLUME) {
            volume++;
        }
        System.out.println("当前音量：" + volume);
    }

    void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
        System.out.println("当前音量：" + volume);
    }
}
