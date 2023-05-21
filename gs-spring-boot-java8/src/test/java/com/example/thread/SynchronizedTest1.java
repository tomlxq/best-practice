package com.example.thread;

/**
 * javac SynchronizedTest1.java
 * javap -c -v SynchronizedTest1.class
 *
 * @author TomLuo
 * @date 2023年05月20日 8:37
 */
public class SynchronizedTest1 {


    private static int i;

    /**
     * 修饰实例方法
     */
    public synchronized void test() {
        System.out.println("synchronized 修饰 方法");
    }

    /**
     * 修饰静态方法
     */
    public static synchronized void test2(){
        i++;
    }

    /**
     * 修饰代码块
     * synchronized(object) ，表示进入同步代码库前要获得 给定对象的锁
     * synchronized(类.class) ，表示进入同步代码前要获得 给定 Class 的锁
     * 最好不要使用 synchronized(String a) ，因为在 JVM 中，字符串常量池具有缓存功能，如果我们多次加锁,会加锁在同一个对象上
     */
    public void test3() {
        synchronized (this) {
            System.out.println("synchronized 修饰 代码块");
        }
    }
}