package com.example.thread;

/**
 * eeee
 *
 * @author TomLuo
 * @date 2023年05月20日 8:23
 */
public class SynchronizedAtomicTest {
    public static int val;

    public synchronized static void add() {
        for (int i = 0; i < 1000; i++) {
            val++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SynchronizedAtomicTest::add);
        Thread t2 = new Thread(SynchronizedAtomicTest::add);
        t1.start();
        t2.start();
        t1.join();//等待该线程终止
        t2.join();
        System.out.println(val);
    }
}