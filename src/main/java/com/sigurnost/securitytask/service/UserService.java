package com.sigurnost.securitytask.service;

import com.sigurnost.securitytask.entities.Role;
import com.sigurnost.securitytask.entities.UserEntity;
import com.sigurnost.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public UserEntity registerUser(UserEntity user){
        String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
