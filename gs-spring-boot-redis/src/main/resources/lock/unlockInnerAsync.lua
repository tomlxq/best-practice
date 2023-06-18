-- org.redisson.RedissonLock#unlock
-- org.redisson.RedissonLock#unlockAsync(long)
-- org.redisson.RedissonLock#unlockInnerAsync
-- 该Lua KEYS有2个Arrays.asList(getName(), getChannelName())
--name 锁名称
--channelName，用于pubSub发布消息的channel名称
--ARGV变量有三个LockPubSub.UNLOCK_MESSAGE, internalLockLeaseTime, getLockName(threadId)
--LockPubSub.UNLOCK_MESSAGE，channel发送消息的类别，此处解锁为0
--internalLockLeaseTime，watchDog配置的超时时间，默认为30s
--lockName 这里的lockName指的是uuid和threadId组合的唯一值
--步骤如下：
--    1.如果该锁不存在则返回nil；
--    2.如果该锁存在则将其线程的hash key计数器-1，
--    3.计数器counter>0，重置下失效时间，返回0；否则，删除该锁，发布解锁消息unlockMessage，返回1；

-- 不存在key
if (redis.call('hexists', KEYS[1], ARGV[3]) == 0) then
    return nil;
end;
-- 计数器 -1
local counter = redis.call('hincrby', KEYS[1], ARGV[3], -1);
if (counter > 0) then
    -- 过期时间重设
    redis.call('pexpire', KEYS[1], ARGV[2]);
    return 0;
else
    -- 删除并发布解锁消息
    redis.call('del', KEYS[1]);
    redis.call('publish', KEYS[2], ARGV[1]);
    return 1;
end;
return nil;