package com.example.demo.singleton.emperor;

/**
 * 懒汉式（延迟加载，同步代码块，双重检查）
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor6 {
    private static volatile Emperor6 instance = null;
    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor6() {
    }

    public static Emperor6 getInstance() {
        if (instance == null) {
            synchronized (Emperor6.class) {
                if (instance == null) {
                    instance = new Emperor6();
                }
            }
        }
        return instance;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + instance.hashCode());
    }
}
