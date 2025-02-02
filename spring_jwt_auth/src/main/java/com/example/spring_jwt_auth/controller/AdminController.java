package com.example.spring_jwt_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/page3")
    public ResponseEntity<String> page3() {
        return ResponseEntity.ok("Admin Page 3 Content");
    }

    @GetMapping("/page4")
    public ResponseEntity<String> page4() {
        return ResponseEntity.ok("Admin Page 4 Content");
    }
}
