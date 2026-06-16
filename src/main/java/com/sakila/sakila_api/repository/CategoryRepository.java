package com.sakila.sakila_api.repository;

import com.sakila.sakila_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findByCategoryNameContainingIgnoreCase(String name);
}
