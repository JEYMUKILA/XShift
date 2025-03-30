package com.example.XShift.controller;

import com.example.XShift.model.User;
import com.example.XShift.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        System.out.println("Reached UserController");
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("Reached UserController Login");
        return userService.verify(user);
    }


}