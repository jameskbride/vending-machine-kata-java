package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.jameskbride.CoinAware.*;
import static org.junit.Assert.*;

public class CoinRegisterTest {

    private CoinRegister coinRegister;

    @Before
    public void setUp() {
        coinRegister = new CoinRegister();
    }

    @Test
    public void givenTheSameAmountOfMoneyInTheRegisterWhenChangeIsMadeThenItDoesNotReturnCoins() {
        coinRegister.addValue(NICKEL);

        List<String> change = coinRegister.makeChange(0.05);

        assertEquals(0, change.size());
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs25CentsIsMadeThenItReturnsAQuarter() {
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);

        List<String> change = coinRegister.makeChange(0.50);

        assertEquals(1, change.size());
        assertEquals(QUARTER, change.get(0));
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs10CentsIsMadeThenItReturnsADime() {
        coinRegister.addValue(DIME);
        coinRegister.addValue(DIME);

        List<String> change = coinRegister.makeChange(0.10);

        assertEquals(1, change.size());
        assertEquals(DIME, change.get(0));
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs5CentsIsMadeThenItReturnsANickel() {
        coinRegister.addValue(NICKEL);
        coinRegister.addValue(NICKEL);

        List<String> change = coinRegister.makeChange(0.05);

        assertEquals(1, change.size());
        assertEquals(NICKEL, change.get(0));
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs35CentsItReturnsMultipleCoins() {
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(DIME);
        coinRegister.addValue(NICKEL);

        List<String> change = coinRegister.makeChange(0.50);

        assertEquals(3, change.size());
        assertTrue(change.containsAll(Arrays.asList(QUARTER, DIME, NICKEL)));
    }

    @Test
    public void givenCoinsHaveBeenAddedWhenTheCoinsAreReturnedThenAllCoinsAreReturned() {
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(DIME);
        coinRegister.addValue(NICKEL);

        List<String> coins = coinRegister.returnCoins();

        assertEquals(3, coins.size());
        assertTrue(coins.containsAll(Arrays.asList(QUARTER, DIME, NICKEL)));
    }
}