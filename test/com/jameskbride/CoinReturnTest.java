package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.jameskbride.CoinAware.*;
import static org.junit.Assert.*;

public class CoinReturnTest {

    private CoinReturn coinReturn;

    @Before
    public void setUp() {
        coinReturn = new CoinReturn();
    }

    @Test
    public void givenCoinsWhenTheCoinsAreReturnedThenNoCoinsAreInTheCoinReturn() {
        coinReturn.add("some coin");

        coinReturn.clear();

        assertTrue(coinReturn.getReturnedCoins().isEmpty());
    }

    @Test
    public void whenMultipleCoinsAreAddedThenTheyAreAvailableInTheCoinReturn() {
        coinReturn.addAll(Arrays.asList(QUARTER, DIME, NICKEL));

        List<String> coins = coinReturn.getReturnedCoins();

        assertEquals(3, coins.size());
        assertTrue(coins.containsAll(Arrays.asList(QUARTER, DIME, NICKEL)));
    }
}