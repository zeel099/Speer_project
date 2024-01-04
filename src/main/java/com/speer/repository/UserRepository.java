package com.speer.repository;

import com.speer.entity.User;
import com.speer.payload.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User>findById(Long userId);
    void save(UserDto user);
}
