package com.metanoia.service;

import com.metanoia.model.User;
import com.metanoia.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomUserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found::");
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
