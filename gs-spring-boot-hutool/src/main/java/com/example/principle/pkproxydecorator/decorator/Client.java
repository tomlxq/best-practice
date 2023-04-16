package com.example.principle.pkproxydecorator.decorator;

import com.example.principle.pkproxydecorator.IRunner;
import com.example.principle.pkproxydecorator.Runner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/17
 */
public class Client {
    public static void main(String[] args) {
//定义运动员
        IRunner liu = new Runner();
//对其功能加强
        liu = new RunnerWithJet(liu);
//看看它的跑步情况如何
        System.out.println("===增强后的运动员的功能===");
        liu.run();
    }
}