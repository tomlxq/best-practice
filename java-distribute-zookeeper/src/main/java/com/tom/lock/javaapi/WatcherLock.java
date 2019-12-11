package com.tom.lock.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/11
 */
public class WatcherLock implements Watcher {
    private CountDownLatch countDownLatch;

    public WatcherLock(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
            countDownLatch.countDown();
        }
    }
}
