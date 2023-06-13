package com.example.demo1.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 多任务的编排
 *
 * @author TomLuo
 * @date 2023年03月12日 22:49
 */
public class MultiTaskCompletableFuture extends BaseCompletableFuture {
    /**
     * 多任务组合
     */
    CompletableFuture<String> futureImg = CompletableFuture.supplyAsync(() -> {
        System.out.println("查询商品图片信息");
        return "hello.jpg";
    }, executor);

    CompletableFuture<String> futureAttr = CompletableFuture.supplyAsync(() -> {
        System.out.println("查询商品属性信息");
        return "黑色+256G";
    }, executor);

    CompletableFuture<String> futureDesc = CompletableFuture.supplyAsync(() -> {
        try {
            Thread.sleep(3000);
            System.out.println("查询商品介绍信息");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "jack...";
    }, executor);

    /**
     * allOf 所有任务都执行完
     */
    public void allOf() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureImg, futureAttr, futureDesc);
        allOf.get();//等待所有结果完成
    }

    /**
     * anyOf 其中有一个任务执行完就可以
     */
    public void anyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(futureImg, futureAttr, futureDesc);
        anyOf.get();
    }


}