package com.unfbx.common.web.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作工具类基于RedisTemplate
 */
public class RedisUtils<K, V> {

    private RedisUtils() {
    }

    private static RedisTemplate<String, Object> redisTemplate = SpringUtils.getBean(RedisTemplate.class);

    public static boolean expire(String key, long timeout, TimeUnit timeUnit) {
        Boolean result = redisTemplate.expire(key, timeout, timeUnit);
        return Objects.nonNull(result) && result;
    }

    public static boolean expire(String key, long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    public static boolean del(String key) {
        return redisTemplate.delete(key);
    }

    public static long del(Collection<String> keys) {
        Long result = redisTemplate.delete(keys);
        return Objects.isNull(result) ? 0 : result;
    }

    public static void set(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
    }

    public static void set(String key, Object object, long timeout) {
        set(key, object, timeout, TimeUnit.SECONDS);
    }

    public static void set(String key, Object object, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, object, timeout, timeUnit);
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static long setSet(String key, Object... objects) {
        Long result = redisTemplate.opsForSet().add(key, objects);
        return Objects.isNull(result) ? 0 : result;
    }

    public static long setDel(String key, Object... objects) {
        Long result = redisTemplate.opsForSet().remove(key, objects);
        return Objects.isNull(result) ? 0 : result;
    }

    public static Set<Object> getSet(String key) {
        Set<Object> members = redisTemplate.opsForSet().members(key);
        return members;
    }

    public static boolean setIsMember(String key, Object object) {
        Boolean member = redisTemplate.opsForSet().isMember(key, object);
        return member;
    }

    public static Map<Object, Boolean> setIsMember(String key, Object... objects) {
        Map<Object, Boolean> member = redisTemplate.opsForSet().isMember(key, objects);
        return member;
    }

    public static long setSize(String key) {
        Long result = redisTemplate.opsForSet().size(key);
        return Objects.isNull(result) ? 0 : result;
    }

    public static Object setPop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    public static List<Object> setPop(String key, long count) {
        return redisTemplate.opsForSet().pop(key, count);
    }

    public static long listSetLeft(String key, Object value) {
        Long length = redisTemplate.opsForList().leftPush(key, value);
        return Objects.isNull(length) ? 0 : length;
    }


    public static long listSetRight(String key, Object value) {
        Long length = redisTemplate.opsForList().rightPush(key, value);
        return Objects.isNull(length) ? 0 : length;
    }

    public static void listSetByIndex(String key, long index, Object value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    public static List getList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }


    public static long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }
}
