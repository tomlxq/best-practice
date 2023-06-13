package com.example.demo1.service;

import java.util.concurrent.CompletableFuture;

/**
 * 三任务编排
 *
 * @author TomLuo
 * @date 2023年03月12日 22:46
 */
public class TwoTaskCompletableFuture extends BaseCompletableFuture{
    CompletableFuture<Object> future01 = CompletableFuture.supplyAsync(() -> {
        System.out.println("任务1线程" + Thread.currentThread().getId());
        int i = 10 / 4;
        System.out.println("任务1结束：");
        return i;
    }, executor);
    CompletableFuture<Object> future02 = CompletableFuture.supplyAsync(() -> {
        System.out.println("任务2线程" + Thread.currentThread().getId());
        try {
            Thread.sleep(3000);
            System.out.println("任务2结束：");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }, executor);
    /**
     * 三任务组合，前两个任务都完成，才执行任务3
     * 「runAfterBothAsync」 ：「任务01 任务02都完成了，再开始执行任务3，不感知任务1、2的结果的，也没返回值」
     */
    CompletableFuture<Void> future = future01.runAfterBothAsync(future02, () -> {
        System.out.println("任务3开始");
    }, executor);

    /**
     * 「thenAcceptBothAsync：任务01 任务02都完成了，再开始执行任务3，能感知到任务1、2的结果，但没返回值」
     */
    CompletableFuture<Void> future2 = future01.thenAcceptBothAsync(future02, (f1, f2) -> {
        System.out.println("任务3开始...得到之前的结果：f1:" + f1 + ", f2:" + f2);
    }, executor);
    /**
     * 「thenCombineAsync」 ：「任务01 任务02都完成了，再开始执行任务3，能感知到任务1、2的结果，而且自己可以带返回值」
     */
    CompletableFuture<String> future3 = future01.thenCombineAsync(future02, (f1, f2) -> {
        return f1 + ":" + f2 + "：哈哈";
    }, executor);
}