package com.example.checkmaker.controller;

import com.example.checkmaker.config.JwtUtil;
import com.example.checkmaker.dto.LoginDTO;
import com.example.checkmaker.dto.LoginData;
import com.example.checkmaker.dto.ServiceResponse;
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

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;

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
    public ResponseEntity<ServiceResponse> registerUser(@Valid @RequestBody UserAuthRequestDTO userAuthRequestDTO) {
        ServiceResponse response = new ServiceResponse();
        response.setStatus("200");
        response.setDescription("User token retrieved");
        response.setData(userAuthService.saveUser(userAuthRequestDTO));
        response.setTimestamp(new Date());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/login_user")
    public ResponseEntity<ServiceResponse> login(@RequestBody LoginDTO loginDTO) {
        ServiceResponse response = new ServiceResponse();

        LinkedHashMap<String, LoginData> mapObjectData = new LinkedHashMap<>();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        authenticationManager.authenticate(token);
        String generateJWTToken = jwtUtil.generate(loginDTO.getUsername());

        UserAuth userAuth = userAuthService.getUserByName(loginDTO.getUsername());
        mapObjectData.put("userData", new LoginData(generateJWTToken, userAuth));

        response.setStatus("200");
        response.setDescription("User token retrieved");
        response.setData(generateJWTToken);
        response.setData(mapObjectData);
        response.setTimestamp(new Date());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
