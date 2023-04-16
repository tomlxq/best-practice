package com.example.demo.commander;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
public class StereoIncreaseCommand implements Commander {
    private Stereo stereo;

    public StereoIncreaseCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {


        this.stereo.increaseVolume();
    }

    @Override
    public void undo() {
        this.stereo.decreaseVolume();
    }
}
