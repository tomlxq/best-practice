package com.example.async.A2Future;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 4.2 Future异步
 * Future的不足之处的包括以下几点：
 *
 * 1️⃣ 无法被动接收异步任务的计算结果：
 * 虽然我们可以主动将异步任务提交给线程池中的线程来执行，但是待异步任务执行结束之后，
 * 主线程无法得到任务完成与否的通知，它需要通过get方法主动获取任务执行的结果。
 * 2️⃣ Future件彼此孤立：有时某一个耗时很长的异步任务执行结束之后，你想利用它返回的结果再做进一步的运算，
 * 该运算也会是一个异步任务，两者之间的关系需要程序开发人员手动进行绑定赋予，Future并不能将其形成一个任务流（pipeline）
 * ，每一个Future都是彼此之间都是孤立的，所以才有了后面的CompletableFuture，CompletableFuture就可以将多个Future串联起来形成任务流。
 * 3️⃣ Futrue没有很好的错误处理机制：截止目前，如果某个异步任务在执行发的过程中发生了异常，调用者无法被动感知，
 * 必须通过捕获get方法的异常才知晓异步任务执行是否出现了错误，从而在做进一步的判断处理。
 *
 * @author TomLuo
 * @date 2023年03月22日 22:55
 */
@Slf4j
public class FutureManager {

    public String execute() throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                System.out.println(" --- task start --- ");
                Thread.sleep(3000);
                System.out.println(" --- task finish ---");
                return "this is future execute final result!!!";
            }
        });

        //这里需要返回值时会阻塞主线程
        String result = future.get();
        log.info("Future get result: {}", result);
        return result;
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureManager manager = new FutureManager();
        manager.execute();
    }
}