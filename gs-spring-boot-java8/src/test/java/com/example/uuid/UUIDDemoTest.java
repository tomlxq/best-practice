package com.example.uuid;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Twitter的分布式自增ID算法，Snowflake
 * <p>
 * 最初Twitter把存储系统从MySQL迁移到Cassandra（由Facebook开发一套开源分布式NoSQL数据库系统）因为Cassandra没有顺序ID生成机制，所有开发了这样一套全局唯一ID生成服务。
 * Twitter的分布式雪花算法SnowFlake，经测试SnowFlake每秒可以产生26万个自增可排序的ID
 * twitter的SnowFlake生成ID能够按照时间有序生成
 * SnowFlake算法生成ID的结果是一个64Bit大小的整数，为一个Long型（转换成字符串后长度最多19）
 * 分布式系统内不会产生ID碰撞（由datacenter 和 workerID做区分）并且效率较高
 * 分布式系统中，有一些需要全局唯一ID的场景，生成ID的基本要求
 *
 * @author TomLuo
 * @date 2023年04月04日 23:08
 */
@Slf4j
class UUIDDemoTest {
    /**
     * UUID
     * UUID.randomUUID(), UUID的标准型包含32个16进制数字，以连字号分为五段，形式为 8-4-4-4-12的36个字符，性能非常高，本地生成，没有网络消耗。
     * 存在问题
     * 1)入数据库性能差，因为UUID是无序的
     * 2)主键，ID作为主键时，在特定的环境下会存在一些问题
     * 比如做DB主键的场景下，UUID就非常不适用MySQL官方有明确的说明
     * 3)索引，B+树索引的分裂
     * 既然分布式ID是主键，然后主键是包含索引的，而mysql的索引是通过B+树来实现的，每一次新的UUID数据的插入，为了查询的优化，都会对索引底层的B+树进行修改，因为UUID数据是无序的，所以每一次UUID数据的插入都会对主键的B+树进行很大的修改，这一点很不好，插入完全无序，不但会导致一些中间节点产生分裂，也会白白创造出很多不饱和的节点，这样大大降低了数据库插入的性能。
     * 4)UUID只能保证全局唯一性，不满足后面的趋势递增，单调递增
     */
    @Test
    void name() {
        log.info("UUID.randomUUID() {}", UUID.randomUUID());
    }

    @Test
    void name2() {
        SnowFlakeDemo snowFlakeDemo = new SnowFlakeDemo();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                log.info("{}", snowFlakeDemo.snowflakeId());
            }, String.valueOf(i)).start();
        }
    }

}