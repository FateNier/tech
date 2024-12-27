package com.tech.platform.techplatform.jpa.user.service;

import com.tech.platform.techplatform.jpa.user.entity.UserEntity;
import com.tech.platform.techplatform.jpa.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import com.tech.platform.techplatform.jpa.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean addUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userModel, userEntity);
        repository.save(userEntity);
        return true;
    }

    public boolean updateUser(UserModel userModel) {
        AtomicReference<Boolean> updateResult = new AtomicReference<>(false);
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userModel, userEntity);
        repository.findById(userModel.getId()).ifPresentOrElse(
                result -> {
                    userEntity.setId(result.getId());
                    repository.save(userEntity);
                    updateResult.set(true);
                }, () -> {
                    repository.save(userEntity);
                    updateResult.set(false);
                }
        );
        return updateResult.get();
    }

    public boolean removeUser(Long id) {
        repository.findById(id).ifPresent(userEntity -> {
            repository.delete(userEntity);
        });
        return true;
    }

    public List<UserModel> queryUser(Long id) {
        List<UserModel> userList = new ArrayList<>();
        if (id != null) {
            repository.findById(id).ifPresent(userResult -> {
                UserModel um = new UserModel();
                BeanUtils.copyProperties(userResult, um);
                userList.add(um);
            });
        } else {
            userList.addAll(
                    repository.findAll().stream().map(
                            userResult -> {
                                UserModel um = new UserModel();
                                BeanUtils.copyProperties(userResult, um);
                                return um;
                            }
                    ).toList());
        }
        return userList;
    }
}
