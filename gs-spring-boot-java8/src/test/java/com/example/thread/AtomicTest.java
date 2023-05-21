package com.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月20日 8:25
 */
public class AtomicTest {
    public static AtomicInteger val = new AtomicInteger();

    public static void add() {
        for (int i = 0; i < 1000; i++) {
            val.getAndIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(AtomicTest::add);
        Thread t2 = new Thread(AtomicTest::add);
        t1.start();
        t2.start();
        t1.join();//等待该线程终止
        t2.join();
        System.out.println(val);
    }
}