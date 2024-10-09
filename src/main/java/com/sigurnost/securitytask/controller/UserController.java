package com.sigurnost.securitytask.controller;

import com.sigurnost.securitytask.dto.UserDTO;
import com.sigurnost.securitytask.entities.User;
import com.sigurnost.securitytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        User user = convertUserDto(userDTO);
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created!");
    }

    private User convertUserDto(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

}
