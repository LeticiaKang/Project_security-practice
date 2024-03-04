package com.example.securitypractice.service.impl;

import com.example.securitypractice.dto.UserDto;
import com.example.securitypractice.entity.Role;
import com.example.securitypractice.entity.UserAccount;
import com.example.securitypractice.repository.RoleRepository;
import com.example.securitypractice.repository.UserAccountRepository;
import com.example.securitypractice.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserAccountRepository userAccountRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserAccountRepository userAccountRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        UserAccount user = new UserAccount();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");

        log.debug("[로그] [UserServiceImpl] role : {}", role);

        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        user.getRoles().size();

        log.debug("[로그] [UserServiceImpl] user : {}", user);

        userAccountRepository.save(user);

    }

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserAccount> users = userAccountRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(UserAccount user){
        UserDto userDto = new UserDto();
        String[] names = user.getName().split(" ");
        userDto.setFirstName(names[0]);
        userDto.setLastName(names.length > 1 ? names[1] : "");
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
