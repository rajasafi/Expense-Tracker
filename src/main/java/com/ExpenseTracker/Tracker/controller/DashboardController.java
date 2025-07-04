package com.ExpenseTracker.Tracker.controller;


import com.ExpenseTracker.Tracker.dto.ExpenseDto;
import com.ExpenseTracker.Tracker.service.ExpenseService;
import com.ExpenseTracker.Tracker.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final ExpenseService expenseService;

    @GetMapping
    public String dashboard(Model model) {
        try {
            List<ExpenseDto> expenses = expenseService.listExpenses();

            // Calculate statistics
            double totalAmount = expenses.stream()
                    .mapToDouble(ExpenseDto::getAmount)
                    .sum();

            ExpenseDto lastExpense = expenses.isEmpty() ? null : expenses.get(0);

            model.addAttribute("totalExpenses", expenses.size());
            model.addAttribute("totalAmount", totalAmount);
            model.addAttribute("lastExpense", lastExpense);

        } catch (Exception e) {
            model.addAttribute("totalExpenses", 0);
            model.addAttribute("totalAmount", 0.0);
            model.addAttribute("lastExpense", null);
        }

        return "dashboard/index";
    }
}
