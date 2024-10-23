package com.sigurnost.securitytask.controller;

import com.sigurnost.securitytask.dto.AuthResponseDTO;
import com.sigurnost.securitytask.dto.LoginDTO;
import com.sigurnost.securitytask.dto.UserDTO;
import com.sigurnost.securitytask.entities.UserEntity;
import com.sigurnost.securitytask.security.JwtGenerator;
import com.sigurnost.securitytask.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtGenerator jwtGenerator;
    private final SecurityContextLogoutHandler logoutHandler;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, UserService userService, JwtGenerator jwtGenerator, SecurityContextLogoutHandler logoutHandler) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.logoutHandler = logoutHandler;
    }

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
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        UserEntity user = convertUserDto(userDTO);
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created!");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            logoutHandler.logout(request, response, authentication);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Successfully logged out");
    }

    private UserEntity convertUserDto(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

}
