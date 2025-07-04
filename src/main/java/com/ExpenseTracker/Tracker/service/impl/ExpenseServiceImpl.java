package com.ExpenseTracker.Tracker.service.impl;

import com.ExpenseTracker.Tracker.dto.ExpenseDto;
import com.ExpenseTracker.Tracker.entity.Expense;
import com.ExpenseTracker.Tracker.entity.User;
import com.ExpenseTracker.Tracker.mapper.ExpenseMapper;
import com.ExpenseTracker.Tracker.repository.ExpenseRepository;
import com.ExpenseTracker.Tracker.repository.UserRepository;
import com.ExpenseTracker.Tracker.service.ExpenseService;

import com.ExpenseTracker.Tracker.util.AuthUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
@PreAuthorize("isAuthenticated()")
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final ExpenseMapper expenseMapper;

    @Override
    public ExpenseDto addExpense(ExpenseDto dto) {
        String username = AuthUtils.currentUsername();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Expense entity = expenseMapper.toExpense(dto);
        entity.setUser(user);
        return expenseMapper.toExpenseDTO(expenseRepository.save(entity));
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto dto) {
        String username = AuthUtils.currentUsername();
        Expense entity = expenseRepository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new AccessDeniedException("Expense not found"));
        entity.setName(dto.getName());
        entity.setAmount(dto.getAmount());
        entity.setDate(dto.getDate());
        entity.setDescription(dto.getDescription());
        return expenseMapper.toExpenseDTO(expenseRepository.save(entity));
    }

    @Override
    public List<ExpenseDto> listExpenses() {
        String username = AuthUtils.currentUsername();
        return expenseMapper.toExpenseDTOs(
                expenseRepository.findByUserUsernameOrderByDateDesc(username));
    }

    @Override
    public ExpenseDto findById(Long id) {
        String username = AuthUtils.currentUsername();
        Expense expense = expenseRepository.findByIdAndUserUsername(id, username)
                .orElseThrow(() -> new AccessDeniedException("Expense not found"));
        return expenseMapper.toExpenseDTO(expense);
    }
}






