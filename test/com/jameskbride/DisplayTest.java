package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {

    private Display display;

    @Before
    public void setUp() {
        display = new Display();
    }

    @Test
    public void whenTheRequestedAmountIsSetThenTheFormattedAmountIsDisplayed() {
        display.setRequestedAmount(0.75);

        assertEquals("$0.75", display.displayFormattedAmount());
    }

    @Test
    public void whenTheRequestedAmountItSetMultipleTimesItUpdatesTheFormattedAmount() {
        display.setRequestedAmount(0.75);
        display.setRequestedAmount(0.25);

        assertEquals("$0.25", display.displayFormattedAmount());
    }

    @Test
    public void givenTheRequestedAmountIsZeroThenItDisplaysInsertCoin() {
        assertEquals("INSERT COIN", display.displayFormattedAmount());
    }

}