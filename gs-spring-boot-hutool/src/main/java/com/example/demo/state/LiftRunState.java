package com.example.demo.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
public class LiftRunState extends LiftState {
    @Override
    public void stop() {
        super.context.setState(Context.STOP_STATE);
        super.context.getState().stop();
    }

    @Override
    public void run() {
        System.out.println("电梯在运行");
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {
    }
}
