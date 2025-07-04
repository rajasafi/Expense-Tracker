package com.ExpenseTracker.Tracker.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExpenseDto {
    private Long id;
    private String name;
    private Double amount;
    private LocalDate date;
    private String description;
  private Long userId;
}
