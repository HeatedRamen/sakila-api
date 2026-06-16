package com.sakila.sakila_api.controller;

import com.sakila.sakila_api.model.Category;
import com.sakila.sakila_api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService){ this.categoryService = categoryService; }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() { return ResponseEntity.ok(categoryService.getAllCategories()); }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById (@PathVariable Long id){
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Optional<Category>> getCategoriesByName(@PathVariable String name){
        return ResponseEntity.ok(categoryService.getCategoryByName(name));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category created = categoryService.createCategory(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        boolean delete = categoryService.deleteCategory(id);

        if(delete){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}



