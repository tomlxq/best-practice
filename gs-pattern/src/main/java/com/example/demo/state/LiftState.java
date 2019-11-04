package com.example.demo.state;

import lombok.Setter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
@Setter
public abstract class LiftState {
    /**
     * 定义一个环境角色，也就是封装状态的变化引起的功能变化
     */
    protected Context context;

    abstract void stop();

    abstract void run();

    abstract void open();

    abstract void close();
}
