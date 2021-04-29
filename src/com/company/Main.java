package com.company;

import com.company.Repository.CartRepository;
import com.company.Repository.CartRepositoryInMemory;
import com.company.Repository.ProductRepository;
import com.company.Repository.ProductRepositoryInMemory;
import com.company.Repository.UserRepository;
import com.company.Repository.UserRepositoryInMemory;
import com.company.constant.CommandType;
import com.company.model.Product;
import com.company.model.User;
import com.company.service.CartService;
import com.company.service.CheckoutService;
import com.company.service.LoginService;
import com.company.service.ProductService;
import com.company.service.UserService;

import java.util.Date;
import java.util.Scanner;

import static com.company.constant.CommandType.EXIT;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepositoryInMemory();
        CartRepository cartRepository = new CartRepositoryInMemory();
        LoginService loginService = new LoginService();
        CartService cartService = new CartService(cartRepository,productRepository);
        CheckoutService checkoutService = new CheckoutService(cartRepository,loginService);

        UserRepository userRepository =new  UserRepositoryInMemory();
        UserService userService = new UserService(userRepository,cartService);
        userService.createUser(new User("u1","user1","Bangalore",new Date()));
        userService.createUser(new User("u2","user2","Chennai",new Date()));
        userService.createUser(new User("u3","user3","Patna",new Date()));
        userService.createUser(new User("u4","user4","GKP",new Date()));

        ProductService productService = new ProductService(productRepository);
        productService.createProduct(new Product("p1","First product","Recriminatory",10000));
        productService.createProduct(new Product("p2","First product","Books",1000));
        productService.createProduct(new Product("p3","First product","Shoes",800));
        productService.createProduct(new Product("p4","First product","Watch",4000));



        Scanner scanner = new Scanner(System.in);
        while (true){
            String command = scanner.nextLine();
            String [] commands = command.split(" ");
            CommandType commandType = CommandType.valueOf(commands[0]);
            if (commandType.equals(EXIT)){
                break;
            }
            String userId = "";
            switch (commandType){
                case LOGIN:
                    userId = commands[1];
                    loginService.logInUser(userId);
                    break;
                case LOGOUT:
                    userId = commands[1];
                    loginService.logOutUser(userId);
                    break;
                case ADD_TO_CART:
                    userId = commands[1];
                    String productId = commands[2];
                    int quantity = Integer.parseInt(commands[3]);
                    cartService.addToCart(userId, productId, quantity);
                    break;
                case SHOW_CATALOG:
                    userId = commands[1];
                    productService.showCatalog(userId);
                    break;
                case CHECKOUT:
                    userId = commands[1];
                    checkoutService.checkoutUser(userId);
                    break;
            }
        }
    }
}
