package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ConcurrentHashMapDemoTest
 *
 * @author TomLuo
 * @date 2023年03月26日 23:08
 */
class ConcurrentHashMapDemoTest {
    @Test
    public void testConcurrentHashMap() throws InterruptedException {
        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 创建 10 个线程并发调用 put() 方法
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.put("key", j);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertEquals(Integer.valueOf(999), demo.get("key"));
    }

    @Test
    public void testConcurrentLinkedQueue() throws InterruptedException {
        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 创建 10 个线程并发调用 produce() 方法
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.produce("element " + j);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

//        assertEquals("element 0", demo.consume());
//        assertEquals("element 1", demo.consume());
//        assertEquals("element 2", demo.consume());
//        assertEquals("element 3", demo.consume());
//        assertEquals("element 4", demo.consume());

        while (!demo.getQueue().isEmpty()) {
            demo.consume();
        }
        assertNull(demo.consume());
    }
}