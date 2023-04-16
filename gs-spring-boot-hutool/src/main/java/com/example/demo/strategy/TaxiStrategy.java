package com.example.demo.strategy;

/**
 * 具体策略
 *
 * @author TomLuo
 * @date 2019/8/25
 */
public class TaxiStrategy implements Strategy {
    @Override
    public void goToWork() {
        System.out.println("打的去上班");
    }
}
