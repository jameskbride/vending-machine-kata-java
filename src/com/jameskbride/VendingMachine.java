package com.jameskbride;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine implements CoinAware {

    private final CoinRegister coinRegister;
    private final Display display;
    private final ProductInventory productInventory;

    private List<String> coinReturn;

    public VendingMachine() {
        this.display = new Display();
        this.coinRegister = new CoinRegister();
        this.productInventory = new ProductInventory();
        coinReturn = new ArrayList<>();
    }

    public String display() {
        return display.displayFormattedAmount();
    }

    public void insertCoin(String coin) {
        if (coinRegister.isValidCoin(coin)) {
            coinRegister.addValue(coin);
            display.setRequestedAmount(coinRegister.getTotal());
            return;
        }

        coinReturn.add(coin);
    }

    public List<String> coinReturn() {
        return coinReturn;
    }

    public void vend(String chips) {
        Double productCost = productInventory.getProductCost(chips);
        if (coinRegister.getTotal() >= productCost) {
            display.setThankYou(true);
            display.setRequestedAmount(0);
            return;
        }
        display.setInsufficientFunds(true);
        display.setRequestedAmount(productCost);
    }
}
