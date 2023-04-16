package com.example.demo.singleton.emperor;

/**
 * 懒汉式（延迟加载)
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor3 {
    private static Emperor3 instance = null;
    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor3() {
    }

    public static Emperor3 getInstance() {
        if (instance == null) {
            instance = new Emperor3();
        }
        return instance;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + instance.hashCode());
    }
}
