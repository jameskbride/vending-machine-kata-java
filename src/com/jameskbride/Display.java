package com.jameskbride;

public class Display {
    private double requestedAmount;
    private boolean insufficientFunds;
    private boolean thankYou;

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
        String message = "";

        if (requestedAmount > 0) {
            message = formatForInsufficientFunds(formatAmount(this.requestedAmount));
        } else {
            message = emptyMessage();
        }

        return formatForThankYou(message);
    }

    private String formatForThankYou(String formatAmount) {
        if(thankYou) {
            this.thankYou = false;
            return "THANK YOU";
        }

        return formatAmount;
    }

    private String formatForInsufficientFunds(String formatAmount) {
        if (insufficientFunds) {
            return "PRICE" + " " + formatAmount;
        }

        return formatAmount;
    }

    public void setInsufficientFunds(boolean insufficientFunds) {
        this.insufficientFunds = insufficientFunds;
    }

    public void setThankYou(boolean thankYou) {
        this.thankYou = thankYou;
    }
}
