package com.ExpenseTracker.Tracker.service;

import com.ExpenseTracker.Tracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseDto addExpense(ExpenseDto expenseDTO);
    ExpenseDto updateExpense(Long id, ExpenseDto expenseDTO);
    List<ExpenseDto> listExpenses();


    ExpenseDto findById(Long id);
}
