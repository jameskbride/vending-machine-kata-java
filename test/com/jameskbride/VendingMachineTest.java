package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jameskbride.CoinAware.*;
import static com.jameskbride.Products.*;
import static com.jameskbride.VendingMachine.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final String INVALID_COIN = "wooden nickel";

    private VendingMachine vendingMachine;

    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
        vendingMachine.addProduct(CHIPS);
        vendingMachine.addProduct(CANDY);
        vendingMachine.addProduct(COLA);
    }

    @Test
    public void givenNoCoinsAreInsertedThenItDisplaysINSERT_COIN() {
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenANickelItDisplaysFiveCents() {
        vendingMachine.insertCoin(NICKEL);

        assertEquals("$0.05", vendingMachine.display());
    }

    @Test
    public void givenADimeItDisplaysTenCents() {
        vendingMachine.insertCoin(DIME);

        assertEquals("$0.10", vendingMachine.display());
    }

    @Test
    public void givenAQuarterItDisplaysTwentyFiveCents() {
        vendingMachine.insertCoin(QUARTER);

        assertEquals("$0.25", vendingMachine.display());
    }

    @Test
    public void givenMultipleCoinsItDisplaysTheTotal() {
        vendingMachine.insertCoin(NICKEL);
        vendingMachine.insertCoin(DIME);
        vendingMachine.insertCoin(QUARTER);

        assertEquals("$0.40", vendingMachine.display());
    }

    @Test
    public void givenAnInvalidCoinHasBeenInsertedThenItDisplaysINSERT_COIN() {
        vendingMachine.insertCoin(INVALID_COIN);

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenValidCoinsAreInsertedWhenAnInvalidCoinIsInsertedThenTheTotalIsNotUpdated() {
        vendingMachine.insertCoin(QUARTER);

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
        vendingMachine.vend(COLA);

        assertEquals("PRICE $1.00", vendingMachine.display());
    }

    @Test
    public void givenInsufficientFundsWhenChipsAreRequestedThenDisplayTheAmountForChips() {
        vendingMachine.vend(CHIPS);

        assertEquals("PRICE $0.50", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsWhenChipsAreRequestedThenItDisplaysTHANK_YOU() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CHIPS);

        assertEquals("THANK YOU", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsAndTheDisplayHasBeenCheckedWhenChipsAreRequestedThenItDisplaysINSERT_COIN() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CHIPS);
        vendingMachine.display();

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenInsufficientFundsAndTheDisplayHasBeenCheckedWhenTheDisplayIsCheckedAgainThenItDisplaysTheCurrentAmount() {
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.display();

        assertEquals("$0.25", vendingMachine.display());
    }

    @Test
    public void givenInsufficientFundsWhenCandyIsRequestedThenDisplayTheAmountForCandy() {
        vendingMachine.vend(CANDY);

        assertEquals("PRICE $0.65", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsWhenCandyIsRequestedThenItDisplaysTHANK_YOU() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CANDY);

        assertEquals("THANK YOU", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsAndTheDisplayHasBeenCheckedWhenCandyAreRequestedThenItDisplaysINSERT_COIN() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CANDY);
        vendingMachine.display();

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenSufficientFundsWhenAProductIsVendedThenAnyExtraMoneyIsDepositedIntoTheCoinReturn() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CANDY);

        assertTrue(vendingMachine.coinReturn().contains(DIME));
    }

    @Test
    public void givenMoreThanEnoughFundsWhenAProductIsVendedThenMultipleCoinsAreDepositedIntoTheCoinReturn() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(QUARTER);

        vendingMachine.vend(CHIPS);

        assertTrue(vendingMachine.coinReturn().containsAll(Arrays.asList(QUARTER, QUARTER)));
    }

    @Test
    public void givenCoinsInTheRegisterWhenTheReturnCoinsButtonIsPressedThenThenCoinsArePlacedInTheCoinReturn() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(INVALID_COIN);

        vendingMachine.returnCoins();

        assertTrue(vendingMachine.coinReturn().containsAll(Arrays.asList(QUARTER, INVALID_COIN)));
    }

    @Test
    public void givenCoinsInTheRegisterWhenTheReturnCoinsButtonIsPressedThenThenINSERT_COINSIsDisplayed() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(INVALID_COIN);

        vendingMachine.returnCoins();

        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void givenCoinsInTheRegisterHaveBeenReturnedWhenTheCoinReturnIsCheckedTwiceThenTheCoinsAreNotAvailableTheSecondTime() {
        vendingMachine.insertCoin(QUARTER);
        vendingMachine.insertCoin(INVALID_COIN);

        vendingMachine.returnCoins();
        vendingMachine.coinReturn();

        assertTrue(vendingMachine.coinReturn().isEmpty());
    }

    @Test
    public void givenAProductIsOutOfStockWhenItIsVendedThenItDisplaysSOLD_OUT() {
        vendingMachine.vend("INVALID");

        assertEquals("SOLD OUT", vendingMachine.display());
    }

    @Test
    public void givenNoMoneyAndAProductIsOutOfStockWhenItIsVendedThenItDisplaysINSERT_COINOnTheSecondDisplay() {
        vendingMachine.vend("INVALID");

        vendingMachine.display();
        assertEquals("INSERT COIN", vendingMachine.display());
    }
}
