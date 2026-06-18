package com.sakila.sakila_api.service;

import com.sakila.sakila_api.model.Category;
import com.sakila.sakila_api.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    public List<Category> getAllCategories() { return categoryRepository.findAll(); }

    public Optional<Category> getCategoryById(Long id) { return categoryRepository.findById(id); }

    public List<Category> getCategoryByName(String name) { return categoryRepository.findByCategoryNameContainingIgnoreCase(name); }

    public Optional<Category> updateCategory(Long id, Category newCategory){
        return categoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setCategoryName(newCategory.getCategoryName());
            existingCategory.setDescription(newCategory.getDescription());
            return categoryRepository.save(existingCategory);
        });

    }
    @Transactional
    public Category createCategory(Category category) { return categoryRepository.save(category); }

    @Transactional
    public boolean deleteCategory(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
