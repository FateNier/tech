package com.tech.platform.techplatform.redis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.platform.techplatform.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONStringer;
import org.springframework.boot.configurationprocessor.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisRepository redisRepository;

    public boolean add(String key, String value) {
        return redisRepository.add(key, value);
    }

    public boolean remove(String key) {
        return redisRepository.remove(key);
    }

    public JSONObject get(String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(redisRepository.get(key), JSONObject.class);
    }
}
