package com.example.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MyThreadLocalClassTest
 *
 * @author TomLuo
 * @date 2023年03月26日 22:54
 */
class MyThreadLocalClassTest {
    /**
     * 在调用 ThreadLocal 变量的方法之间添加 try-finally 块，以确保在线程执行完毕时清理当前线程的 ThreadLocal 变量
     */  @Test
    public void testThreadLocal2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    // 在此处调用 ThreadLocal 变量的方法
                    MyThreadLocalClass.set(Thread.currentThread());
                    // do something...
                } finally {
                    // 在 finally 块中清除 ThreadLocal 变量
                    MyThreadLocalClass.remove();
                }
            });
        }
        executorService.shutdown();
    }
    @Test
    public void testThreadLocal() {
        Object value1 = new Object();
        Object value2 = new Object();

        MyThreadLocalClass.set(value1);
        assertEquals(value1, MyThreadLocalClass.get());

        MyThreadLocalClass.set(value2);
        assertEquals(value2, MyThreadLocalClass.get());

        MyThreadLocalClass.remove();
        assertEquals(null, MyThreadLocalClass.get());
    }
}