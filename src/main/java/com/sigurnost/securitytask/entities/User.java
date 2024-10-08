package com.sigurnost.securitytask.entities;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Table(name = "sectable")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    private String passwordHash;
    private String email;
    private String role;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.passwordHash = hashPassword(password);
        this.email = email;
    }

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

    public void setPassword(String password) {
        this.passwordHash = hashPassword(password);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void checkPassword(String password) {
        BCrypt.checkpw(password, this.passwordHash);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
