package com.jameskbride;

public class Display {
    public String emptyMessage() {
        return "INSERT COIN";
    }

    public String formatAmount(double amount) {
        return String.format("$%.2f", amount);
    }
}
