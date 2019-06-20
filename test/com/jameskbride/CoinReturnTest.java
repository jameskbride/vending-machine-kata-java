package com.jameskbride;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinReturnTest {

    @Test
    public void givenCoinsWhenTheCoinsAreReturnedThenNoCoinsAreInTheCoinReturn() {
        CoinReturn coinReturn = new CoinReturn();
        coinReturn.add("some coin");

        coinReturn.clear();

        assertTrue(coinReturn.getReturnedCoins().isEmpty());
    }
}