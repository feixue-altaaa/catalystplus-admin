package com.catalystplus.admin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis操作的工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 将bitmap中的offset为设置为value
    public void setBit(String key, Long offset, boolean value) {
        redisTemplate.opsForValue().setBit(key, offset, value);
    }

    // 获取bitmap中bit为1的数量
    public Long bitCount(String key) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.bitCount(key.getBytes()));
    }

    // 将两个bitmap做AND运算，得到新的bitmap中bit为1的数量
    public Long bitOperationAnd(String key, String key1, String key2) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> {
            connection.bitOp(RedisStringCommands.BitOperation.AND,
                    key.getBytes(), key1.getBytes(), key2.getBytes());
            return connection.bitCount(key.getBytes());
        });
    }
}
