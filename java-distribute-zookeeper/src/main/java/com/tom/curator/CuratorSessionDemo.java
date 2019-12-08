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
public class CuratorSessionDemo {
    public static void main(String[] args) {
        //创建session的两种方式
        //正常方式
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONNECT, 4000, 5000, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        System.out.println(curatorFramework.getState());
        //fluent方式
        CuratorFramework curatorFramework1 = CuratorFrameworkFactory.builder().connectString(CONNECT).sessionTimeoutMs(4000).sessionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        curatorFramework1.start();
        System.out.println(curatorFramework1.getState());
    }
}
