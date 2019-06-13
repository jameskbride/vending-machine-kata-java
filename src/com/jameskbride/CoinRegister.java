package com.jameskbride;

import java.util.*;

import static com.jameskbride.CoinAware.*;

public class CoinRegister implements CoinAware {

    private double total;
    private Map<String, Double> coinMap;

    public CoinRegister() {
        total = 0;
        initializeCoinMap();
    }

    public double getTotal() {
        return total;
    }

    public void addValue(String value) {
        this.total = total + coinMap.get(value);
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
}
