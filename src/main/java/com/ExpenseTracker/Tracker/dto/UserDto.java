package com.ExpenseTracker.Tracker.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
}
