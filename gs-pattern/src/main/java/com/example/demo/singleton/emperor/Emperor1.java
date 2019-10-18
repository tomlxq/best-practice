package com.example.demo.singleton.emperor;

/**
 * 饿汉式（静态变量）
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor1 {
    private static final Emperor1 instance = new Emperor1();

    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor1() {
    }

    public static Emperor1 getInstance() {
        return instance;
    }
    public void say(){
        System.out.println("就我一个皇帝："+instance.hashCode());
    }
}
