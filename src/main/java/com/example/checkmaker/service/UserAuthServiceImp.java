package com.example.checkmaker.service;

import com.example.checkmaker.model.UserAuth;
import com.example.checkmaker.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserAuthServiceImp implements UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;
    @Override
    public UserAuth saveUser(UserAuth userAuth) {
        return userAuthRepository.save(userAuth);
    }

    @Override
    public List<UserAuth> fetchUserList() {
        return userAuthRepository.findAll();
    }

    @Override
    public UserAuth fetchUserById(Integer userId) {
        return userAuthRepository.findById(userId).get();
    }

    @Override
    public void deleteUserById(Integer userId) {
        userAuthRepository.deleteById(userId);
    }
//
    @Override
    public UserAuth updateUser(Integer userId, UserAuth userAuth) {
        if(Objects.nonNull(userAuth.getUsername()) && !"".equalsIgnoreCase(userAuth.getUsername())) {
			userAuth.setUsername(userAuth.getUsername());
		}

		if(Objects.nonNull(userAuth.getUserEmail()) && !"".equalsIgnoreCase(userAuth.getUserEmail())) {
            userAuth.setUserEmail(userAuth.getUserEmail());
		}

		if(Objects.nonNull(userAuth.getFullname()) && !"".equalsIgnoreCase(userAuth.getFullname())) {
            userAuth.setFullname(userAuth.getFullname());
		}

		if(Objects.nonNull(userAuth.getUserPhoneNo()) && !"".equalsIgnoreCase(userAuth.getUserPhoneNo())) {
            userAuth.setUserPhoneNo(userAuth.getUserPhoneNo());
		}

		return userAuthRepository.save(userAuth);
    }
//
    @Override
    public UserAuth getUserByName(String userName) {
        return userAuthRepository.findUserAuthByUsername(userName);
    }

    @Override
    public UserAuth getUserByEmail(String userEmail) {
        return userAuthRepository.findByUserEmail(userEmail);
    }
}
