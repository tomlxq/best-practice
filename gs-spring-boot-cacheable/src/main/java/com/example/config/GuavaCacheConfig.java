package com.example.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * //@EnableCaching用来开启注解功能，这里设置的失效时间是3分钟。
 * <p>
 * Guava Cache 除了代码中提到的设置缓存过期时间的策略外，还有其他的策略。下面是 Guava Cache 设置缓存过期时间的策略：
 * <p>
 * expireAfterAccess : 当缓存项在指定的时间段内没有被读或写就会被回收。
 * expireAfterWrite ：当缓存项在指定的时间段内没有更新就会被回收,如果我们认为缓存数据在一段时间后数据不再可用，那么可以使用该种策略。
 * refreshAfterWrite ：当缓存项上一次更新操作之后的多久会被刷新。
 *
 * @author TomLuo
 * @date 2023年03月18日 1:42
 */
@EnableCaching
@Configuration
public class GuavaCacheConfig {

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        expireAfterWrite(3, TimeUnit.MINUTES));
        return cacheManager;
    }
}