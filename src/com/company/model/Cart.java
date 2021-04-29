package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartId;
    private User user;
    List<Item> itemsList;

    public Cart(User user) {
        this.user = user;
        itemsList = new ArrayList<>();
    }

    public String getCartId() {
        return cartId;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }
}
