package com.example.demo.strategy.zhaoyun;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class Context {
    IStrategy iStrategy;

    // 构造函数，你要使用那个妙计
    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }
    // 看赵云出招了
    public void operate() {
        this.iStrategy.operate();
    }
}
