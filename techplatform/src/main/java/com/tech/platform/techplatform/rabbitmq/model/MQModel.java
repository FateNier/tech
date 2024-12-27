package com.tech.platform.techplatform.rabbitmq.model;

import com.tech.platform.techplatform.rabbitmq.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MQModel {

    private String key;
    private UserModel content;
}
