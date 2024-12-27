package com.tech.platform.techplatform.jpa.user.controller;

import com.tech.platform.techplatform.jpa.user.model.UserModel;
import com.tech.platform.techplatform.jpa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody UserModel model) {
        return userService.addUser(model);
    }

    @DeleteMapping("/del/{id}")
    public boolean removeUser(@PathVariable Long id) {
        return  userService.removeUser(id);
    }

    @GetMapping("/get")
    public List<UserModel> queryUser(@RequestParam(required = false) String userId){
        Long id = this.parseNumber(userId, Long.class);
        return userService.queryUser(id);
    }

    private <T extends Number> T parseNumber(String number, Class<T> type){
        try {
            return NumberUtils.parseNumber(number, type);
        } catch(Exception e) {
            return null;
        }
    }
}
