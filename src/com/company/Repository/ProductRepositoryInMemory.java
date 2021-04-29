package com.company.Repository;

import com.company.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryInMemory implements ProductRepository{
    private Map<String,Product> productMap;

    public ProductRepositoryInMemory() {
        this.productMap = new HashMap<>();
    }

    @Override
    public void createProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    @Override
    public Map<String, Product> getProductMap() {
        return productMap;
    }
}
