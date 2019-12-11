package com.tom.lock.javaapi;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import static com.tom.Constant.CONNECT;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/11
 */
public class ZooKeeperClient {
    private static final int SESSION_TIMEOUT = 5000;

    public static ZooKeeper getInstance() throws IOException, InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

}
