package com.example.locking;

/**
 * 利用synchronized关键字实现单例模式 懒汉 - 双层校验锁
 *
 * @author TomLuo
 * @date 2023年05月21日 22:49
 */
public class SingleDoubleCheck {
    private static SingleDoubleCheck instance = null;

    private SingleDoubleCheck(){}//将构造器 私有化，防止外部调用

    public static SingleDoubleCheck getInstance() {
        if (instance == null) { //part 1
            synchronized (SingleDoubleCheck.class) {
                if (instance == null) { //part 2
                    instance = new SingleDoubleCheck();//part 3
                }
            }
        }
        return instance;
    }
}