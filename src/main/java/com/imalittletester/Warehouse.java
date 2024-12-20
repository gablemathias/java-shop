package com.imalittletester;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private final Map<String, int[]> products = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        if (stock > 0) {
            products.put(product, new int[] {price, stock});
        }
    }

    public int price(String product) {
        if(products.containsKey(product)) {
            return products.get(product)[0];
        }

        return -99;
    }

    public int stock(String product) {
        if(products.containsKey(product)) {
            return products.get(product)[1];
        }

        return 0;
    }

    public boolean take(String product) {
        int quantity = stock(product);

        if(quantity > 0) {
            products.replace(product, new int[] {price(product), quantity - 1});
//            if (products.get(product)[1] == 0) {
//                products.remove(product);
//            }

            return true;
        }

        return false;
    }

    public Set<String> products() {
        return products.keySet();
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 6);
        warehouse.addProduct("buttermilk", 2, 20);
        warehouse.addProduct("yogurt", 2, 20);

        System.out.println("products:");

        for (String product: warehouse.products()) {
            System.out.println(product);
        }
    }
}
