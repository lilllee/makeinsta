package com.example.makeinsta.service;

import com.example.makeinsta.dto.UserRegistrationDto;
import com.example.makeinsta.model.Role;
import com.example.makeinsta.model.User;
import com.example.makeinsta.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean 회원가입(UserRegistrationDto userRegistrationDto) {
        if (userRepository.findByEmail(userRegistrationDto.getEmail()) != null) {
            return false;
        }
        User user = new User();
//        String encode = bCryptPasswordEncoder.encode(user.getPassword());
//        user.setPassword(encode);
        user.setRole(Role.USER);
        modelMapper.map(userRegistrationDto, user);
        save(user);
        System.out.println(user.toString());
        return true;
    }
}
