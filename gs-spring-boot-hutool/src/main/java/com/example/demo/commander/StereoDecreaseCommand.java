package com.example.demo.commander;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
public class StereoDecreaseCommand implements Commander {
    private Stereo stereo;

    public StereoDecreaseCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {


        this.stereo.decreaseVolume();
    }

    @Override
    public void undo() {
        this.stereo.increaseVolume();
    }
}
