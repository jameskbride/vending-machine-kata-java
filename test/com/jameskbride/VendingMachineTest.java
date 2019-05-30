package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void givenNoCoinsAreInsertedThenItDisplaysINSERT_COIN() {
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenANickelItDisplaysFiveCents() {
        vendingMachine.insertCoin("NICKEL");

        assertEquals("$0.05", vendingMachine.display());
    }

    @Test
    public void givenADimeItDisplaysTenCents() {
        vendingMachine.insertCoin("DIME");

        assertEquals("$0.10", vendingMachine.display());
    }

    @Test
    public void givenAQuarterItDisplaysTwentyFiveCents() {
        vendingMachine.insertCoin("QUARTER");

        assertEquals("$0.25", vendingMachine.display());
    }

    @Test
    public void givenMultipleCoinsItDisplaysTheTotal() {
        vendingMachine.insertCoin(VendingMachine.NICKEL);
        vendingMachine.insertCoin(VendingMachine.DIME);
        vendingMachine.insertCoin(VendingMachine.QUARTER);

        assertEquals("$0.40", vendingMachine.display());
    }
}
