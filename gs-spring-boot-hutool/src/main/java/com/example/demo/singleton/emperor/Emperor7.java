package com.example.demo.singleton.emperor;

/**
 * 静态内部类
 *
 * @author TomLuo
 * @date 2019/10/13
 */
public class Emperor7 {
    /**
     * 私有的构造方法，防止从外部new对象出来
     */
    private Emperor7() {
    }

    private static class LazyClass {
        private static final Emperor7 INSTANCE = new Emperor7();
    }

    public static Emperor7 getInstance() {
        return LazyClass.INSTANCE;
    }

    public void say() {
        System.out.println("就我一个皇帝：" + getInstance().hashCode());
    }
}
