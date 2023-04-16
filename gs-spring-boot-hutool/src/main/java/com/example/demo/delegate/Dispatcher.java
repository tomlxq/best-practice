package com.example.demo.delegate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class Dispatcher implements IExecutor {
    IExecutor executor;

    public Dispatcher(IExecutor executor) {
        this.executor = executor;
    }

    /**
     * 项目经理安排，看起来是项目经理在做的，但实质是员工在做事
     * 典型的是干活是我的，功劳是你的
     */
    @Override
    public void doing() {
        executor.doing();
    }
}
