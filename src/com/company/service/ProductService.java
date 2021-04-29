package com.company.service;

import com.company.Repository.ProductRepository;
import com.company.model.Product;

import java.util.Map;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product){
        productRepository.createProduct(product);
    }

    public void showCatalog(String userId){
        Map<String,Product> productMap = productRepository.getProductMap();
        for (Map.Entry<String,Product> productEntry : productMap.entrySet()){
            System.out.println(productEntry.getValue());
        }
    }
}
