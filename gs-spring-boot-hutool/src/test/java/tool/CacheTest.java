package tool;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.date.DateUnit;
import org.junit.jupiter.api.Test;

/**
 * Hutool 提供了常见的几种缓存策略的实现：
 * <p>
 * FIFO(first in first out) ：先进先出策略。
 * LFU(least frequently used) ：最少使用率策略。
 * LRU(least recently used) ：最近最久未使用策略。
 * Timed ：定时策略。
 * Weak ：弱引用策略。
 * 并且，Hutool 还支持将小文件以 byte[] 的形式缓存到内容中，减少文件的访问，以解决频繁读取文件引起的性能问题。
 *
 * @author TomLuo
 * @date 2023年04月18日 6:01
 */
public class CacheTest {
    /**
     * FIFO(first in first out) 策略缓存使用
     */
    @Test
    public void test() {
        Cache<String, String> fifoCache = CacheUtil.newFIFOCache(3);

//加入元素，每个元素可以设置其过期时长，DateUnit.SECOND.getMillis()代表每秒对应的毫秒数，在此为3秒
        fifoCache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        fifoCache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);

//由于缓存容量只有3，当加入第四个元素的时候，根据FIFO规则，最先放入的对象将被移除
        fifoCache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);

//value1为null
        String value1 = fifoCache.get("key1");
    }
}