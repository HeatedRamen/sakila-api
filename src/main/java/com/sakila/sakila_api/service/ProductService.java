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

    public List<Product> getAllProducts() { return productRepository.findAllWithCategory(); }

    public Optional<Product> getProductById(Long id) { return productRepository.findById(id); }

    public List<Product> getProductByCategoryId(Long id) { return productRepository.findByCategoryId(id); }

    public List<Product> getProductByName(String name) { return  productRepository.findByProductNameContainingIgnoreCase(name); }

    public Optional<Product> updateProduct(Long id, Product newProduct){
        return productRepository.findById(id).map(existingProduct -> {
           existingProduct.setQuantityPerUnit(newProduct.getQuantityPerUnit());
            existingProduct.setUnitPrice(newProduct.getUnitPrice());
            existingProduct.setUnitsInStock(newProduct.getUnitsInStock());
            existingProduct.setUnitsOnOrder(newProduct.getUnitsOnOrder());
            existingProduct.setReorderLevel(newProduct.getReorderLevel());
            return productRepository.save(existingProduct);
        });
    }
    @Transactional
    public Product createProduct(Product product) { return productRepository.save(product); }

    @Transactional
    public boolean discontinueProduct(Long id){

        if(productRepository.existsById(id)){
            Product product = productRepository.getById(id);
            product.setDiscontinued(true);
            productRepository.save(product);
            return true;
        }
        return false;
    }


}
