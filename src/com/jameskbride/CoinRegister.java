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
        int change = (int) ((total % cost) * 100);
        List<String> quarters = new ArrayList<>();
        List<String> dimes = new ArrayList<>();
        int remainingChange = change;
        if (remainingChange > 0) {
            while(remainingChange >= 25) {
                quarters.add(QUARTER);
                remainingChange -= 25;
            }

            while(remainingChange >= 10) {
                dimes.add(DIME);
                remainingChange -= 10;
            }
        }

        List<String> allCoins = new ArrayList<>();
        allCoins.addAll(quarters);
        allCoins.addAll(dimes);

        return allCoins;
    }
}
