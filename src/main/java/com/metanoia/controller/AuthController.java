package com.metanoia.controller;

import com.metanoia.model.LoginRequest;
import com.metanoia.model.LoginResponse;
import com.metanoia.security.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            log.info("User - {} trying to login ",loginRequest.getUserName());
            LoginResponse response =  authService.authenticate(loginRequest.getUserName(), loginRequest.getPassword());
            log.info("User logged in success:: {}",loginRequest.getUserName());
            return ResponseEntity.ok().body(response);
        } catch (RuntimeException e) {
            log.error("User - {} failed to login :: {}",loginRequest.getUserName(),e.getMessage());
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}

