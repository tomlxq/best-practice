package com.example.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * www
 *
 * @author TomLuo
 * @date 2023年05月18日 5:20
 */
@Slf4j
public class VisibilityTest {
    private volatile boolean flag = true;

    public void change() {
        flag = false;
        log.info(Thread.currentThread().getName() + "，已修改flag=false");
    }

    public void load() {
        log.info(Thread.currentThread().getName() + "，开始执行.....");
        int i = 0;
        while (flag) {
            i++;
        }
        log.info(Thread.currentThread().getName() + ",结束循环");
    }

    @Test
    public void testVisibility() throws InterruptedException {
        VisibilityTest test = new VisibilityTest();

        // 线程threadA模拟数据加载场景
        Thread threadA = new Thread(() -> test.load(), "threadA");
        threadA.start();

        // 让threadA执行一会儿
        Thread.sleep(1000);
        // 线程threadB 修改 共享变量flag
        Thread threadB = new Thread(() -> test.change(), "threadB");
        threadB.start();

    }

    public static volatile int val;

    public static void add() {
        for (int i = 0; i < 1000; i++) {
            val++;
        }
    }

    public static void main(String[] args) throws InterruptedException{

   // }
   // @Test
   // public void testThreadLocal2()  throws InterruptedException {
        Thread t1 = new Thread(VisibilityTest::add);
        Thread t2 = new Thread(VisibilityTest::add);
        t1.start();
        t2.start();
        t1.join();//等待该线程终止
        t2.join();
        System.out.println(val);
    }


}