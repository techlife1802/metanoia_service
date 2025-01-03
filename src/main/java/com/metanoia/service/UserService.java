package com.metanoia.service;


import com.metanoia.model.User;
import com.metanoia.model.UserDetailsDto;
import com.metanoia.model.UserEntryDto;
import com.metanoia.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUserDetails(User user) {
        userRepository.save(user);
    }

    public List<UserDetailsDto> getAllUsers() {
        // Fetch all users from the repository
        List<User> users = userRepository.findAll();

        // Transform the list of User objects into a list of UserDetailsDto objects
        return users.stream()
                .map(user -> UserDetailsDto.builder()
                        .userName(user.getUsername())
                        .fields(Optional.ofNullable(user.getFields())
                                .filter(str -> !str.isEmpty())
                                .map(str -> Arrays.stream(str.split(","))
                                        .collect(Collectors.toList()))
                                .orElseGet(Arrays::asList))
                        .password(user.getPassword())
                        .accessLevel(user.getAccessLevel())
                        .build())
                .collect(Collectors.toList());
    }


    public UserDetailsDto getUserFieldDetails(String userId) {
        User user = userRepository.findByUsername(userId);

        List<String> fields = Optional.ofNullable(user.getFields())
                .filter(str -> !str.isEmpty())
                .map(str -> Arrays.stream(str.split(","))
                        .collect(Collectors.toList()))
                .orElseGet(Arrays::asList);

        return UserDetailsDto.builder().userName(userId)
                .fields(fields)
                .build();
    }

    public void updateUserDetails(UserEntryDto userEntryDto) {

        User user = userRepository.findByUsername(userEntryDto.getUserName());
        if (user != null) {
            if (userEntryDto.getFields() != null) {
                user.setFields(Optional.of(userEntryDto.getFields())
                        .filter(list -> !list.isEmpty())
                        .map(list -> String.join(",", list))
                        .orElse(""));
            }
            if (userEntryDto.getAccessLevel() != null) {
                user.setAccessLevel(userEntryDto.getAccessLevel());
            }
            if (user.getPassword() != null) {
                user.setPassword(userEntryDto.getPassword());
            }
            userRepository.save(user);
        } else {
            throw new RuntimeException("user not found with details::" + userEntryDto.getUserName());
        }
    }
}
