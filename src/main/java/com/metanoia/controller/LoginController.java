package com.metanoia.controller;

import com.metanoia.model.LoginRequest;
import com.metanoia.model.UserDetailsDto;
import com.metanoia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDetailsDto> authenticateUser(@RequestBody LoginRequest loginRequest){
         UserDetailsDto detailsDto = userService.getUserByUserName(loginRequest.getUserName());

         HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION,  "Dummy_token");

        // Create the response entity with headers and body
        return new ResponseEntity<>(detailsDto, headers, HttpStatus.OK);
    }

}
