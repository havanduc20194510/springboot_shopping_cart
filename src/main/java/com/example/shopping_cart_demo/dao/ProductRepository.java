package com.example.shopping_cart_demo.dao;

import com.example.shopping_cart_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findBySku(String sku);
}
