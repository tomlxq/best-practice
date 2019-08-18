package com.example.demo.proxy.jdk;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/8/18
 */
public class TomPerson implements Person {
    @Override
    public void findLove() {
        System.out.println("Tom找到女朋友了");
    }
}
