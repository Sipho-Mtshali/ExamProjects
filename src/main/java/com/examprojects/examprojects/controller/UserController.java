package com.examprojects.examprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/register")
    public String getRegisterPage() {
        return "register_page"; // Thymeleaf view name
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page"; // Thymeleaf view name
    }
}
