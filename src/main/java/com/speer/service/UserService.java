package com.speer.service;

import com.speer.entity.User;
import com.speer.payload.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);



}
