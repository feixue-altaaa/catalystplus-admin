package com.catalystplus.admin.util;

import com.catalystplus.admin.entity.Journal;
import com.catalystplus.admin.entity.Paper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * redis操作的工具类
 */
@Slf4j
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


    /**
     * 获取redis中zset数据
     *
     * @param key redis中排行榜类型
     */
    public List<Object> get(String key) {
        try {
            Set<Object> paperIdsObject = redisTemplate.opsForZSet().reverseRange(key, 0, 9);
            List<Object> objects = new ArrayList<>();
            for (Object ob : paperIdsObject) {
                objects.add(ob);
            }
            return objects;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取缓存异常", e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 更新Redis中数据
     *
     * @param key 键
     * @param id  值
     */

    public void update(String key, Long id) {

        try {
            //判断redis该key中是否存在该paperId
            Long pidExist = redisTemplate.opsForZSet().rank(key, id);

            //存在则更新(score++),不存在将paperId存入redis，并设置初始得分为1
            if (pidExist == null) {
                redisTemplate.opsForZSet().add(key, id, 1);
                log.info("redis插入成功");
            } else {
                redisTemplate.opsForZSet().incrementScore(key, id, 1);
                log.info("redis更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForZSet().add(key,value,0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 清空redis
     */
    public void flushDB(String key) {
        try {
          redisTemplate.opsForZSet().remove(key);
        } catch (Exception e) {
            log.info("清空数据异常:{}", e.getLocalizedMessage());
        }
    }

}
