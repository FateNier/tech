package com.tech.spbot3.core.user.controller;

import com.tech.spbot3.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody UserModel model) {

        return userService.addUser(model);
    }

    @DeleteMapping("/del/{id}")
    public boolean removeUser(@PathVariable Long id) {
        return  userService.removeUser(id)
    }

}
