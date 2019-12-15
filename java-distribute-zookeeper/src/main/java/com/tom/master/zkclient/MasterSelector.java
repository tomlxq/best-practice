package com.tom.master.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/12/12
 */
public class MasterSelector {
    /**
     * master选举节点
     */
    private final static String MASTER_ROOT = "/master";
    private ZkClient zkClient;
    /**
     * master节点
     */
    private UserCenter master;
    /**
     * 其它服务器
     */
    private UserCenter server;
    /**
     * 节点内容的变化
     */
    private IZkDataListener dataListener;
    /**
     * 是否在选举
     */
    private boolean isRunning = false;

    public MasterSelector(ZkClient zkClient, UserCenter server) {
        System.out.println("服务器" + server.getMcName() + "来争抢master");
        this.zkClient = zkClient;
        this.server = server;
        this.dataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("解发节点删除事件：" + s);
//如果根节点被删除发起选举操作
                chooseMaster();
            }
        };
    }

    private boolean isMaster() {
        UserCenter userCenter = zkClient.readData(MASTER_ROOT, true);
        if (userCenter != null && StringUtils.equals(userCenter.getMcName(), this.server.getMcName())) {
            this.master = userCenter;
            return true;
        }
        return false;
    }


    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    private void chooseMaster() {
        if (!isRunning) {
            System.out.println("服务没有启动");
            return;
        }
        try {
            this.zkClient.createEphemeral(MASTER_ROOT, this.server);
            this.master = this.server;
            System.out.println(this.server.getMcName() + "选举成功，你们都要听我的！");
            //模拟出故障
            executorService.schedule(() -> {
                //master服务器挂了，其它服务器要顶上
                releaseMaster();
            }, 1, TimeUnit.SECONDS);

        } catch (ZkNodeExistsException e) {
            UserCenter userCenter = this.zkClient.readData(MASTER_ROOT, true);
            //master服务器不存在
            if (userCenter == null) {
                chooseMaster();
            } else {
                this.master = userCenter;
            }
        }
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            zkClient.subscribeDataChanges(MASTER_ROOT, dataListener);
            chooseMaster();
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            executorService.shutdown();
            zkClient.unsubscribeDataChanges(MASTER_ROOT, dataListener);
            releaseMaster();
        }

    }

    private void releaseMaster() {
        if (isMaster()) {
            this.zkClient.delete(MASTER_ROOT);
        }
    }
}
