package com.guide.tool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * IDDemoTest
 *
 * @author TomLuo
 * @date 2023年04月17日 6:30
 */
@Slf4j
public class IDDemoTest {
    private final long workerId = 0;
    private final long datacenterId = 1;

    @Test
    void name() {

//生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        log.info("uuid: " + uuid);
//生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        log.info("simpleUUID: " + simpleUUID);
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);

        log.info("snowflake nextId: " + snowflake.nextId());

    }
}