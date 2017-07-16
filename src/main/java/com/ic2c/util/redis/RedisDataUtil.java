/**
 * 易码当先 <br>
 * JpSpringBoot02 <br>
 * com.ic2c.util.redis <br>
 * RedisUtil.java <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月16日-下午7:37:43 <br>
 * 2017Allister-版权所有 <br>
 */
package com.ic2c.util.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 *   <br>
 * RedisUtil <br>
 * @author Allister.Liu(刘继鹏) <br>
 * Email：laujip@163.com <br>
 * 时间：2017年7月16日-下午7:37:43  <br>
 * @version 1.0.0
 * 
 */
@Component
public class RedisDataUtil {
	private static final Logger log = LoggerFactory.getLogger(RedisDataUtil.class);
	
    @Autowired
    private RedisTemplate redisTemplate;
    
    
    public RedisDataUtil() {
    }

    public void remove(String... keys) {
        String[] var2 = keys;
        int var3 = keys.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String key = var2[var4];
            this.remove(key);
        }

    }

    public void removePattern(String pattern) {
        Set keys = this.redisTemplate.keys(pattern);
        if(keys.size() > 0) {
            this.redisTemplate.delete(keys);
        }

    }

    public void remove(String key) {
        if(this.exists(key)) {
            this.redisTemplate.delete(key);
        }

    }

    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key).booleanValue();
    }

    public Object get(String key) {
        Object result = null;
        ValueOperations operations = this.redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public boolean set(String key, Object value) {
        boolean result = false;

        try {
            ValueOperations e = this.redisTemplate.opsForValue();
            e.set(key, value);
            result = true;
        } catch (Exception var5) {
            log.error("RedisUtil set exception", var5);
        }

        return result;
    }

    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations e = this.redisTemplate.opsForValue();
            e.set(key, value);
            this.redisTemplate.expire(key, expireTime.longValue(), TimeUnit.SECONDS);
            result = true;
        } catch (Exception var6) {
            log.error("RedisUtil set exception", var6);
        }

        return result;
    }

    public boolean setIfAbsent(String key, Object value) {
        boolean result = false;

        try {
            ValueOperations e = this.redisTemplate.opsForValue();
            result = e.setIfAbsent(key, value).booleanValue();
        } catch (Exception var5) {
            log.error("RedisUtil setIfAbsent exception", var5);
        }

        return result;
    }

    public boolean setIfAbsent(String key, Object value, Long expireTime) {
        boolean result = false;

        try {
            ValueOperations e = this.redisTemplate.opsForValue();
            result = e.setIfAbsent(key, value).booleanValue();
            if(result) {
                this.redisTemplate.expire(key, expireTime.longValue(), TimeUnit.SECONDS);
            }
        } catch (Exception var6) {
            log.error("RedisUtil setIfAbsent exception", var6);
        }

        return result;
    }

    public boolean tryLock(String key, Long cacheSeconds) {
        boolean isLock = false;

        try {
            isLock = this.setIfAbsent(key, "", cacheSeconds);
        } catch (Exception var5) {
            log.error("RedisUtil tryLock exception", var5);
        }

        return isLock;
    }
}
