package com.imalittletester;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class WarehouseTest {
    Warehouse warehouse;

    @Test
    @DisplayName("Add Products")
    void shouldAddProducts() {
        warehouse = new Warehouse();
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 7);

        Assertions.assertEquals(2, warehouse.products().size());
    }

    @Nested
    @DisplayName("When Checking Price of")
    class WhenCheckingPrice {
        @Test
        @DisplayName("Existent Product")
        void shouldCheckPriceOfExistingProduct() {
            warehouse = new Warehouse();
            warehouse.addProduct("milk", 3, 10);
            int price = warehouse.price("milk");

            Assertions.assertEquals(3, price);
        }

        @Test
        @DisplayName("Non Existent Product")
        void shouldCheckPriceMinus99WhenNoProduct() {
            warehouse = new Warehouse();
            int price = warehouse.price("milk");

            Assertions.assertEquals(-99, price);
        }
    }

    @Nested
    @DisplayName("When Checking Stock of")
    class WhenCheckingStock {
        @Test
        @DisplayName("Existent Product")
        void shouldCheckStockOfExistingProduct() {
            warehouse = new Warehouse();
            warehouse.addProduct("milk", 3, 10);
            int stock = warehouse.stock("milk");

            Assertions.assertEquals(10, stock);
        }

        @Test
        @DisplayName("Non Existent Product")
        void shouldCheckStockZeroWhenNoProduct() {
            warehouse = new Warehouse();
            int stock = warehouse.stock("milk");

            Assertions.assertEquals(0, stock);
        }
    }

}
