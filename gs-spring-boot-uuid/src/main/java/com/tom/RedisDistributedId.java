package com.tom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Redis 分布式ID生成器
 * Redis INCR 基于全局唯一ID的特性，我们可以通过Redis的INCR命令来生成全局唯一ID
 *
 * @author TomLuo
 * @date 2023年05月07日 23:02
 */
@Component
public class RedisDistributedId {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final long BEGIN_TIMESTAMP = 1659312000l;

    /**
     * 生成分布式ID
     * 符号位    时间戳[31位]  自增序号【32位】
     * @param item
     * @return
     */
    public long nextId(String item){
        // 1.生成时间戳
        LocalDateTime now = LocalDateTime.now();
        // 格林威治时间差
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        // 我们需要获取的 时间戳 信息
        long timestamp = nowSecond - BEGIN_TIMESTAMP;
        // 2.生成序号 --》 从Redis中获取
        // 当前当前的日期
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        // 获取对应的自增的序号
        Long increment = redisTemplate.opsForValue().increment("id:" + item + ":" + date);
        return timestamp << 32 | increment;
    }

}