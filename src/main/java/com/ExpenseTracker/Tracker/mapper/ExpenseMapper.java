package com.ExpenseTracker.Tracker.mapper;

import com.ExpenseTracker.Tracker.dto.ExpenseDto;
import com.ExpenseTracker.Tracker.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    Expense toExpense(ExpenseDto expenseDTO);

    ExpenseDto toExpenseDTO(Expense expense);

    List<ExpenseDto> toExpenseDTOs(List<Expense> expenses);
}
