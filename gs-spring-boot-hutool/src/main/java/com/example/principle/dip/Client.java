package com.example.principle.dip;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
        Driver zhangSan = new Driver();
        Benz benz = new Benz();
//张三开奔驰车
        zhangSan.drive(benz);
    }
}