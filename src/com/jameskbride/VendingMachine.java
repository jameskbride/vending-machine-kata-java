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
    private final Display display;

    private Map<String, Double> coinMap;
    private List<String> coinReturn;

    private Map<String,Double> productMap;

    public VendingMachine() {
        this.display = new Display();
        this.coinRegister = new CoinRegister();
        coinReturn = new ArrayList<>();
        initializeCoinMap();
        initializeProductMap();
    }

    private void initializeProductMap() {
        productMap = new HashMap<>();
        productMap.put("CHIPS", 0.50);
        productMap.put("COLA", 1.00);
    }

    private void initializeCoinMap() {
        coinMap = new HashMap<>();
        coinMap.put(NICKEL, 0.05);
        coinMap.put(DIME, 0.10);
        coinMap.put(QUARTER, 0.25);
    }

    public String display() {
        return display.displayFormattedAmount();
    }

    public void insertCoin(String coin) {
        if (coinMap.containsKey(coin)) {
            coinRegister.addValue(coinMap.get(coin));
            display.setRequestedAmount(coinRegister.getTotal());
            return;
        }

        coinReturn.add(coin);
    }

    public List<String> coinReturn() {
        return coinReturn;
    }

    public void vend(String chips) {
        Double productCost = productMap.get(chips);
        if (coinRegister.getTotal() >= productCost) {
            display.setThankYou(true);
            display.setRequestedAmount(0);
            return;
        }
        display.setInsufficientFunds(true);
        display.setRequestedAmount(productCost);
    }
}
