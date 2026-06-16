package com.sakila.sakila_api.service;

import com.sakila.sakila_api.model.Product;
import com.sakila.sakila_api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {return productRepository.findAll(); }

    public Optional<Product> getProductById(Long id) { return productRepository.findById(id); }

    public List<Product> getProductByCategoryId(Long id) { return productRepository.findByCategoryId(id); }

    public List<Product> getProductByName(String name) { return  productRepository.findByProductNameContainingIgnoreCase(name); }

    @Transactional
    public Product createProduct(Product product) { return productRepository.save(product); }

    public boolean removeProduct(Long id){

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
