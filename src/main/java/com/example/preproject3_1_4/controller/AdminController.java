package com.example.preproject3_1_4.controller;

import com.example.preproject3_1_4.model.User;
import com.example.preproject3_1_4.service.RoleServiceImpl;
import com.example.preproject3_1_4.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;

    private final RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping()
    public String index(Model model, Principal principal) {
        model.addAttribute("current_user", userService.findByEmail(principal.getName()));
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("rolesList", roleService.findAllRoles());
        model.addAttribute("newUser", new User());
        return "admin";
    }
}