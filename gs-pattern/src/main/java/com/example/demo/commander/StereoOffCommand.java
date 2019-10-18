package com.example.demo.commander;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
public class StereoOffCommand implements Commander {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        this.stereo.off();
    }

    @Override
    public void undo() {
        this.stereo.on();
    }
}
