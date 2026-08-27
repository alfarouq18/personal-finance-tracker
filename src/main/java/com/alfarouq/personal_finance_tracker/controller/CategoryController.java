package com.alfarouq.personal_finance_tracker.controller;

import com.alfarouq.personal_finance_tracker.model.Category;
import com.alfarouq.personal_finance_tracker.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public List<Category> listAllCategories(){
        return categoryService.getAllCategories();
    }


}
