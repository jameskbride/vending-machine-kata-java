package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("CHIPS", 0.65);
    }

    @Test
    public void itHasAQuantityOfZeroWhenItIsCreated() {
        assertEquals(0, product.getQuantity());
    }

    @Test
    public void itCanIncreaseItsQuantity() {
        product.increaseQuantity(2);

        assertEquals(2, product.getQuantity());
    }

    @Test
    public void itCanDecreaseItsQuantity() {
        product.increaseQuantity(1);

        product.decreaseQuantity(1);

        assertEquals(0, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void itCannotBeDecrementedToLessThanZero() {
        product.increaseQuantity(1);

        product.decreaseQuantity(2);
    }
}