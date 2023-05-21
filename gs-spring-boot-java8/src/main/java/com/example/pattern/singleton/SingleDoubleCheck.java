package com.example.pattern.singleton;

/**
 * 3. 懒汉式单例 -- 双重校验锁 synchronized版
 * 懒汉 - 双层校验锁
 *
 * @author TomLuo
 * @date 2023年05月21日 23:03
 */

public class SingleDoubleCheck {
    private static SingleDoubleCheck instance = null;

    private SingleDoubleCheck() {
    }//将构造器 私有化，防止外部调用

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