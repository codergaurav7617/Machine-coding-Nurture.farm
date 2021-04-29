package com.company.service;

import com.company.Repository.CartRepository;
import com.company.Repository.ProductRepository;
import com.company.model.Item;
import com.company.model.Product;
import com.company.model.User;

public class CartService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void createCart(User user){
        cartRepository.createCart(user);
    }

    public void addToCart(String userId, String productId, int quantity){
        cartRepository.getCart(userId);
        Product product = productRepository.getProduct(productId);
        Item item = new Item(product, quantity);
        cartRepository.addItemToCart(userId, item);
    }
}
