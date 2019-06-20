package com.jameskbride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinRegister implements CoinAware {

    private final List<String> insertedCoins;
    private double total;
    private Map<String, Double> coinMap;

    public CoinRegister() {
        total = 0;
        initializeCoinMap();
        this.insertedCoins = new ArrayList<>();
    }

    public double getTotal() {
        return total;
    }

    public void addValue(String value) {
        this.total = total + coinMap.get(value);
        insertedCoins.add(value);
    }

    private void initializeCoinMap() {
        coinMap = new HashMap<>();
        coinMap.put(NICKEL, 0.05);
        coinMap.put(DIME, 0.10);
        coinMap.put(QUARTER, 0.25);
    }

    public boolean isValidCoin(String coin) {
        return coinMap.containsKey(coin);
    }

    public boolean hasSufficientFunds(Double productCost) {
        return total >= productCost;
    }

    public List<String> makeChange(Double cost) {
        final int change = calculateChange(cost);
        List<String> allCoins = new ArrayList<>();
        int remainingChange = change;
        while(remainingChange >= 25) {
            allCoins.add(QUARTER);
            remainingChange -= 25;
        }

        while(remainingChange >= 10) {
            allCoins.add(DIME);
            remainingChange -= 10;
        }

        while(remainingChange >= 5) {
            allCoins.add(NICKEL);
            remainingChange -= 5;
        }

        return allCoins;
    }

    private int calculateChange(Double cost) {
        return (int) (Math.ceil((total - cost) * 100));
    }

    public List<String> returnCoins() {
        this.total = 0;
        return insertedCoins;
    }
}
