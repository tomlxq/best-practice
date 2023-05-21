package com.example.thread;

/**
 * volatile关键字无法保证原子性，更准确地说是volatile关键字只能保证单操作的原子性
 *
 * @author TomLuo
 * @date 2023年05月20日 8:25
 */
public class VolatileAtomicTest {

    public static volatile int val;

    public static void add() {
        for (int i = 0; i < 1000; i++) {
            val++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(VolatileAtomicTest::add);
        Thread t2 = new Thread(VolatileAtomicTest::add);
        t1.start();
        t2.start();
        t1.join();//等待该线程终止
        t2.join();
        System.out.println(val);
    }
}