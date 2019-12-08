package com.tom.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import static com.tom.Constant.CONNECT;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class CuratorUtils {
    private static CuratorFramework curatorFramework;

    public static CuratorFramework getInstance() {
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(CONNECT)
                .connectionTimeoutMs(4000)
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .namespace("curator")
                .build();
        curatorFramework.start();
        System.out.println(curatorFramework.getState());
        return curatorFramework;
    }
}
