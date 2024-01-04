package com.speer.controller;

import com.speer.payload.UserDto;
import com.speer.response.ResponseHandler;
import com.speer.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object>createUser(@val @RequestBody UserDto userDto){
        UserDto createUser = this.userService.createUser(userDto);
        return ResponseHandler.responseBuilder("Account created successfully", HttpStatus.OK,createUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
