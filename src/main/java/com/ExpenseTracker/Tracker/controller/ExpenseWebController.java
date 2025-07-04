package com.ExpenseTracker.Tracker.controller;


import com.ExpenseTracker.Tracker.dto.ExpenseDto;
import com.ExpenseTracker.Tracker.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseWebController {

    private final ExpenseService expenseService;

    @GetMapping
    public String listExpenses(Model model) {
        try {
            List<ExpenseDto> expenses = expenseService.listExpenses();
            model.addAttribute("expenses", expenses);
        } catch (Exception e) {
            model.addAttribute("expenses", new ArrayList<>());
            model.addAttribute("error", "Failed to load expenses: " + e.getMessage());
        }
        return "expense/list";
    }

    @GetMapping("/add")
    public String addExpensePage(Model model) {
        model.addAttribute("expense", new ExpenseDto());
        return "expense/add";
    }

    @PostMapping("/add")
    public String handleAddExpense(@Valid @ModelAttribute("expense") ExpenseDto dto,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "expense/add";
        }

        try {
            expenseService.addExpense(dto);
            redirectAttributes.addFlashAttribute("success", "Expense added successfully!");
            return "redirect:/expenses";
        } catch (Exception e) {
            result.rejectValue("name", "error.expense", "Failed to add expense: " + e.getMessage());
            return "expense/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String editExpensePage(@PathVariable Long id, Model model) {
        try {
            ExpenseDto expense = expenseService.findById(id);
            model.addAttribute("expense", expense);
            return "expense/edit";
        } catch (Exception e) {
            model.addAttribute("error", "Expense not found");
            return "redirect:/expenses";
        }
    }

    @PostMapping("/edit/{id}")
    public String handleEditExpense(@PathVariable Long id,
                                    @Valid @ModelAttribute("expense") ExpenseDto dto,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "expense/edit";
        }

        try {
            expenseService.updateExpense(id, dto);
            redirectAttributes.addFlashAttribute("success", "Expense updated successfully!");
            return "redirect:/expenses";
        } catch (Exception e) {
            result.rejectValue("name", "error.expense", "Failed to update expense: " + e.getMessage());
            return "expense/edit";
        }
    }
}
