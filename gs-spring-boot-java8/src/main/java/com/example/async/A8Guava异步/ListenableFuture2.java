package com.example.async.A8Guava异步;



import com.google.common.util.concurrent.*;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;




/**
 * Guava的ListenableFuture顾名思义就是可以监听的Future，
 * 是对java原生Future的扩展增强。
 * 我们知道Future表示一个异步计算任务，当任务完成时可以得到计算结果。如果我们希望一旦计算完成就拿到结果展示给用户或者做另外的计算，
 * 就必须使用另一个线程不断的查询计算状态。这样做，代码复杂，而且效率低下。
 * 使用「Guava ListenableFuture」 可以帮我们检测Future是否完成了，不需要再通过get()方法苦苦等待异步的计算结果，
 * 如果完成就自动调用回调函数，这样可以减少并发程序的复杂度。
 *
 * ListenableFuture是一个接口，它从jdk的Future接口继承，添加了void addListener(Runnable listener, Executor executor)方法。
 *
 * @author TomLuo
 * @date 2023年03月22日 23:31
 */
@Slf4j
public class ListenableFuture2 {
 //   ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
    /**
     * 首先通过MoreExecutors类的静态方法listeningDecorator方法初始化一个ListeningExecutorService的方法，
     * 然后使用此实例的submit方法即可初始化ListenableFuture对象。
     *
     * ListenableFuture要做的工作，在Callable接口的实现类中定义，这里只是休眠了1秒钟然后返回一个数字1，
     * 有了ListenableFuture实例，可以执行此Future并执行Future完成之后的回调函数。
     */
    ListenableFuture<Integer> future = executorService.submit(() -> {
        Random random = new Random();
        Thread.sleep(random.nextInt(5000));
        return 1;
    });



    // 创建默认的线程池
    private static ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
}