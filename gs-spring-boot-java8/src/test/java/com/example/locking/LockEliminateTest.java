package com.example.locking;

/**
 * 锁消除
 *
 * @author TomLuo
 * @date 2023年05月21日 22:48
 */
public class LockEliminateTest {
    static int i = 0;

    public void method1() {
        i++;
    }

    public void method2() {
        Object obj = new Object();
        synchronized (obj) {
            i++;
        }
    }
}