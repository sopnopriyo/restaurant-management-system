/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.service;

import java.util.ArrayList;
import restaurantsystem.model.Cart;
import restaurantsystem.model.CartItem;

/**
 *
 * @author Sopnopriyo
 */
public class OrderService {
    
    private Cart cart;
    
    public OrderService() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public void addToCart(CartItem cartItem) {
        this.cart.addItemToCart(cartItem);
    }
    
    public void clearCart() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public Cart getCart() {
        return this.cart;
    }
}
