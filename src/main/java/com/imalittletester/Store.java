package com.imalittletester;

import java.util.Scanner;

public class Store {
    private final Warehouse warehouse;
    private final Scanner scan;

    public Store(Warehouse warehouse, Scanner scan) {
        this.warehouse = warehouse;
        this.scan = scan;
    }

    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for(String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while(true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scan.nextLine();
            if (product.isEmpty()) {
                break;
            } else {
                boolean valid = this.warehouse.take(product);
                if(valid) {
                    cart.add(product, this.warehouse.price(product));
                } else {
                    System.out.println("No product with this name.");
                }
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct("coffee", 5, 10);
        warehouse.addProduct("milk", 3, 20);
        warehouse.addProduct("cream", 2, 55);
        warehouse.addProduct("bread", 7, 8);

        Scanner scanner = new Scanner(System.in);

        Store store = new Store(warehouse, scanner);
        store.shop("John");
    }
}
