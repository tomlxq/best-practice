package com.example.demo.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
public class LiftCloseState extends LiftState {
    @Override
    public void stop() {
        super.context.setState(Context.STOP_STATE);
        super.context.getState().stop();
    }

    @Override
    public void run() {
        super.context.setState(Context.RUN_STATE);
        super.context.getState().run();
    }

    @Override
    public void open() {
        super.context.setState(Context.OPEN_STATE);
        super.context.getState().open();
    }

    @Override
    public void close() {
        System.out.println("电梯关门了");
    }
}
