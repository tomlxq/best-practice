package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class TvController extends AbstractController {
    boolean isOn = false;
    int channel = 0;
    int volume = 0;

    public TvController(Control control) {
        super(control);
    }

    @Override
    protected void onOff() {
        if (isOn) {
            super.control.off();
            isOn = false;
        } else {
            super.control.on();
            isOn = true;
        }
    }

    @Override
    protected void preChannel() {
        super.control.setChannel(--channel);
    }

    @Override
    protected void nextChannel() {
        super.control.setChannel(++channel);
    }

    @Override
    protected void preVolume() {
        super.control.setVolume(--volume);
    }

    @Override
    protected void nextVolume() {
        super.control.setVolume(++volume);
    }
}
