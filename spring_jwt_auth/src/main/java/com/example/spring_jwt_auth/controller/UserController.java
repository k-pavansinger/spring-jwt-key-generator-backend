package com.example.spring_jwt_auth.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_jwt_auth.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/page1")
    public String page1(Authentication authentication) {
        return "Hello " + authentication.getName();
    }

    @GetMapping("/page2")
    public String page2(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return "Hi " + user.getEmail();
    }
}