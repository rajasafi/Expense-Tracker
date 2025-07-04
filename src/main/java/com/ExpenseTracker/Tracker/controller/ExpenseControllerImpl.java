package com.ExpenseTracker.Tracker.controller;

import com.ExpenseTracker.Tracker.dto.ExpenseDto;
import com.ExpenseTracker.Tracker.entity.Expense;
import com.ExpenseTracker.Tracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expense")
@PreAuthorize("isAuthenticated()")
public class ExpenseControllerImpl {
    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ExpenseDto> add(@RequestBody ExpenseDto dto) {
        return ResponseEntity.ok(expenseService.addExpense(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> update(@PathVariable Long id,
                                             @RequestBody ExpenseDto dto) {
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<ExpenseDto>> getAll() {
        return ResponseEntity.ok(expenseService.listExpenses());
    }
}
