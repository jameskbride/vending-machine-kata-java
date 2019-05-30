package com.jameskbride;

public class Display {
    private double requestedAmount;

    public String emptyMessage() {
        return "INSERT COIN";
    }

    public String formatAmount(double amount) {
        return String.format("$%.2f", amount);
    }

    public void setRequestedAmount(double amount) {
        this.requestedAmount = amount;
    }

    public String displayFormattedAmount() {
        if (requestedAmount > 0) {
            return formatAmount(this.requestedAmount);
        }

        return emptyMessage();
    }
}
