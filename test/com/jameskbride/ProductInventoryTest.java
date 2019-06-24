package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductInventoryTest {

    private ProductInventory productInventory;

    @Before
    public void setUp() {
        productInventory = new ProductInventory();
    }

    @Test
    public void whenAProductHasBeenAddedThenItIsInStock() {
        productInventory.addProduct("CHIPS");

        assertTrue(productInventory.isInStock("CHIPS"));
    }

    @Test
    public void whenAProductHasNotBeenAddedThenItIsOutOfStock() {
        assertFalse(productInventory.isInStock("CHIPS"));
    }
}