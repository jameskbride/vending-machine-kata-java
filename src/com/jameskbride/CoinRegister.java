package com.jameskbride;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return Arrays.asList(CoinAware.QUARTER);
    }
}
