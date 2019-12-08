package com.tom;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class ApiOperateDemo implements Watcher {
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(Constant.CONNECT, 5000, new ApiOperateDemo());
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        System.out.println("~~~~~创建临点节点~~~~~");
        String tempPath = "/rose";
        String result = zooKeeper.create(tempPath, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("创建结果：" + result);
        System.out.println("~~~~~修改节点值~~~~~");
        Stat stat2 = zooKeeper.setData(tempPath, "123".getBytes(), -1);
        System.out.println("改变值：" + stat2);
        stat2 = zooKeeper.setData(tempPath, "456".getBytes(), -1);
        System.out.println("改变值：" + stat2);
        System.out.println("~~~~~查询节点~~~~~");
        byte[] data = zooKeeper.getData(tempPath, new ApiOperateDemo(), stat);
        System.out.println(new String(data, UTF8));
        System.out.println("~~~~~删除点节~~~~~");
        zooKeeper.delete(tempPath, -1);

        System.out.println("~~~~~创建节点和子节点,只有持久化节点才有子节点~~~~~");
        String tempPath2 = "/tom";
        String tempPath3 = tempPath2 + "/tom1-1";
        Stat exists = zooKeeper.exists(tempPath2, true);
        if (exists == null) {
            result = zooKeeper.create(tempPath2, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建结果：" + result);
        }
        exists = zooKeeper.exists(tempPath3, true);
        if (exists == null) {
            result = zooKeeper.create(tempPath3, "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建结果：" + result);
        }
        System.out.println("~~~~~修改子路径的值~~~~~");
        stat2 = zooKeeper.setData(tempPath3, "456".getBytes(), -1);
        System.out.println("改变值：" + stat2);
        System.out.println("~~~~~删除持久化节点~~~~~");
        zooKeeper.delete(tempPath3, -1);
        zooKeeper.delete(tempPath2, -1);

    }

    @Override
    public void process(WatchedEvent event) {

        //如果当前连接是成功的，那么通过计数器去控制
        if (event.getState() != Event.KeeperState.SyncConnected) {
            return;
        }
        try {
            Event.EventType type = event.getType();
            String path = event.getPath();
            if (type == Event.EventType.None && null == path) {
                countDownLatch.countDown();
            } else if (type == Event.EventType.NodeChildrenChanged) {
                System.out.println("路径：" + path + " Type：" + type + " 子节点变化，值：" + new String(zooKeeper.getData(path, true, stat), UTF8));
            } else if (type == Event.EventType.NodeCreated) {
                System.out.println("路径：" + path + " Type：" + type + " 子节点变化，值：" + new String(zooKeeper.getData(path, true, stat), UTF8));
            } else if (type == Event.EventType.NodeDataChanged) {
                System.out.println("路径：" + path + " Type：" + type + " 子节点变化，值：" + new String(zooKeeper.getData(path, true, stat), UTF8));
            } else if (type == Event.EventType.NodeDeleted) {
                System.out.println("路径：" + path + " Type：" + type + " 子节点变化");
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
