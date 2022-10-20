package com.example.preproject3_1_4.repository;

import com.example.preproject3_1_4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 User findByEmail(String email);
}