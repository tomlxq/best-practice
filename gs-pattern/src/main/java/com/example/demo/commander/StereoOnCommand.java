package com.example.demo.commander;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
public class StereoOnCommand implements Commander {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        this.stereo.on();
    }

    @Override
    public void undo() {
        this.stereo.off();
    }
}
