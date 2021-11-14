package com.example.makeinsta.service;

import com.example.makeinsta.dto.UserRegistrationDto;
import com.example.makeinsta.model.Role;
import com.example.makeinsta.model.User;
import com.example.makeinsta.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public User 회원가입(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setRole(Role.USER);
        modelMapper.map(userRegistrationDto, user);
        return save(user);
    }
}
