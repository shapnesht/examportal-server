package com.exam.services;

import com.exam.model.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<?> getCategories();
    public Category getCategoryById(Long categoryId);
    void deleteCategory(Long categoryId);
}
