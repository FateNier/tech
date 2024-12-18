package com.tech.spbot3.core.user.repository;

import com.tech.spbot3.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
