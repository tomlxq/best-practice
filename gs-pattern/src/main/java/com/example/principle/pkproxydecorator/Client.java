package com.example.principle.pkproxydecorator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/17
 */
public class Client {
    public static void main(String[] args) {
//定义一个短跑运动员
        IRunner liu = new Runner();
//定义liu的代理人
        IRunner agent = new RunnerAgent(liu);
//要求运动员跑步
        System.out.println("====客人找到运动员的代理要求其去跑步===");
        agent.run();
    }
}
