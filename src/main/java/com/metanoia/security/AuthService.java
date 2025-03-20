package com.metanoia.security;

import com.metanoia.model.LoginResponse;
import com.metanoia.model.User;
import com.metanoia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil tokenService;

    public LoginResponse authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user==null) {
            throw new RuntimeException("Invalid username or password");
        }
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        // Generate and return token
        String token = tokenService.generateToken(user.getUsername());
        return  new LoginResponse(token, user.getAccessLevel());


    }
}

