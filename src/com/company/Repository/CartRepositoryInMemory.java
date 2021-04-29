package com.company.Repository;

import com.company.model.Cart;
import com.company.model.Item;
import com.company.model.User;

import java.util.HashMap;
import java.util.Map;

public class CartRepositoryInMemory implements CartRepository{
    Map<String,Cart> cartMap;

    public CartRepositoryInMemory() {
        this.cartMap = new HashMap<>();
    }

    @Override
    public void createCart(User user) {
        Cart cart = new Cart(user);
        cartMap.put(user.getUserId(),cart);
    }

    @Override
    public Cart getCart(String id) {
        return cartMap.get(id);
    }

    @Override
    public void addItemToCart(String userId, Item item) {
        cartMap.get(userId).getItemsList().add(item);
    }
}
