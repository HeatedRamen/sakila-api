package com.sakila.sakila_api.repository;

import com.sakila.sakila_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByCategoryId(Long categoryId);
    public Optional<Product> findByProductNameContainingIgnoreCase(String name);
}
