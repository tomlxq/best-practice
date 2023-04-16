package com.example.demo.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
public class LiftOpenState extends LiftState {
    @Override
    public void stop() {
    }

    @Override
    public void run() {

    }

    @Override
    public void open() {
        System.out.println("电梯打开了");
    }

    @Override
    public void close() {
        super.context.setState(Context.CLOSE_STATE);
        super.context.getState().close();
    }
}
