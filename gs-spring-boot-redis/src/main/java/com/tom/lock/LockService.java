package com.tom.lock;

import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * LockService
 * <p>
 * 结构
 * if(tryLock())
 * <p>
 * {
 * // todo
 * }finally{
 * unlock();
 * }
 *
 * @author TomLuo
 * @date 2023年06月18日 3:17
 */
@Service
public class LockService {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean tryLock(String key, String value, long timeout, TimeUnit unit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeout, unit);
    }

    public void unlock2(String lockName, String uuid) {
        // 解锁脚本
        DefaultRedisScript<Object> unlockScript = new DefaultRedisScript();
        unlockScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lock/lockDel.lua")));
        // 执行lua脚本解锁
        String keyName = "jack";
        Integer value = 123;
        redisTemplate.execute(unlockScript, Collections.singletonList(keyName), value);
    }


    /**
     * 解锁，防止删错别人的锁，以uuid为value校验是否自己的锁
     *
     * @param lockName
     * @param uuid
     */
    public void unlock(String lockName, String uuid) {
        if (uuid.equals(redisTemplate.opsForValue().get(lockName))) {
            redisTemplate.delete(lockName);
        }
    }
}