-- org.redisson.RedissonLock#tryLockInnerAsync(long, long, java.util.concurrent.TimeUnit, long, org.redisson.client.protocol.RedisStrictCommand)
--  keyName
-- KEYS[1] = Collections.singletonList(this.getName())
--  leaseTime
-- ARGV[1] = this.internalLockLeaseTime
--  uuid+threadId组合的唯一值
-- ARGV[2] = this.getLockName(threadId)
--     判断该锁是否已经有对应hash表存在，
--    • 没有对应的hash表：则set该hash表中一个entry的key为锁名称，value为1，之后设置该hash表失效时间为leaseTime
--    • 存在对应的hash表：则将该lockName的value执行+1操作，也就是计算进入次数，再设置失效时间leaseTime
--    • 最后返回这把锁的ttl剩余时间
-- 不存在该key时
if (redis.call('exists', KEYS[1]) == 0) then
    -- 新增该锁并且hash中该线程id对应的count置1
    redis.call('hincrby', KEYS[1], ARGV[2], 1);
    -- 设置过期时间
    redis.call('pexpire', KEYS[1], ARGV[1]);
    return nil;
end;
-- 存在该key 并且 hash中线程id的key也存在
if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then
    -- 线程重入次数++
    redis.call('hincrby', KEYS[1], ARGV[2], 1);
    redis.call('pexpire', KEYS[1], ARGV[1]);
    return nil;
end;
return redis.call('pttl', KEYS[1]);