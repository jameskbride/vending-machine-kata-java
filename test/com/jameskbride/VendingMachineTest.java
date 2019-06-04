package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final String INVALID_COIN = "wooden nickel";

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

    @Test
    public void givenAnInvalidCoinHasBeenInsertedThenItDisplaysINSERT_COIN() {
        vendingMachine.insertCoin(INVALID_COIN);

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenValidCoinsAreInsertedWhenAnInvalidCoinIsInsertedThenTheTotalIsNotUpdated() {
        vendingMachine.insertCoin(VendingMachine.QUARTER);

        vendingMachine.insertCoin(INVALID_COIN);

        assertEquals("$0.25", vendingMachine.display());
    }

    @Test
    public void givenAnInvalidCoinThenTheCoinIsPlacedInTheCoinReturn() {
        vendingMachine.insertCoin(INVALID_COIN);

        assertTrue(vendingMachine.coinReturn().contains(INVALID_COIN));
    }

    @Test
    public void givenMultipleInvalidCoinsThenTheCoinsArePlacedInTheCoinReturn() {
        String differentCoin = "different coin";
        vendingMachine.insertCoin(differentCoin);
        vendingMachine.insertCoin(INVALID_COIN);

        List<String> invalidCoins = new ArrayList<>();
        invalidCoins.add(INVALID_COIN);
        invalidCoins.add(differentCoin);

        assertTrue(vendingMachine.coinReturn().containsAll(invalidCoins));
    }

    @Test
    public void givenInsufficientFundsWhenColaIsRequestedThenDisplayTheAmountForCola() {
        vendingMachine.vend("COLA");

        assertEquals("PRICE $1.00", vendingMachine.display());
    }

    @Test
    public void givenInsufficientFundsWhenChipsAreRequestedThenDisplayTheAmountForChips() {
        vendingMachine.vend("CHIPS");

        assertEquals("PRICE $0.50", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsWhenChipsAreRequestedThenItDisplaysTHANK_YOU() {
        vendingMachine.insertCoin(VendingMachine.QUARTER);
        vendingMachine.insertCoin(VendingMachine.QUARTER);
        vendingMachine.insertCoin(VendingMachine.QUARTER);

        vendingMachine.vend("CHIPS");

        assertEquals("THANK YOU", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsAndTheDisplayHasBeenCheckedWhenChipsAreRequestedThenItDisplaysINSERT_COIN() {
        vendingMachine.insertCoin(VendingMachine.QUARTER);
        vendingMachine.insertCoin(VendingMachine.QUARTER);
        vendingMachine.insertCoin(VendingMachine.QUARTER);

        vendingMachine.vend("CHIPS");
        vendingMachine.display();

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenInsufficientFundsAndTheDisplayHasBeenCheckedWhenTheDisplayIsCheckedAgainThenItDisplaysTheCurrentAmount() {
        vendingMachine.insertCoin(VendingMachine.QUARTER);

        vendingMachine.display();

        assertEquals("$0.25", vendingMachine.display());
    }
}
