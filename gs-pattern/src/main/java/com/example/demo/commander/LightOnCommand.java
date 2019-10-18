package com.example.demo.commander;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/18
 */
@Data
public class LightOnCommand implements Commander {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
