package com.example.preproject3_1_4.service;

import com.example.preproject3_1_4.model.Role;
import com.example.preproject3_1_4.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    Role findRoleByName(String name);

    List<Role> findAllRoles();

    List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles);
}