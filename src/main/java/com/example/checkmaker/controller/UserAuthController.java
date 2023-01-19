package com.example.checkmaker.controller;

import com.example.checkmaker.dto.UserAuthRequestDTO;
import com.example.checkmaker.model.UserAuth;
import com.example.checkmaker.service.UserAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/register_user")
    public ResponseEntity<UserAuth> registerUser(@Valid @RequestBody UserAuthRequestDTO userAuthRequestDTO) {

        return new ResponseEntity<>(userAuthService.saveUser(userAuthRequestDTO), HttpStatus.CREATED);
    }
}
