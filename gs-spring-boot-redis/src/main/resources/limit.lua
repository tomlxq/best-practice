local count
count = redis.call('get',KEYS[1])
--不超过最大值，则直接返回
if count and tonumber(count)>tonumber(ARGV[1]) then
    return count;
end
--执行计算器自加
count = redis.call('incr',KEYS[1])
if tonumber(count) == 1 then
    --从第一次调用开始限流，设置对应key的过期时间
    redis.call('expire',KEYS[1],ARGV[2])
end
return count;