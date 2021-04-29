package com.company.Repository;

import com.company.model.Cart;
import com.company.model.Item;
import com.company.model.User;

public interface CartRepository {
    void createCart(User user);
    Cart getCart(String id);
    void addItemToCart(String userId, Item item);
}
