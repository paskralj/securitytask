package com.sigurnost.securitytask.service;

import com.sigurnost.securitytask.entities.Role;
import com.sigurnost.securitytask.entities.User;
import com.sigurnost.securitytask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        user.setRole(Role.USER.name());
        return userRepository.save(user);
    }
}
