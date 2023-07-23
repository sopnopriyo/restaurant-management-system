/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantsystem.model;

/**
 *
 * @author melis
 */
public class CartIterator implements Iterator {
    private Cart cart;
    private int currentState = 0;
    
    public CartIterator(Cart cart){
        this.cart = cart;
    }
    
    @Override
    public CartItem next() {
        CartItem item = cart.getCartItems().get(currentState);
        currentState ++;
        return item;
    }

    @Override
    public boolean hasNext() {
        return cart.getCartItems().size()-1 != currentState;
    }
    
}
