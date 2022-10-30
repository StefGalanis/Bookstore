package com.example.bookstore.controller;

import com.example.bookstore.model.User;
import com.example.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

//    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @PostMapping("/registerUser")
    public String registerUser(User user){
        this.userService.createUser(user);
        return "register_success";
    }

    @GetMapping("/registerPage")
    public String showRegisterPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register_page";
    }

    @GetMapping("/loginPage")
    public String showRegisterPage(){
        return "login_page";
    }
}
