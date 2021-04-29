package com.company.service;

import com.company.Repository.UserRepository;
import com.company.model.User;

public class UserService {
    private UserRepository userRepository;
    private CartService cartService;

    public UserService(UserRepository userRepository, CartService cartService) {
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    public void createUser(User user){
        userRepository.addUserToMap(user);
        cartService.createCart(user);
    }


}
