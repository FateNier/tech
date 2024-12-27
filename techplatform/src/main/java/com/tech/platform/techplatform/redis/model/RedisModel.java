package com.tech.platform.techplatform.redis.model;

import com.tech.platform.techplatform.redis.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisModel {

    private String key;
    private UserModel content;
}
