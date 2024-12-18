package com.tech.spbot3;

import com.tech.spbot3.core.user.entity.User;
import com.tech.spbot3.core.user.repository.UserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spbot3ApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("zhang_san");
        user.setPassword("zhang_san");
        user.setTel("15842689628");
        user.setAddress("local address");
        user.setEmail("zhangsan@126.com");
        userRepository.save(user);
    }

    @Test
    void removeUser() {

    }

    @Test
    void updateUser() {

    }

    @Test
    void queryUser() {

    }
}
