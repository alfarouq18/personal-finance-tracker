package com.alfarouq.personal_finance_tracker.controller;


import com.alfarouq.personal_finance_tracker.model.Expense;
import com.alfarouq.personal_finance_tracker.service.ExpenseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, @RequestParam Long categoryId){
        return expenseService.createExpense(expense, categoryId);
    }

    @GetMapping("/{id}")
    public Expense getExpense(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @GetMapping
    public List<Expense> listAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable Long id, @RequestParam(required = false) Long categoryId){
        return expenseService.updateExpense(expense, id, categoryId);
    }

}
