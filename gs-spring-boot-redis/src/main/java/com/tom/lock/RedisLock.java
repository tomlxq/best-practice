package com.tom.lock;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.Collections;
import java.util.UUID;

/**
 * ww
 *
 * @author TomLuo
 * @date 2023年06月13日 20:36
 */
@Getter
@Setter
public class RedisLock {

    private RedisTemplate redisTemplate;
    private DefaultRedisScript<Long> lockScript;
    private DefaultRedisScript<Object> unlockScript;

    public RedisLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        // 加载加锁的脚本
        lockScript = new DefaultRedisScript<>();
        this.lockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lock/lock.lua")));
        this.lockScript.setResultType(Long.class);
        // 加载释放锁的脚本
        unlockScript = new DefaultRedisScript<>();
        this.unlockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lock/unlock.lua")));
    }

    /**
     * 获取锁
     */
    public String tryLock(String lockName, long releaseTime) {
        // 存入的线程信息的前缀
        String key = UUID.randomUUID().toString();

        // 执行脚本
        Long result = (Long) redisTemplate.execute(
                lockScript,
                Collections.singletonList(lockName),
                key + Thread.currentThread().getId(),
                releaseTime);

        if (result != null && result.intValue() == 1) {
            return key;
        } else {
            return null;
        }
    }

    /**
     * 解锁
     * @param lockName
     * @param key
     */
    public void unlock(String lockName, String key) {
        redisTemplate.execute(unlockScript,
                Collections.singletonList(lockName),
                key + Thread.currentThread().getId()
        );
    }
}