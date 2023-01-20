package com.example.checkmaker.service;

import com.example.checkmaker.model.UserAuth;
import com.example.checkmaker.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        final UserAuth userAuth = userAuthRepository.findUserAuthByUsername(username);
        if (userAuth == null) {
            throw new UsernameNotFoundException(username);
        }

        UserDetails user = User.withUsername(userAuth.getUsername()).password(userAuth.getPassword()).authorities("USER").build();
        return user;
    }

}
