package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SynchronizedDemoTest
 *
 * @author TomLuo
 * @date 2023年03月26日 23:06
 */
class SynchronizedDemoTest {

    @Test
    public void testSynchronized() throws InterruptedException {
        SynchronizedDemo demo = new SynchronizedDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 创建 10 个线程并发调用 increment() 方法
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.increment();
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertEquals(10000, demo.getSharedVariable());
    }

}