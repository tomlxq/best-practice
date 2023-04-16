package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public interface Control {
    void on();

    void off();

    void setChannel(int ch);


    void setVolume(int volume);
}
