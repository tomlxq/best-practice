package com.example.demo.mediator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/9
 */
public abstract class AbsColleague {
    Mediator mediator;

    public AbsColleague(Mediator mediator) {
        this.mediator = mediator;
    }

    void sendMessage(int stateChange) {
        this.mediator.sendMessage(stateChange);
    }
}
