package com.ExpenseTracker.Tracker.service;

import com.ExpenseTracker.Tracker.dto.UserDto;
import com.ExpenseTracker.Tracker.dto.UserRegistrationDto;
import com.ExpenseTracker.Tracker.dto.request.LoginRequestDto;
import com.ExpenseTracker.Tracker.dto.response.LoginResponseDto;

public interface UserService {
    UserDto register(UserRegistrationDto registrationDTO);
    LoginResponseDto login(LoginRequestDto loginRequestDTO);
    UserDto findByUsername(String username);

}
