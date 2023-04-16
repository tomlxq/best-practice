package com.example.demo.bridge;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/25
 */
public abstract class AbstractController {
    protected Control control;

    public AbstractController(Control control) {
        this.control = control;
    }

    protected abstract void onOff();

    protected abstract void preChannel();

    protected abstract void nextChannel();

    protected abstract void preVolume();

    protected abstract void nextVolume();
}
