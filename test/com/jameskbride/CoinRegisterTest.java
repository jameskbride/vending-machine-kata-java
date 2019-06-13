package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CoinRegisterTest {

    private CoinRegister coinRegister;

    @Before
    public void setUp() {
        coinRegister = new CoinRegister();
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIsMadeThenItReturnsCoinsAListOfCoins() {
        coinRegister.addValue(CoinAware.QUARTER);
        coinRegister.addValue(CoinAware.QUARTER);
        coinRegister.addValue(CoinAware.QUARTER);

        List<String> change = coinRegister.makeChange(0.50);

        assertEquals(1, change.size());
        assertEquals(CoinAware.QUARTER, change.get(0));
    }

    @Test
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs35CentsItReturnsAQuarterAndADime() {
        coinRegister.addValue(CoinAware.QUARTER);
        coinRegister.addValue(CoinAware.QUARTER);
        coinRegister.addValue(CoinAware.QUARTER);
        coinRegister.addValue(CoinAware.DIME);

        List<String> change = coinRegister.makeChange(0.50);

        assertEquals(2, change.size());
        assertTrue(change.containsAll(Arrays.asList(CoinAware.QUARTER, CoinAware.DIME)));
    }
}