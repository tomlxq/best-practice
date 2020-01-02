package com.tom.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

import static com.tom.Constant.CONNECT;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/28
 */
public class MasterSelector {
    private static final String MASTER_PATH = "/MASTER_SELECTOR";

    public static void main(String[] args) throws Exception {
        CuratorFramework build = CuratorFrameworkFactory.builder().connectString(CONNECT).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        LeaderSelector leaderSelector = new LeaderSelector(build, MASTER_PATH, new LeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                System.out.println("获得Leader成功");
                TimeUnit.SECONDS.sleep(3);
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {

            }
        });
        leaderSelector.autoRequeue();
        //开始竞争
        leaderSelector.start();
        build.start();
        System.out.println(build.getState());
        String result = build.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath(MASTER_PATH+"/create_order", "123".getBytes());
        System.out.println("完成选举"+result);
    }
}
