package com.alfarouq.personal_finance_tracker.service;

import com.alfarouq.personal_finance_tracker.model.Category;
import com.alfarouq.personal_finance_tracker.model.Expense;
import com.alfarouq.personal_finance_tracker.repository.CategoryRepository;
import com.alfarouq.personal_finance_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    final private ExpenseRepository expenseRepository;

    final private CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository){
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Expense createExpense(Expense expense, Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category Not Found!"));
        expense.setCategory(category);
        return expenseRepository.save(expense);
    }

    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id Could Not Be Found!"));
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Expense incomingExpense, Long id, Long categoryId){
        Expense preExistingExpense = expenseRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id Could Not Be Found!"));

        if(incomingExpense.getAmount() != null){
            preExistingExpense.setAmount(incomingExpense.getAmount());
        }
        if(incomingExpense.getDescription() != null){
            preExistingExpense.setDescription(incomingExpense.getDescription());
        }
        if(incomingExpense.getDate() != null){
            preExistingExpense.setDate(incomingExpense.getDate());
        }
        if(categoryId != null){
            Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new IllegalArgumentException("Category Not Found!"));
            preExistingExpense.setCategory(category);
        }

        return expenseRepository.save(preExistingExpense);
    }

}
