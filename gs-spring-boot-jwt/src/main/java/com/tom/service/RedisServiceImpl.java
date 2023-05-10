package com.tom.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

/**
 * xxx
 *
 * @author TomLuo
 * @date 2023年04月22日 16:39
 */
@Slf4j
public final class RedisServiceImpl implements RedisService {
    /**
     * 过期时长
     */
    private final Long DURATION = 1 * 24 * 60 * 60 * 1000L;

    @Resource
    private RedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init() {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void set(String key, String value) {
        valueOperations.set(key, value, DURATION, TimeUnit.MILLISECONDS);
        log.info("key={}, value is: {} into redis cache", key, value);
    }

    @Override
    public String get(String key) {
        String redisValue = valueOperations.get(key);
        log.info("get from redis, value is: {}", redisValue);
        return redisValue;
    }

    @Override
    public boolean delete(String key) {
        boolean result = redisTemplate.delete(key);
        log.info("delete from redis, key is: {}", key);
        return result;
    }

    @Override
    public Long getExpireTime(String key) {
        return valueOperations.getOperations().getExpire(key);
    }
}