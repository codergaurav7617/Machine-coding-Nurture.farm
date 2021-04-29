package com.company.service;

import com.company.Repository.CartRepository;
import com.company.model.Cart;
import com.company.model.Item;

import java.util.List;

public class CheckoutService {
    private CartRepository cartRepository;
    private LoginService loginService;

    public CheckoutService(CartRepository cartRepository, LoginService loginService) {
        this.cartRepository = cartRepository;
        this.loginService = loginService;
    }

    public void checkoutUser(String userID){
        if (!loginService.isLoggedIn(userID)){
            System.out.println("Please login to checkout the cart");
            return;
        }
        Cart cart = cartRepository.getCart(userID);
        getTotalPriceOfCart(cart);
    }

    private void getTotalPriceOfCart(Cart cart){
        List<Item> items = cart.getItemsList();
        double totalAmount = 0;
        for(int index=0;index<items.size();index++){
            Item item =  items.get(index);
            totalAmount += (item.getQuantity() * item.getProduct().getPrice());
        }
        System.out.println("Total payable amount for the user is : "+totalAmount);
    }
}
