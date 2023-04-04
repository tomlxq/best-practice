package com.example.thread;

/**
 * @author TomLuo
 * @date 2023年03月26日 23:07
 */

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
@Data
public class ConcurrentHashMapDemo {
    /**
     * ConcurrentHashMap 是线程安全的哈希表实现
     */
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void put(String key, Integer value) {
        map.put(key, value);
    }

    public Integer get(String key) {
        return map.get(key);
    }

    /**
     * ConcurrentLinkedQueue 是线程安全的队列实现
     */

    private ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public void produce(String element) {
        queue.offer(element);
    }

    public String consume() {
        return queue.poll();
    }
}