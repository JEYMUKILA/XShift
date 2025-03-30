package com.example.XShift.service;

import com.example.XShift.model.User;
import com.example.XShift.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository repo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Transactional
    public User register(User user) {
        System.out.println("Before saving: " + user);
        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = repo.save(user);
        System.out.println("After saving: " + savedUser);
        return savedUser;
    }

    @Transactional
    public String verify(User user) {
        System.out.println("Here we go for verification");
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            System.out.println("Authentiacated");
            return jwtService.generateToken(user.getEmail());
        } else {
            return "fail";
        }
    }
}
