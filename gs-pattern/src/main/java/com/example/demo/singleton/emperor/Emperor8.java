package com.example.demo.singleton.emperor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public enum Emperor8 {
    INSTANCE;
    public void say() {
        System.out.println("就我一个皇帝：" + INSTANCE.hashCode());
    }
}
