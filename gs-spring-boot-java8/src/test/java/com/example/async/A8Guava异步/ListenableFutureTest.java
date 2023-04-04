package com.example.async.A8Guava异步;
import com.google.common.util.concurrent.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
@Slf4j
public class ListenableFutureTest {



    @Test
    public void testListenableFuture() throws Exception {
        // 定义一个计数器用于控制测试完成
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 创建异步任务
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(EXECUTOR);
        ListenableFuture<Integer> future = executorService.submit(() -> {
            Random random = new Random();
            Thread.sleep(random.nextInt(5000));
            return 1;
        });

        // 定义回调函数
        Futures.addCallback(future, new FutureCallback<>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("异步任务成功完成，结果为：" + result);
                assertEquals(1, result.intValue());
                countDownLatch.countDown(); // 任务完成，释放计数器，通知测试完成
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("异步任务异常，原因为：" + t.getMessage());
                countDownLatch.countDown(); // 任务完成（异常），释放计数器，通知测试完成
            }
        }, executorService);

        // 等待异步任务完成（最多等待10秒）
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    private static final String THREAD_NAME_PREFIX = "listenable-future-thread-";

    private static final int QUEUE_CAPACITY = 5;

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            THREAD_POOL_SIZE,
            THREAD_POOL_SIZE,
            0L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadFactoryBuilder().setNameFormat(THREAD_NAME_PREFIX + "%d").build(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Test
    public void testListenableFuture2() throws Exception {
        // 定义一个计数器用于控制测试完成
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 创建异步任务
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(EXECUTOR);

        // 提交多个任务，超出队列长度
        for (int i = 0; i < QUEUE_CAPACITY * 2; i++) {
            ListenableFuture<Integer> future = executorService.submit(() -> {
                Random random = new Random();
                Thread.sleep(random.nextInt(5000));
                return 1;
            });

            // 定义回调函数
            Futures.addCallback(future, new FutureCallback<>() {
                @Override
                public void onSuccess(Integer result) {
                    System.out.println("异步任务成功完成，结果为：" + result);
                    assertEquals(1, result.intValue());
                    countDownLatch.countDown(); // 任务完成，释放计数器，通知测试完成
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.println("异步任务异常，原因为：" + t.getMessage());
                    countDownLatch.countDown(); // 任务完成（异常），释放计数器，通知测试完成
                }
            }, executorService);
        }

        // 等待异步任务完成（最多等待10秒）
        countDownLatch.await(10, TimeUnit.SECONDS);

        // 验证最后队列中还有任务没有执行
        int activeCount = EXECUTOR.getActiveCount();
        int queueSize = EXECUTOR.getQueue().size();
        int maximumPoolSize = EXECUTOR.getMaximumPoolSize();
        log.info("maximumPoolSize {}",maximumPoolSize);
        log.info("queueSize {}",queueSize);
        log.info("activeCount {}",activeCount);
        int actualTaskCount = maximumPoolSize - activeCount - queueSize;
        assertEquals(3, actualTaskCount);
    }

}

