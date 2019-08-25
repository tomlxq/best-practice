package com.example.demo.strategy;

/**
 * 具体策略
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class SubwayStrategy implements Strategy {
    @Override
    public void goToWork() {
        System.out.println("坐地铁去上班");
    }
}
