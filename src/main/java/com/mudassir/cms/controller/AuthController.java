package com.mudassir.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mudassir.cms.enums.Role;
import com.mudassir.cms.entity.User;
import com.mudassir.cms.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {

        model.addAttribute("user", new User());

        model.addAttribute("roles", Role.values());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute User user) {

        userService.registerUser(user);

        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}