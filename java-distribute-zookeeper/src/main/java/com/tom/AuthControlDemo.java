package com.tom;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static com.tom.Constant.UTF8;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class AuthControlDemo implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(Constant.CONNECT, 5000, new AuthControlDemo());
        countDownLatch.await();
        zooKeeper.addAuthInfo("digest", "root:root".getBytes(UTF8));
        System.out.println(zooKeeper.getState());
        String tempPath1 = "/auth1";
        createNode(zooKeeper, tempPath1, null);
        ACL acl = new ACL(ZooDefs.Perms.CREATE, new Id("digest", "root:root"));
        ACL acl2 = new ACL(ZooDefs.Perms.CREATE, new Id("ip", "192.168.238.100"));
        List<ACL> acls = Arrays.asList(acl, acl2);
        String tempPath2 = "/auth2";
        createNode(zooKeeper, tempPath2, acls);
        countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper2 = new ZooKeeper(Constant.CONNECT, 5000, new AuthControlDemo());
        countDownLatch.await();
        zooKeeper2.delete(tempPath1, -1);
        zooKeeper2.delete(tempPath2, -1);
    }

    private static void createNode(ZooKeeper zooKeeper, String tempPath1, List<ACL> acls) throws KeeperException, InterruptedException {
        Stat exists = zooKeeper.exists(tempPath1, true);
        if (exists == null) {
            if (acls == null) {
                acls = ZooDefs.Ids.CREATOR_ALL_ACL;
            }
            String result = zooKeeper.create(tempPath1, "123".getBytes(), acls, CreateMode.PERSISTENT);
            System.out.println("创建结果：" + result);
        }
    }

    @Override
    public void process(WatchedEvent event) {

        //如果当前连接是成功的，那么通过计数器去控制
        if (event.getState() != Event.KeeperState.SyncConnected) {
            return;
        }
        Event.EventType type = event.getType();
        String path = event.getPath();
        if (type == Event.EventType.None && null == path) {
            countDownLatch.countDown();
        }
    }
}
