package com.example.demo.commander;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
@Data
public class LightOffCommand implements Commander {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
