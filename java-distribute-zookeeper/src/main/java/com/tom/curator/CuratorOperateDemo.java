package com.tom.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.tom.Constant.UTF8;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class CuratorOperateDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework instance = CuratorUtils.getInstance();
        //创建节点
        String path = "/curator1-1";
        String path2 = path + "/curator2-2/curator2-2";
        String result = instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .forPath(path2, "123".getBytes());
        System.out.println("操作结果->" + result);
        //获得数据
        Stat stat = new Stat();
        String data = new String(instance.getData().storingStatIn(stat).forPath(path2), UTF8);
        System.out.println("获得数据->" + data + " --> stat" + stat);
        //更新
        stat = instance.setData().forPath(path2, "789".getBytes(UTF8));
        System.out.println("更新数据->" + stat);
        // 异步操作
        Executor executor = Executors.newFixedThreadPool(1);
        String path3 = path + "/curator2-2/curator3-3";
        CountDownLatch countDownLatch = new CountDownLatch(1);
        result = instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                        System.out.println("当前线程号：" + Thread.currentThread().getName() + " ResultCode：" + curatorEvent.getResultCode() + " -> Type：" + curatorEvent.getType());
                        countDownLatch.countDown();
                    }
                }, executor).forPath(path3, "123".getBytes());
        System.out.println("异步操作结果->" + result);
        countDownLatch.await();
        // 事务操作(curator独有的）
        String path4 = path + "/curator2-2/curator4-4";
        String path5 = path + "/curator2-2/curator5-5";
        Collection<CuratorTransactionResult> commit = instance.inTransaction()
                .create().forPath(path4, "123".getBytes())
                .and().create().forPath(path5, "123".getBytes())
                .and().setData().forPath(path5, "6789".getBytes())
                .and().commit();
        commit.forEach(transactionResult -> {
            System.out.println(transactionResult.getResultPath() + " --> " + transactionResult.getType() + " --> " + transactionResult.getResultStat());
        });
        //删除节点
        instance.delete().deletingChildrenIfNeeded().forPath(path);

    }
}
