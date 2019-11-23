package com.example.principle.dip.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Benz implements ICar {
    //汽车肯定会跑
    public void run() {
        System.out.println("奔驰汽车开始运行...");
    }
}