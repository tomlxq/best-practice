package com.example.demo.delegate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class ExecutorB implements IExecutor {
    @Override
    public void doing() {
        System.out.println("员工B开始干活了");
    }
}
