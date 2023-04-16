package com.example.principle.pkproxydecorator.decorator;

import com.example.principle.pkproxydecorator.IRunner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/17
 */
public class RunnerWithJet implements IRunner {
    private IRunner runner;

    public RunnerWithJet(IRunner _runner) {
        this.runner = _runner;
    }

    public void run() {
        System.out.println("加快运动员的速度：为运动员增加喷气装置");
        runner.run();
    }
}
