package com.example.principle.pkproxydecorator;

import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/17
 */
public class RunnerAgent implements IRunner {
    private IRunner runner;

    public RunnerAgent(IRunner _runner) {
        this.runner = _runner;
    }

    //代理人是不会跑的
    public void run() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            System.out.println("代理人同意安排运动员跑步");
            runner.run();
        } else {
            System.out.println("代理人心情不好，不安排运动员跑步");
        }
    }
}