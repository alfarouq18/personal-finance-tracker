package com.alfarouq.personal_finance_tracker.service;

import com.alfarouq.personal_finance_tracker.model.Category;
import com.alfarouq.personal_finance_tracker.model.Expense;
import com.alfarouq.personal_finance_tracker.repository.CategoryRepository;
import com.alfarouq.personal_finance_tracker.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private CategoryRepository categoryRepository;


    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createExpense_ThrowsException_WhenCategoryNotFound(){
        Expense expense = new Expense();
        Long categoryId = 999L;
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> expenseService.createExpense(expense, categoryId));
    }

    @Test
    void createExpense_savesSuccessfully_whenCategoryExists(){

        Category category = new Category();
        category.setName("Category");
        Long categoryId = 999L;


        Expense expense = new Expense();
        BigDecimal amount = new BigDecimal("1.00");
        expense.setAmount(amount);

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        when(expenseRepository.save(expense)).thenReturn(expense);

        assertEquals(category, expenseService.createExpense(expense, categoryId).getCategory());

    }
}
