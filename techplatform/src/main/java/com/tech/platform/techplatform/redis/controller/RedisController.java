package com.tech.platform.techplatform.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.platform.techplatform.redis.model.RedisModel;
import com.tech.platform.techplatform.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;
    @GetMapping(value = "/get", produces = "application/json")
    public String getData(@RequestParam(name = "key") String key) throws JSONException {
        return redisService.get(key).toString();
    }

    @PostMapping("/add")
    public boolean addData(@RequestBody RedisModel redisModel) {
        ObjectMapper mapper = new ObjectMapper();
        String userJson = "";
        try {
            userJson = mapper.writeValueAsString(redisModel.getContent());
        } catch (JsonProcessingException e) {

        }

        return redisService.add(redisModel.getKey(), userJson);
    }

    @DeleteMapping("/del/{key}")
    public boolean delData(@PathVariable(name = "key") String key) {
        return true;
    }
}
