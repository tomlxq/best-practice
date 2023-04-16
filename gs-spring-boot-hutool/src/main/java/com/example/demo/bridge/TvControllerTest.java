package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class TvControllerTest {
    public static void main(String[] args) {
        AbstractController sharp = new TvController(new SharpController());
        AbstractController lg = new TvController(new LgController());

        sharp.onOff();
        sharp.onOff();
        sharp.nextChannel();
        sharp.nextChannel();
        sharp.preChannel();
        sharp.nextVolume();
        sharp.nextVolume();
        sharp.nextVolume();
        sharp.preVolume();

        lg.onOff();
        lg.onOff();
        lg.nextChannel();
        lg.nextChannel();
        lg.preChannel();
        lg.nextVolume();
        lg.nextVolume();
        lg.nextVolume();
        lg.preVolume();
    }
}
