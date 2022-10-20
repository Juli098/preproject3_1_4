package com.example.preproject3_1_4.controller;

import com.example.preproject3_1_4.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserInfo(Principal principal, Model model) {
        //principal - сжатая информация о текущем пользователе
        model.addAttribute("user", userService.findByEmail(principal.getName()));
        return "user";
    }
}