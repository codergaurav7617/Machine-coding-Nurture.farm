package com.company.Repository;

import com.company.model.Product;

import java.util.Map;

public interface ProductRepository {
    void createProduct(Product product);
    Product getProduct(String productId);
    Map<String,Product> getProductMap();
}
