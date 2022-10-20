package com.example.preproject3_1_4.repository;

import com.example.preproject3_1_4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);

}