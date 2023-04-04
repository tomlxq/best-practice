package com.example.uuid;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

import javax.annotation.PostConstruct;

/**
 * 雪花算法
 *
 * @author TomLuo
 * @date 2023年04月04日 23:37
 */
public class SnowFlakeDemo {
    private long workerId = 0;
    private long datacenterId = 1;
    private Snowflake snowFlake = IdUtil.createSnowflake(workerId, datacenterId);

    /**
     * 将网络ip转换成long
     */
    @PostConstruct
    public void init() {
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
    }

    /**
     * 获取雪花ID
     *
     * @return
     */
    public synchronized long snowflakeId() {
        return this.snowFlake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}