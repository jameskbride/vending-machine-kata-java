package com.jameskbride;

public class VendingMachine {
    private double total;

    public String display() {

        if (total > 0) {
            return String.format("$%.2f", total);
        }

        return "INSERT COIN";
    }

    public void insertCoin(String coin) {
        this.total = 0.05;
    }
}
