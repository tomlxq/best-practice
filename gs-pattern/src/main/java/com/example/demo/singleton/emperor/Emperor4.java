package com.example.demo.singleton.emperor;

/**
 * 懒汉式（延迟加载，同步方法）
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor4 {
    private static volatile Emperor4 instance = null;
    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor4() {
    }

    public static synchronized Emperor4 getInstance() {
        if (instance == null) {
            instance = new Emperor4();
        }
        return instance;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + instance.hashCode());
    }
}
