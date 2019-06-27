package com.jameskbride;

import java.util.List;

public class VendingMachine implements CoinAware {

    private final CoinRegister coinRegister;
    private final Display display;
    private final ProductInventory productInventory;
    private final CoinReturn coinReturn;

    public VendingMachine() {
        this.display = new Display();
        this.coinRegister = new CoinRegister();
        this.productInventory = new ProductInventory();
        coinReturn = new CoinReturn();
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
        return coinReturn.returnCoins();
    }

    public void vend(String product) {
        if (productInventory.isInStock(product)) {
            Double productCost = productInventory.getProductCost(product);
            if (coinRegister.hasSufficientFunds(productCost)) {
                coinReturn.addAll(coinRegister.makeChange(productCost));
                display.setThankYou(true);
                display.setRequestedAmount(0);
                return;
            }
            display.setInsufficientFunds(true);
            display.setRequestedAmount(productCost);
            return;
        }

        display.setSoldOut(true);
    }

    public void returnCoins() {
        coinReturn.addAll(coinRegister.returnCoins());
        display.setRequestedAmount(0);
    }

    public void addProduct(String product) {
        productInventory.addProduct(product);
    }
}
