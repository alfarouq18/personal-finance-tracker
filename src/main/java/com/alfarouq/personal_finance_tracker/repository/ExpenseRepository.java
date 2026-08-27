package com.alfarouq.personal_finance_tracker.repository;

import com.alfarouq.personal_finance_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
