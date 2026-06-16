package com.sakila.sakila_api.controller;

import com.sakila.sakila_api.model.Product;
import com.sakila.sakila_api.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){ this.productService = productService; }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() { return ResponseEntity.ok(productService.getAllProducts()); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.getProductByCategoryId(categoryId));
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product created = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id){

        productService.removeProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
