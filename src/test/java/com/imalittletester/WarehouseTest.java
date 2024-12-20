package com.imalittletester;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

class WarehouseTest {
    Warehouse warehouse;

    @Nested
    @DisplayName("When Adding Products")
    class WhenAddingProducts {
        Warehouse warehouse = new Warehouse();

        @Test
        @DisplayName("Add Products")
        void shouldAddProducts() {
            warehouse.addProduct("milk", 3, 10);
            warehouse.addProduct("coffee", 5, 7);

            Assertions.assertEquals(2, warehouse.products().size());
        }

        @Test
        @DisplayName("Can't Add Products with Negative Price")
        void shouldNotAddProductsWithNegativePrice() {
            warehouse.addProduct("banana", -3, 7);
            int productPrice = warehouse.price("banana");

            Assertions.assertNotEquals(-3, productPrice);
            Assertions.assertFalse(warehouse.products().contains("banana"));
            Assertions.assertEquals(-99, productPrice);
        }
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
    @DisplayName("When Checking Stock")
    class WhenCheckingStock {
        @Test
        @DisplayName("of Existent Product")
        void shouldCheckStockOfExistingProduct() {
            warehouse = new Warehouse();
            warehouse.addProduct("milk", 3, 10);
            int stock = warehouse.stock("milk");

            Assertions.assertEquals(10, stock);
        }

        @Test
        @DisplayName("of Non Existent Product")
        void shouldCheckStockZeroWhenNoProduct() {
            warehouse = new Warehouse();
            int stock = warehouse.stock("milk");

            Assertions.assertEquals(0, stock);
        }
    }

    @Test
    @DisplayName("Change Stock Quantity When Product is Taken")
    void shouldChangeStockValue() {
        warehouse = new Warehouse();
        warehouse.addProduct("milk", 3, 10);

        Assertions.assertTrue(warehouse.take("milk"));
        Assertions.assertEquals(9, warehouse.stock("milk"));
    }

}
