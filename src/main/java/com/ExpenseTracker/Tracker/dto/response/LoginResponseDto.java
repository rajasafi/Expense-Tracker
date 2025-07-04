package com.ExpenseTracker.Tracker.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private String username;
    private String token;
}
