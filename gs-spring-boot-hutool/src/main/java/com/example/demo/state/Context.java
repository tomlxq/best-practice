package com.example.demo.state;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/22
 */
public class Context {
    private LiftState state;
    public static final LiftState CLOSE_STATE = new LiftCloseState();
    public static final LiftState OPEN_STATE = new LiftOpenState();
    public static final LiftState RUN_STATE = new LiftRunState();
    public static final LiftState STOP_STATE = new LiftStopState();

    public LiftState getState() {
        return this.state;
    }

    public void setState(LiftState state) {
        this.state = state;
        this.state.setContext(this);
    }

    public void close() {
        this.state.close();
    }

    public void open() {
        this.state.open();
    }

    public void run() {
        this.state.run();
    }

    public void stop() {
        this.state.stop();
    }
}
