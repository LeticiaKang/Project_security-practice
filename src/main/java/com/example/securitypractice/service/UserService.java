package com.example.securitypractice.service;

import com.example.securitypractice.dto.UserDto;
import com.example.securitypractice.entity.UserAccount;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    UserAccount findByEmail(String email);

    List<UserDto> findAllUsers();
}
