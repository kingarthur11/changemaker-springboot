package com.example.checkmaker.service;

import com.example.checkmaker.model.UserAuth;

import java.util.List;

public interface UserAuthService {
    public UserAuth saveUser(UserAuth userAuth);

    public List<UserAuth> fetchUserList();

    public UserAuth fetchUserById(Integer userId);

    public void deleteUserById(Integer userId);

    public UserAuth updateUser(Integer userId, UserAuth userAuth);

    public UserAuth getUserByName(String userName);

    public UserAuth getUserByEmail(String userEmail);
}
