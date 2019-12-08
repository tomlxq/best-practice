package com.tom.curator;

import com.alibaba.fastjson.JSON;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.zookeeper.CreateMode;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class CuratorEventDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 三种watcher来做节点的监听
         * NodeCache 监视一个节点的创建，删除，更新
         * PathChildrenCache 监视一个路径下子节点的创建，删除，节点更新
         * TreeCache NodeCache+PathChildrenCache的合体，监视路径下的创建，删除，更新事件，缓存路径下的所有子节点数据
         */
        String path = "/curator1-1";
        String path2 = path + "/curator2-2/curator2-2";
        String path3 = path + "/curator2-2";
        String path6 = path + "/curator2-2/curator6-6";
        CuratorFramework instance = CuratorUtils.getInstance();
        NodeCache nodeCache = new NodeCache(instance, path, false);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(() -> {
            System.out.println("节点变化后的数据为：" + JSON.toJSONString(nodeCache.getCurrentData(), true));
        });
        PathChildrenCache pathChildrenCache = new PathChildrenCache(instance, path, true);
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        pathChildrenCache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
            PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
            switch (type) {
                case CHILD_ADDED:
                    System.out.println("子节点增加，变化后的数据为：" + JSON.toJSONString(pathChildrenCacheEvent.getData()));
                    break;
                case CHILD_REMOVED:
                    System.out.println("子节点删除，变化后的数据为：" + JSON.toJSONString(pathChildrenCacheEvent.getData()));
                    break;
                case CHILD_UPDATED:
                    System.out.println("子节点更新，变化后的数据为：" + JSON.toJSONString(pathChildrenCacheEvent.getData()));
                    break;
                default:
                    System.out.println(type.name() + ",变化后的数据为：" + JSON.toJSONString(pathChildrenCacheEvent.getData()));
                    break;


            }
        });
        TreeCache treeCache = new TreeCache(instance, path);
        treeCache.start();
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("树节点变化后的数据为：" + JSON.toJSONString(treeCacheEvent.getData()));
            }
        });
        instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path3, "10".getBytes());
        instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path2, "10".getBytes());
        instance.delete().forPath(path2);
        instance.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path6, "10".getBytes());
        instance.setData().forPath(path6, "20".getBytes());
        instance.delete().deletingChildrenIfNeeded().forPath(path);
        System.in.read();
    }
}
