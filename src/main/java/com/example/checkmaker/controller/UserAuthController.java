package com.example.checkmaker.controller;

import com.example.checkmaker.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;
}
