package com.metanoia.controller;

import com.metanoia.model.User;
import com.metanoia.model.UserDetailsDto;
import com.metanoia.model.UserEntryDto;
import com.metanoia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        User encodeduser = User.builder().password(user.getPassword())
                .fields(user.getFields())
                .accessLevel(user.getAccessLevel())
                .username(user.getUsername()).build();
        userService.saveUserDetails(user);
    }

    @PostMapping("/get-user-field-details")
    public UserDetailsDto getUserFieldDetails(@RequestBody UserEntryDto userRequest) {
        return userService.getUserFieldDetails(userRequest.getUserName());
    }

    @PostMapping("/update-user-details")
    public void updateUserDetails(@RequestBody UserEntryDto userRequest) {
        userService.updateUserDetails(userRequest);
    }

    @GetMapping("/getAllUsers")
    public List<UserDetailsDto> getAllUsersData() {
        return userService.getAllUsers();
    }
}
