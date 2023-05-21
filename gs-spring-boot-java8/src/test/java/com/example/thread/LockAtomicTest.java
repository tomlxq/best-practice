package com.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月20日 8:24
 */
public class LockAtomicTest {

    public static int val;

    static Lock lock = new ReentrantLock();

    public static void add() {

        for (int i = 0; i < 1000; i++) {

            lock.lock();//上锁
            try {
                val++;
            }catch(Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();//解锁
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(LockAtomicTest::add);
        Thread t2 = new Thread(LockAtomicTest::add);
        t1.start();
        t2.start();
        t1.join();//等待该线程终止
        t2.join();
        System.out.println(val);
    }

}