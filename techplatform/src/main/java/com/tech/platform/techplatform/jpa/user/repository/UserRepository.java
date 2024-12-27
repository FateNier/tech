package com.tech.platform.techplatform.jpa.user.repository;

import com.tech.platform.techplatform.jpa.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
