package com.example.checkmaker.repository;

import com.example.checkmaker.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
    public UserAuth findByUserEmail(String email);
    public UserAuth findUserAuthByUsername(String usename);
}
