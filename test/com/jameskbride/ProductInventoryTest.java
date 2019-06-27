package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.Products.*;
import static org.junit.Assert.*;

public class ProductInventoryTest {

    private ProductInventory productInventory;

    @Before
    public void setUp() {
        productInventory = new ProductInventory();
    }

    @Test
    public void whenAProductHasBeenAddedThenItIsInStock() {
        productInventory.addProduct(CHIPS);

        assertTrue(productInventory.isInStock(CHIPS));
    }

    @Test
    public void whenAProductHasNotBeenAddedThenItIsOutOfStock() {
        assertFalse(productInventory.isInStock(CHIPS));
    }

    @Test
    public void givenAdProductHasBeenAddedMultipleTimesWhenTheProductIsReleasedThenItIsStillInStock() {
        productInventory.addProduct(CHIPS);
        productInventory.addProduct(CHIPS);

        productInventory.release(CHIPS);

        assertTrue(productInventory.isInStock(CHIPS));
    }

    @Test
    public void givenAProductHasBeenAddedWhenAnotherProductIsRequestedThenItIsOutOfStock() {
        productInventory.addProduct(CHIPS);

        assertFalse(productInventory.isInStock(CANDY));
    }

    @Test
    public void aProductIsNotInStockIfInventoryDoesNotKnowAboutIt() {
        assertFalse(productInventory.isInStock("POP ROCKS"));
    }
}