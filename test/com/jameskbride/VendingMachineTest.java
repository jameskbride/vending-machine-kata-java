package com.jameskbride;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    @Test
    public void givenNoCoinsAreInsertedThenItDisplaysINSERT_COIN() {
        VendingMachine vendingMachine = new VendingMachine();

        assertEquals("INSERT COIN", vendingMachine.display());
    }
}
