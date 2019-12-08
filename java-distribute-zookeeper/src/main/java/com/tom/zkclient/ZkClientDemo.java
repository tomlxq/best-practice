package com.tom.zkclient;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

import static com.tom.Constant.CONNECT;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/8
 */
public class ZkClientDemo {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(CONNECT, 40000);
        System.out.println(zkClient + " 联接成功");
        // 递归创建路径的功能
        String path = "/zkclient1";
        String path1 = "/zkclient2";
        String path2 = path1 + "/zkclient2-1";
        zkClient.createEphemeral(path, "123");
        zkClient.createPersistent(path2, true);
        //获取子节点
        List<String> children = zkClient.getChildren(path1);
        System.out.println("获取子节点：" + JSON.toJSONString(children, true));
        //事件订阅
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("事件监听->数据变化的节点为：" + s + "-->数据变化的值为：" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("事件监听->删除的节点为：" + s);
            }
        });
        zkClient.subscribeChildChanges(path1, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println("事件监听->子节点变化的节点为：" + s + "-->变化的子集点：" + JSON.toJSONString(list));
            }
        });
        zkClient.writeData(path, "123456");
        zkClient.createEphemeral(path1 + "/zkclient2-2");
        // 删除功能
        boolean delete = zkClient.delete(path);
        if (delete) {
            System.out.println("删除" + path + "成功！");
        }
        delete = zkClient.deleteRecursive("/zkclient2");
        if (delete) {
            System.out.println("删除" + path1 + "成功！");
        }
    }
}
