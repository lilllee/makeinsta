package com.example.makeinsta.service;

import com.example.makeinsta.dto.UserRegistrationDto;
import com.example.makeinsta.model.User;
import com.example.makeinsta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void 회원가입(User user) {
        userRepository.save(user);
    }
}
