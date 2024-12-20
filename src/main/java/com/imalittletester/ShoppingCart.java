package com.imalittletester;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if(price > 0) {
            if(cart.get(product) == null) {
                cart.put(product, new Item(product, 1, price));
            } else {
                cart.get(product).increaseQuantity();
            }
        }
    }

    public int price() {
        int total = 0;
        for(Item product : cart.values()) {
            total += product.price();
        };

        return total;
    }

    public void print() {
        for(Item product : cart.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("buttermilk", 2);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");

        cart.add("milk", 3);
        cart.print();
        System.out.println("cart price: " + cart.price() + "\n");
    }
}
