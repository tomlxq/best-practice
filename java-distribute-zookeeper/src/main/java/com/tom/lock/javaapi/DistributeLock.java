package com.tom.lock.javaapi;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/11
 */
public class DistributeLock {
    public final static String ROOT_LOCK = "/LOCK";
    ZooKeeper instance;
    /**
     * 记录会话超时时间
     */
    int sessionTimeout = 0;
    public final static byte[] DATA = new byte[]{1, 2};
    /**
     * 记录锁节点ID
     */
    String lockId;
    private CountDownLatch countDownLatch;

    public DistributeLock() throws IOException, InterruptedException, KeeperException {
        this.instance = ZooKeeperClient.getInstance();
        this.sessionTimeout = instance.getSessionTimeout();
        this.countDownLatch = new CountDownLatch(1);
    }


    public boolean lock() {
        try {
            this.lockId = this.instance.create(ROOT_LOCK + "/", DATA, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            String name = Thread.currentThread().getName();
            System.out.println(name + "成功的创建了节点" + this.lockId + "，开始去竞争锁");
            List<String> children = this.instance.getChildren(ROOT_LOCK, true);
            SortedSet<String> objects = new TreeSet<>();
            children.forEach(child -> {
                objects.add(ROOT_LOCK + "/" + child);
            });
            String first = objects.first();
            if (StringUtils.equals(first, this.lockId)) {
                System.out.println(name + "成功的获取了锁，节点为【" + this.lockId + "】");
                return true;
            }
            SortedSet<String> lessThanLockId = objects.headSet(this.lockId);
            if (!lessThanLockId.isEmpty()) {
                String preLockId = lessThanLockId.last();
                this.instance.exists(preLockId, new WatcherLock(this.countDownLatch));
                //表示删除了节点或会话超时
                this.countDownLatch.await(this.sessionTimeout, TimeUnit.MILLISECONDS);
                System.out.println(name + " 成功的获得了锁：【" + this.lockId + "】");
                return true;
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean unlock() {
        System.out.println(Thread.currentThread().getName() + "->开始释放锁");
        try {
            this.instance.delete(this.lockId, -1);
            System.out.println(Thread.currentThread().getName() + "节点" + this.lockId + "被成功删除");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }
}
