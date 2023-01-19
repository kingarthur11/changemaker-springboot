package com.example.checkmaker.service;

import com.example.checkmaker.dto.UserAuthRequestDTO;
import com.example.checkmaker.model.UserAuth;
import jakarta.validation.Valid;

import java.util.List;

public interface UserAuthService {
    public UserAuth saveUser(@Valid UserAuthRequestDTO userAuthRequestDTO);

//    public List<UserAuth> fetchUserList();
//
//    public UserAuth fetchUserById(Integer id);
//
//    public void deleteUserById(Integer id);
//
//    public UserAuth updateUser(Integer id, UserAuth userAuth);
//
//    public UserAuth getUserByName(String userName);
//
//    public UserAuth getUserByEmail(String userEmail);
}
