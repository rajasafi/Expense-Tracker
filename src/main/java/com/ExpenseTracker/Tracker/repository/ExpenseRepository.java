package com.ExpenseTracker.Tracker.repository;

import com.ExpenseTracker.Tracker.entity.Expense;
import com.ExpenseTracker.Tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Optional<Expense> findByIdAndUserUsername(Long id, String username);


    List<Expense> findByUserUsernameOrderByDateDesc(String username);
}
