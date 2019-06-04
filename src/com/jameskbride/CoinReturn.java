package com.jameskbride;

import java.util.ArrayList;
import java.util.List;

public class CoinReturn {

    private final List<String> returnedCoins;

    public CoinReturn() {
        this.returnedCoins = new ArrayList<String>();
    }
    public void add(String coin) {
        this.returnedCoins.add(coin);
    }

    public List<String> getReturnedCoins() {
        return returnedCoins;
    }
}
