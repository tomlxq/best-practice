package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class NewTvControllerTest {
    public static void main(String[] args) {
        NewTvController lg = new NewTvController(new LgController());

        lg.onOff();
        lg.onOff();
        lg.nextChannel();
        lg.nextChannel();
        lg.preChannel();
        lg.nextVolume();
        lg.nextVolume();
        lg.nextVolume();
        lg.preVolume();
        lg.setChannel(20);
        lg.setVolume(50);

    }
}
