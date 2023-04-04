package com.example.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 使用对象锁 lock 来同步访问共享资源 sharedVariable，并且在 synchronized 块中尽可能地减小工作量。
 * 在同步代码块中，我们尽量避免调用 RPC 方法，以提高代码的性能。
 *
 * 在高并发场景下，锁的性能损耗确实是一个需要考虑的问题。为了避免锁成为瓶颈，我们可以尽量遵循以下原则：
 *
 * 使用无锁数据结构
 * 在高并发的情况下，无锁数据结构比锁方式的数据结构更加高效。因为无锁数据结构避免了线程之间的竞争，从而提高了并发性能。Java 8 提供了 ConcurrentHashMap 和 ConcurrentLinkedQueue 等无锁数据结构，可以在高并发场景下提供更好的性能。
 *
 * 锁区块而非整个方法
 * 在多线程环境下，将整个方法体加锁的方式会导致所有线程都要先获取锁才能执行，从而造成大量线程的等待和阻塞。因此，我们应该尽可能地将锁作用于代码块而不是整个方法，以减少锁的竞争，提高程序的并发性能。
 *
 * 使用对象锁而非类锁
 * 在 Java 中，对象锁和类锁都可以用于同步访问共享资源。但是，类锁会锁定整个类，而对象锁只会锁定当前对象。因此，如果需要同步访问共享资源，请尽可能使用对象锁而不是类锁。
 *
 * 将锁代码块的工作量尽可能地减小
 * 在锁代码块的情况下，如果工作量过大，会导致其他线程长时间地等待，进而影响整个程序的性能。因此，我们应该将锁代码块的工作量尽可能缩小，以减少其他线程的等待时间。
 *
 * @author TomLuo
 * @date 2023年03月26日 23:03
 */
public class SynchronizedDemo {
    private final Object lock = new Object();
    private int sharedVariable = 0;

    /**
     * increment() 方法使用 synchronized 关键字来同步共享资源 sharedVariable 的访问，
     * 而 heavyCalculation() 和 processResult() 方法的计算过程被放置在同步代码块之外，以尽可能减小同步代码块的工作量。
     */
    public void increment() {
        // 使用对象锁同步共享资源的访问
        synchronized (lock) {
            int localVariable = heavyCalculation();

            // 在同步代码块中修改共享变量
            sharedVariable += localVariable;

            // 尽可能减小同步代码块的工作量
            processResult(localVariable);
        }
    }

    private int heavyCalculation() {
        // 不在同步代码块中调用 RPC 方法
        return ThreadLocalRandom.current().nextInt(100);
    }

    private void processResult(int result) {
        // 不在同步代码块中调用 RPC 方法
        // do something...
    }

    public int getSharedVariable() {
        return sharedVariable;
    }
}