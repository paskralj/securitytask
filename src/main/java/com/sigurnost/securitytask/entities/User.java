package com.sigurnost.securitytask.entities;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class User {

    private Long id;
    private String username;
    private String passwordHash;
    private String email;
    private Role role = Role.USER;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password){
        this.passwordHash = hashPassword(password);
    }

    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void checkPassword(String password){
        BCrypt.checkpw(password, this.passwordHash);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
