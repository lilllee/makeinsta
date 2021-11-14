package com.example.makeinsta.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRegistrationDto {

    private String username;
    private String nickname;
    private String email;
    private String password;

}
