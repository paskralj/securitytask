package com.sigurnost.securitytask.service;

import com.sigurnost.securitytask.entities.Role;
import com.sigurnost.securitytask.entities.UserEntity;
import com.sigurnost.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user){
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
