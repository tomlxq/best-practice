package com.example.principle.pkwrapper.adapter;

import lombok.AllArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/23
 */
@AllArgsConstructor
public class Adapter implements IStar {
    IActor actor;

    @Override
    public void act() {
        this.actor.playAct();
    }
}
