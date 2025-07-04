package com.ExpenseTracker.Tracker.service.impl;

import com.ExpenseTracker.Tracker.dto.UserDto;
import com.ExpenseTracker.Tracker.dto.UserRegistrationDto;
import com.ExpenseTracker.Tracker.dto.request.LoginRequestDto;
import com.ExpenseTracker.Tracker.dto.response.LoginResponseDto;
import com.ExpenseTracker.Tracker.entity.User;
import com.ExpenseTracker.Tracker.mapper.UserMapper;
import com.ExpenseTracker.Tracker.repository.UserRepository;
import com.ExpenseTracker.Tracker.service.UserService;
import com.ExpenseTracker.Tracker.util.JwtUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;


    @Override
    public UserDto register(UserRegistrationDto registrationDto) {
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent())
            throw new IllegalArgumentException("Username already exists");
        User user = userMapper.toUserFromRegistration(registrationDto);
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        User saved = userRepository.save(user);
        return userMapper.toUserDto(saved);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDTO) {
        User user = userRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        LoginResponseDto response = new LoginResponseDto();
        response.setUsername(user.getUsername());
        response.setToken(token);
        return response;
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userMapper.toUserDto(user);
    }
}
