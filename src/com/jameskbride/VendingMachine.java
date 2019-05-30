package com.jameskbride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    public static final String NICKEL = "NICKEL";
    public static final String DIME = "DIME";
    public static final String QUARTER = "QUARTER";
    private final CoinRegister coinRegister;

    private Map<String, Double> coinMap;
    private List<String> coinReturn;

    public VendingMachine() {
        this.coinRegister = new CoinRegister();
        coinReturn = new ArrayList<>();
        initializeCoinMap();
    }

    private void initializeCoinMap() {
        coinMap = new HashMap<>();
        coinMap.put(NICKEL, 0.05);
        coinMap.put(DIME, 0.10);
        coinMap.put(QUARTER, 0.25);
    }

    public String display() {
        if (coinRegister.getTotal() > 0) {
            return String.format("$%.2f", coinRegister.getTotal());
        }

        return "INSERT COIN";
    }

    public void insertCoin(String coin) {
        if (coinMap.containsKey(coin)) {
            coinRegister.addValue(coinMap.get(coin));
            return;
        }

        coinReturn.add(coin);
    }

    public List<String> coinReturn() {
        return coinReturn;
    }
}
