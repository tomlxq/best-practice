package com.example.demo.singleton.emperor;

/**
 * 懒汉式（延迟加载，同步代码块）
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor5 {
    private static volatile Emperor5 instance = null;
    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor5() {
    }

    public static  Emperor5 getInstance() {
        if (instance == null) {
            synchronized (Emperor5.class) {
                instance = new Emperor5();
            }
        }
        return instance;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + instance.hashCode());
    }
}
