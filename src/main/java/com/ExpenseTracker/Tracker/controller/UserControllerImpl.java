package com.ExpenseTracker.Tracker.controller;

import com.ExpenseTracker.Tracker.dto.ApiResponse;
import com.ExpenseTracker.Tracker.dto.UserDto;
import com.ExpenseTracker.Tracker.dto.UserRegistrationDto;
import com.ExpenseTracker.Tracker.dto.request.LoginRequestDto;
import com.ExpenseTracker.Tracker.dto.response.LoginResponseDto;
import com.ExpenseTracker.Tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserControllerImpl {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDto>> register(@RequestBody UserRegistrationDto registrationDTO) {
        UserDto userDTO = userService.register(registrationDTO);
        ApiResponse<UserDto> response = new ApiResponse<>(
                "User registered successfully",
                userDTO,
                201,
                System.currentTimeMillis()
        );
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDTO) {
        LoginResponseDto responseDto = userService.login(loginRequestDTO);
        ApiResponse<LoginResponseDto> response = new ApiResponse<>(
                "Login successful",
                responseDto,
                200,
                System.currentTimeMillis()
        );
        return ResponseEntity.ok(response);
    }
}
