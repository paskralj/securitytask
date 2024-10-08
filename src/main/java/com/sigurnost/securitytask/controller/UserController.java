package com.sigurnost.securitytask.controller;

import com.sigurnost.securitytask.dto.UserDTO;
import com.sigurnost.securitytask.entities.UserEntity;
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

    /*
     * http://localhost:8080/api/users/register
     *
     * {
     *     "username": "noviKorisnik",
     *     "email": "novi.korisnik@example.com",
     *     "password": "lozinka123"
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        UserEntity user = convertUserDto(userDTO);
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created!");
    }

    @PostMapping
    public ResponseEntity loginUser(){
        return null;
    }

    private UserEntity convertUserDto(UserDTO userDTO){
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

}
