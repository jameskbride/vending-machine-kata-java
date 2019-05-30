package com.jameskbride;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private double total;
    private Map<String, Double> coinMap;

    public VendingMachine() {
        initializeCoinMap();
    }

    private void initializeCoinMap() {
        coinMap = new HashMap<>();
        coinMap.put("NICKEL", 0.05);
        coinMap.put("DIME", 0.10);
    }

    public String display() {

        if (total > 0) {
            return String.format("$%.2f", total);
        }

        return "INSERT COIN";
    }

    public void insertCoin(String coin) {
        if (coinMap.containsKey(coin)) {
            this.total =+ coinMap.get(coin);
        }
    }
}
