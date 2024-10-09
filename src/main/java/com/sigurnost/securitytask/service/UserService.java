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

    /**
     * http://localhost:8080/api/users/register
     *
     * {
     *     "username": "noviKorisnik",
     *     "email": "novi.korisnik@example.com",
     *     "password": "lozinka123"
     * }
     *
     * @param user
     * @return
     */
    public User registerUser(User user){
        user.setRole(Role.USER.name());
        return userRepository.save(user);
    }
}
