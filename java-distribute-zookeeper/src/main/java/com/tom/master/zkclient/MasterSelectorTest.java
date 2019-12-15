package com.tom.master.zkclient;

import com.google.common.collect.Lists;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static com.tom.Constant.CONNECT;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/12
 */
public class MasterSelectorTest {
    public static void main(String[] args) throws IOException {
        List<MasterSelector> list = Lists.newArrayList();
        try {
            IntStream.range(0, 10).forEach(idx -> {
                ZkClient zkClient = new ZkClient(CONNECT, 5000, 5000, new SerializableSerializer());
                UserCenter userCenter = new UserCenter(idx, "服务器" + idx);
                MasterSelector masterSelector = new MasterSelector(zkClient, userCenter);
                masterSelector.start();
                list.add(masterSelector);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } finally {
            list.stream().forEach(masterSelector ->
                    masterSelector.stop()
            );
        }
        System.in.read();

    }
}
