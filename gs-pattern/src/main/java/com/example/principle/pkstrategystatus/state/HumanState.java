package com.example.principle.pkstrategystatus.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/18
 */
public abstract class HumanState {
    //指向一个具体的人
    protected Human human;

    //设置一个具体的人
    public void setHuman(Human _human) {
        this.human = _human;
    }

    //不管人是什么状态都要工作
    public abstract void work();
}
