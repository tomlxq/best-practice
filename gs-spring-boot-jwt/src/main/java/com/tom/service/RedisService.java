package com.tom.service;

/**
 * RedisService
 *
 * @author TomLuo
 * @date 2023年04月22日 16:39
 */
public interface RedisService {
    void set(String key, String value);

    String get(String key);

    boolean delete(String key);

    Long getExpireTime(String key);
}
