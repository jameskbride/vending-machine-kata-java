package com.jameskbride;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

    public static final String CHIPS = "CHIPS";
    private Map<String,Product> productMap;
    private boolean inStock;

    public ProductInventory() {
        initializeProductMap();
    }

    private void initializeProductMap() {
        productMap = new HashMap<>();
        productMap.put("CHIPS", new Product("CHIPS", 0.50));
        productMap.put("COLA", new Product("COLA", 1.00));
        productMap.put("CANDY", new Product("CANDY", 0.65));
    }

    public Double getProductCost(String product) {
        return productMap.get(product).getCost();
    }

    public void addProduct(String product) {
        this.productMap.get(product).increaseQuantity(1);
    }

    public boolean isInStock(String product) {
        return this.productMap.get(product).getQuantity() > 0;
    }

    public void release(String chips) {
        this.productMap.get(chips).decreaseQuantity(1);
    }
}
