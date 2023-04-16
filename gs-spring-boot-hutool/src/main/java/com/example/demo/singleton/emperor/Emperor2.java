package com.example.demo.singleton.emperor;

/**
 * 饿汉式（静态代码块）
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor2 {
    private static Emperor2 instance = null;
    static {
        instance = new Emperor2();
    }

    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor2() {
    }

    public static Emperor2 getInstance() {
        return instance;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + instance.hashCode());
    }
}
