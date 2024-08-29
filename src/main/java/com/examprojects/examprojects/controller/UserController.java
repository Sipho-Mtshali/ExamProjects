package com.examprojects.examprojects.controller;

import com.examprojects.examprojects.model.UserModel;
import com.examprojects.examprojects.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "register_page"; // Thymeleaf view name
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "login_page"; // Thymeleaf view name
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("register request: " + userModel);
        UserModel registerUser = userService.registerUser(userModel.getUsername(), userModel.getPassword(), userModel.getEmail());
        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("login request: " + userModel);
        UserModel authenticated = userService.authenticate(userModel.getUsername(), userModel.getPassword());
       if(authenticated != null)
       {
           model.addAttribute("userLogin", authenticated.getUsername());
        return "personal_page";
       }
       else
       {
           return "error_page";
       }
    }
}
