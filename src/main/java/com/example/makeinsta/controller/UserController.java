package com.example.makeinsta.controller;


import com.example.makeinsta.model.Role;
import com.example.makeinsta.model.User;
import com.example.makeinsta.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class UserController {

    private UserService userServiceImp;

    @GetMapping
    public String signupForm(Model model) {
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute("user") User user) {
        user.setRole(Role.USER);
        userServiceImp.회원가입(user);
        return "redirect:/signup";
    }
}
