package com.example.dataflix.controller;

import com.example.dataflix.dto.LoginRequest;
import com.example.dataflix.dto.RegisterRequest;
import com.example.dataflix.model.Users;
import com.example.dataflix.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model, HttpSession session) {
        var userOpt = usersService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (userOpt.isPresent()) {
            session.setAttribute("user", userOpt.get());
            return "redirect:/home";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest registerRequest, Model model) {
        try {
            Users user = new Users();
            user.setUsersName(registerRequest.getUsersName());
            user.setUsersSurname(registerRequest.getUsersSurname());
            user.setAge(registerRequest.getAge());
            user.setEmail(registerRequest.getEmail());
            user.setPassword(registerRequest.getPassword());
            usersService.registerUser(user);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("registrationError", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout=true";
    }
} 