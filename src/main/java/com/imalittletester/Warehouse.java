package com.imalittletester;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, int[]> products = new HashMap<>();

    public void addProduct(String product, int price, int stock) {
        products.put(product, new int[] {price, stock});
    }

    public int price(String product) {
        if(products.containsKey(product)) {
            return products.get(product)[0];
        }

        return -99;
    }

    public Map<String, int[]> getProducts() {
        return products;
    }

    public static void main(String[] args) {
    }
}
