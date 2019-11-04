package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public class NewTvController extends AbstractController {
    boolean isOn = false;
    int channel = 0;
    int volume = 0;

    public NewTvController(Control control) {
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

    /**
     * 增加新功能，直接设置音量
     *
     * @param volume
     */
    public void setVolume(int volume) {
        super.control.setVolume(volume);
    }

    /**
     * 增加新功能，直接设置频道
     *
     * @param channel
     */
    public void setChannel(int channel) {
        super.control.setChannel(channel);
    }
}
