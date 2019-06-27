package com.jameskbride;

import org.junit.Before;
import org.junit.Test;

import static com.jameskbride.Display.*;
import static org.junit.Assert.assertEquals;

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
        assertEquals(INSERT_COIN, display.displayFormattedAmount());
    }

    @Test
    public void givenInsufficientFundsHasBeenSetWhenTheFormattedAmountIsDisplayedThenItDisplaysPriceWithTheFormattedMessage() {
        display.setInsufficientFunds(true);

        display.setRequestedAmount(0.50);

        assertEquals("PRICE $0.50", display.displayFormattedAmount());
    }

    @Test
    public void givenThankYouHasBeenSetWhenTheRequestedAmountIsDisplayedThenItDisplaysThankYou() {
        display.setThankYou(true);

        display.setRequestedAmount(0.50);

        assertEquals(THANK_YOU, display.displayFormattedAmount());
    }

    @Test
    public void givenSoldOutHasBeenSetWhenTheRequestedAmountIsDisplayedThenItDisplaysSoldOut() {
        display.setSoldOut(true);

        assertEquals(SOLD_OUT, display.displayFormattedAmount());
    }

    @Test
    public void givenSoldOutIsFalseWhenTheRequestedAmountIsDisplayedThenItIsFormatted() {
        display.setSoldOut(false);

        display.setRequestedAmount(0.50);

        assertEquals("$0.50", display.displayFormattedAmount());
    }
}