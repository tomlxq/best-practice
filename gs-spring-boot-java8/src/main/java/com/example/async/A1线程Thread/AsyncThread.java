package com.example.async.A1线程Thread;

/**
 * 4.1 线程异步 如果每次都创建一个Thread线程，频繁的创建、销毁，浪费系统资源，我们可以采用线程池
 *
 * @author TomLuo
 * @date 2023年03月22日 22:51
 */
public class AsyncThread extends Thread {

    @Override
    public void run() {
        System.out.println("Current thread name:" + Thread.currentThread().getName() + " Send email success!");
    }

    public static void main(String[] args) {
        AsyncThread asyncThread = new AsyncThread();
        asyncThread.run();
    }
}