package com.jameskbride;

public class Display {
    private double requestedAmount;
    private boolean insufficientFunds;

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
            return formatForInsufficientFunds(formatAmount(this.requestedAmount));
        }

        return emptyMessage();
    }

    private String formatForInsufficientFunds(String formatAmount) {
        if (insufficientFunds) {
            return "PRICE" + " " + formatAmount;
        }

        return formatAmount;
    }

    public void setInsufficientFunds(boolean insufficientFunds) {
        this.insufficientFunds = true;
    }
}
