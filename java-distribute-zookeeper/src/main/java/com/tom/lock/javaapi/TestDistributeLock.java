package com.tom.lock.javaapi;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static com.tom.lock.javaapi.DistributeLock.DATA;
import static com.tom.lock.javaapi.DistributeLock.ROOT_LOCK;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/11
 */
public class TestDistributeLock {
    private static synchronized void createRootLock() throws KeeperException, InterruptedException, IOException {
        final CountDownLatch lock = new CountDownLatch(1);
        ZooKeeper instance = ZooKeeperClient.getInstance();
        Stat exists = instance.exists(ROOT_LOCK, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                    lock.countDown();
                }
            }
        });
        if (exists == null) {
            String result = instance.create(ROOT_LOCK, DATA, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            lock.await();
            System.out.println("创建根节点：" + result);
        }
    }

    public static void main(String[] args) {
        try {
            createRootLock();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(10);

        Random random = new Random();
        for (int idx = 0; idx < 10; idx++) {
            new Thread(() -> {
                DistributeLock lock = null;
                try {
                    lock = new DistributeLock();
                    countDownLatch.countDown();
                    countDownLatch.await();
                    lock.lock();
                    Thread.sleep(random.nextInt(500));
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }).start();

        }
    }
}
