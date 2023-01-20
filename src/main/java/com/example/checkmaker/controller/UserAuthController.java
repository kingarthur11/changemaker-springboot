package com.example.checkmaker.controller;

import com.example.checkmaker.config.JwtUtil;
import com.example.checkmaker.dto.LoginDTO;
import com.example.checkmaker.dto.UserAuthRequestDTO;
import com.example.checkmaker.model.UserAuth;
import com.example.checkmaker.service.UserAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register_user")
    public ResponseEntity<UserAuth> registerUser(@Valid @RequestBody UserAuthRequestDTO userAuthRequestDTO) {
        return new ResponseEntity<>(userAuthService.saveUser(userAuthRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login_user")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO.getPassword() + loginDTO.getUsername());
//        return null;
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        authenticationManager.authenticate(token);
        String generateJWTToken = jwtUtil.generate(loginDTO.getUsername());
        return ResponseEntity.ok(generateJWTToken);
    }
}
