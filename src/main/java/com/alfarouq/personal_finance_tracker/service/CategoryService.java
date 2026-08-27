package com.alfarouq.personal_finance_tracker.service;

import com.alfarouq.personal_finance_tracker.model.Category;
import com.alfarouq.personal_finance_tracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    final private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(()-> new IllegalArgumentException("Category Not Found!"));
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
