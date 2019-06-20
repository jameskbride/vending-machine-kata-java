package com.jameskbride;

import java.util.ArrayList;
import java.util.List;

public class CoinReturn {

    private final List<String> returnedCoins;

    public CoinReturn() {
        this.returnedCoins = new ArrayList<>();
    }
    public void add(String coin) {
        this.returnedCoins.add(coin);
    }

    public List<String> returnCoins() {
        List<String> coins = new ArrayList<>(this.returnedCoins);

        this.returnedCoins.clear();

        return coins;
    }

    public void clear() {
        this.returnedCoins.clear();
    }

    public void addAll(List<String> coins) {
        this.returnedCoins.addAll(coins);
    }
}
