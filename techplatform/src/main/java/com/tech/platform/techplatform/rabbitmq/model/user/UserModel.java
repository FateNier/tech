package com.tech.platform.techplatform.rabbitmq.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String name;
    private String age;
    private String address;
    private String tel;
    private String email;
}
