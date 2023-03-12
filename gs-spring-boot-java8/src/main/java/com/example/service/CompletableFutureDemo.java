package com.example.service;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFutureDemo
 *
 * @author TomLuo
 * @date 2023年03月12日 22:34
 */
public class CompletableFutureDemo extends BaseCompletableFuture{


    /**
     * runAsync无返回值
     */
    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 2;
        System.out.println("运行结果：" + i);
    }, executor);

    /**
     * supplyAsync有返回值
     * whenComplete能感知异常，能感知结果，但没办法给返回值
     * exceptionally能感知异常，不能感知结果，能给返回值。相当于，如果出现异常就返回这个值
     */
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 0;
        System.out.println("运行结果：" + i);
        return i;
    }, executor).whenComplete((res, excption) -> {
        //whenComplete虽然能得到异常信息，但是没办法修改返回值
        System.out.println("异步任务成功完成...结果是：" + res + ";异常是：" + excption);
    }).exceptionally(throwable -> {
        //exceptionally能感知异常，而且能返回一个默认值，相当于，如果出现异常就返回这个值
        return 10;
    });

    /**
     * supplyAsync有返回值
     * handle能拿到返回结果，也能得到异常信息，也能修改返回值
     */
    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 4;
        System.out.println("运行结果：" + i);
        return i;
    }, executor).handle((res, throwable) -> {
        if (throwable != null) {
            return 0;
        } else {
            return res * 2;
        }
    });

    /**
     * thenRunXXX 不能接收上一次的执行结果，也没返回值
     * .thenRunAsync(() -> {
     * System.out.println("任务2启动了...");
     * }, executor);
     */
    CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 4;
        System.out.println("运行结果：" + i);
        return i;
    }, executor).thenRunAsync(() -> {
        System.out.println("任务2启动了...");
    }, executor);

    /**
     * thenAcceptXXX 能接收上一次的执行结果，但没返回值
     * .thenAcceptAsync(res->{
     * System.out.println("任务2启动了..."+res);
     * },executor);
     */
    CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 4;
        System.out.println("运行结果：" + i);
        return i;
    }, executor).thenAcceptAsync(res -> {
        System.out.println("任务2启动了..." + res);
    }, executor);

    /**
     * thenApplyXXX 能接收上一次的执行结果，又可以有返回值
     * .thenApplyAsync(res -> {
     * System.out.println("任务2启动了..." + res);
     * return "hello " + res;
     * }, executor);
     */
    CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
        System.out.println("当前线程" + Thread.currentThread().getId());
        int i = 10 / 4;
        System.out.println("运行结果：" + i);
        return i;
    }, executor).thenApplyAsync(res -> {
        System.out.println("任务2启动了..." + res);
        return "hello " + res;
    }, executor);

    public void run3Task() {

    }
}