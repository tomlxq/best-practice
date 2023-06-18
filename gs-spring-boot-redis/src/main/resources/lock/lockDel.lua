if redis.call('get', KEYS[1]) == ARGV[1]
then
    -- 执行删除操作
    return redis.call('del', KEYS[1])
else
    -- 不成功，返回0
    return 0
end