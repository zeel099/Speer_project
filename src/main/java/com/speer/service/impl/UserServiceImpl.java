package com.speer.service.impl;

import com.speer.entity.User;
import com.speer.exceptions.ResourceNotFoundException;
import com.speer.payload.UserDto;
import com.speer.repository.UserRepository;
import com.speer.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user1 = this.modelMapper.map(userDto,User.class);
        User savedUser = this.userRepository.save(user1);

        return this.modelMapper.map(savedUser,UserDto.class);

    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = this.userRepository.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("User","userId",userId));

        return this.modelMapper.map(user,UserDto.class);
    }
}
