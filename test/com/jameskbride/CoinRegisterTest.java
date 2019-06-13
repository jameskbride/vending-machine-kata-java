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
    public void givenMoreThanEnoughMoneyInTheRegisterWhenChangeIs35CentsItReturnsAQuarterAndADime() {
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(QUARTER);
        coinRegister.addValue(DIME);

        List<String> change = coinRegister.makeChange(0.50);

        assertEquals(2, change.size());
        assertTrue(change.containsAll(Arrays.asList(QUARTER, DIME)));
    }
}