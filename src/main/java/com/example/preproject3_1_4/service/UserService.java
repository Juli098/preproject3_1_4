package com.example.preproject3_1_4.service;

import com.example.preproject3_1_4.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    List<User> findAllUsers();

    void saveUser(User user);

    User findByIdUsers(Long id);

    void updateUser(Long id, User user);

    void deleteByIdUsers(Long id);

}