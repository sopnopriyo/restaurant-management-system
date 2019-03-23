/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.billing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sopnopriyo
 */
public class Recipt {
    
    private List<String> cart;
    private double totalPrice;
    
    public Recipt() {
        this.cart = new ArrayList<>();
        this.totalPrice = 0;
    }
    
    private void add(String item) {
        cart.add(item);
    }

    public List<String> getCart() {
        return cart;
    }

    public void setCart(List<String> cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
