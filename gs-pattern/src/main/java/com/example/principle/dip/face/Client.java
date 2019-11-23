package com.example.principle.dip.face;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/11/10
 */
public class Client {
    public static void main(String[] args) {
        IDriver zhangSan = new Driver();
        ICar benz = new Benz();
//张三开奔驰车
        zhangSan.drive(benz);

        // IDriver zhangSan = new Driver();
        ICar bmw = new BMW();
//张三开奔驰车
        zhangSan.drive(bmw);
    }
}
