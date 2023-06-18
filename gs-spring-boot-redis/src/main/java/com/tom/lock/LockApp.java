package com.tom.lock;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

/**
 * LockApp
 *
 * @author TomLuo
 * @date 2023年06月13日 20:17
 */
@SpringBootApplication(scanBasePackages = "com.tom.lock")
//@EnableCaching
@Slf4j
public class LockApp implements CommandLineRunner {


    public static void main(String[] args) {
        args = new String[]{"--spring.config.location=classpath:lock/application.yml"};
        SpringApplication.run(LockApp.class, args);
    }






    @Override
    public void run(String... args) throws Exception {


        String lockName = "lock";
        long expireTime = 5;

        method2(lockName,expireTime);
    }
    @Resource
    private RedissonClient redissonClient;

    /**
     * org.redisson.RedissonLock#tryLock(long, long, java.util.concurrent.TimeUnit)
     * org.redisson.RedissonLock#tryAcquire(long, long, java.util.concurrent.TimeUnit, long)
     * org.redisson.RedissonLock#tryAcquireAsync(long, long, java.util.concurrent.TimeUnit, long)
     * org.redisson.RedissonLock#tryLockInnerAsync(long, long, java.util.concurrent.TimeUnit, long, org.redisson.client.protocol.RedisStrictCommand)
     *
     * @param lockName
     * @param expireTime
     */
    public void method2(String lockName, long expireTime) {
        RLock rLock = redissonClient.getLock(lockName);
        try {
            boolean isLocked = rLock.tryLock(expireTime, TimeUnit.SECONDS);
            logger.info("{} {}", lockName, isLocked);
            if (isLocked) {
                logger.info("{} is locked", lockName);
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (Exception e) {
            logger.error("error", e);

        } finally {
            rLock.unlock();
            logger.info("{} is unlocked", lockName);
        }
    }



}