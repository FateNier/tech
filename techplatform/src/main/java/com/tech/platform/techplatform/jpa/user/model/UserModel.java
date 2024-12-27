package com.tech.platform.techplatform.jpa.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    private Long id;
    private String username;
    private String password;
    private String tel;
    private String address;
    private String email;

}

