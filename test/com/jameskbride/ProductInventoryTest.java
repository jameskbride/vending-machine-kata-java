package com.jameskbride;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductInventoryTest {

    @Test
    public void whenAProductHasBeenAddedThenItIsInStock() {
        ProductInventory productInventory = new ProductInventory();

        productInventory.addProduct("CHIPS");

        assertTrue(productInventory.isInStock("CHIPS"));
    }

}