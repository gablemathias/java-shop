package com.imalittletester;

public class Item {
    private final String product;
    private int quantity;
    private final int unitPrice;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return unitPrice * quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", product, quantity);
    }

    public static void main(String[] args) {
        Item item = new Item("milk", 4, 2);
        System.out.println("an item that contains 4 milks has the total price of " + item.price());
        System.out.println(item);
        item.increaseQuantity();
        System.out.println(item);
    }
}
