package com.jameskbride;

public class CoinRegister {

    private double total;

    public CoinRegister() {
        total = 0;
    }

    public double getTotal() {
        return total;
    }

    public void addValue(double value) {
        this.total = total + value;
    }
}
