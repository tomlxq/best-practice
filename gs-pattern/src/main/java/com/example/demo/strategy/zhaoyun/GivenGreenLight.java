package com.example.demo.strategy.zhaoyun;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/11
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("吴国太开绿灯");
    }
}
