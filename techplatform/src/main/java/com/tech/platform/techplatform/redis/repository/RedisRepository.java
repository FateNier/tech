package com.tech.platform.techplatform.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean add(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean remove(String key){
        return redisTemplate.delete(key);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
