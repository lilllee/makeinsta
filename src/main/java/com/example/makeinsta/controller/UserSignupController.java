package com.example.makeinsta.controller;


import com.example.makeinsta.dto.UserRegistrationDto;
import com.example.makeinsta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class UserSignupController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String signupForm(@ModelAttribute UserRegistrationDto userRegistrationDto, Model model) {
        model.addAttribute("userDTO", userRegistrationDto);
        return "signup";
    }

    @PostMapping
    public String save(UserRegistrationDto userRegistrationDto) {
        if (userService.회원가입(userRegistrationDto)) {
            System.out.println("성공적으로 회원가입");
            return "redirect:/login";
        } else {
            System.out.println("회원가입 실패");
            return "redirect:/signup?error";
        }
    }
}
