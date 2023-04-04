package com.example.async.A3异步框架CompletableFuture;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

/**
 * 4.3 CompletableFuture实现异步
 * 不需要显式使用ExecutorService，CompletableFuture 内部使用了ForkJoinPool来处理异步任务，
 * 如果在某些业务场景我们想自定义自己的异步线程池也是可以的。
 *
 * @author TomLuo
 * @date 2023年03月22日 22:58
 */
public class CompletableFutureCompose {

    /**
     * thenAccept子任务和父任务公用同一个线程
     */
    @SneakyThrows
    public static void thenRunAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });
        CompletableFuture<Void> cf2 = cf1.thenRunAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something...");
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.get());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.get());
    }

    public static void main(String[] args) {
        thenRunAsync();
    }
}