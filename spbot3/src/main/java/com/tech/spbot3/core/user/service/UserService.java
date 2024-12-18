package com.tech.spbot3.core.user.service;

import com.tech.spbot3.core.user.controller.UserModel;
import com.tech.spbot3.core.user.entity.User;
import com.tech.spbot3.core.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean addUser(UserModel userModel) {
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        repository.save(user);
        return true;
    }

    public boolean updateUser(UserModel userModel) {
        AtomicReference<Boolean> updateResult = new AtomicReference<>(false);
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        repository.findById(userModel.getId()).ifPresentOrElse(
                result -> {
                    user.setId(result.getId());
                    repository.save(user);
                    updateResult.set(true);
                }, () -> {
                    repository.save(user);
                    updateResult.set(false);
                }
        );
        return updateResult.get();
    }

    public boolean removeUser(Long id) {
        return true;
    }

    public UserModel queryUser(Long id) {

        return new UserModel();
    }
}
