package com.jameskbride;

public class Product {
    private Double cost;
    private String name;
    private int quantity;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) {
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("Cannot decrement quantity below zero");
        }
        this.quantity -= quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
