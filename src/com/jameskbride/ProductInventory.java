package com.jameskbride;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

    private Map<String,Double> productMap;

    public ProductInventory() {
        initializeProductMap();
    }

    private void initializeProductMap() {
        productMap = new HashMap<>();
        productMap.put("CHIPS", 0.50);
        productMap.put("COLA", 1.00);
        productMap.put("CANDY", 0.65);
    }

    public Double getProductCost(String product) {
        return productMap.get(product);
    }

    public void addProduct(String product) {

    }

    public boolean isInStock(String product) {
        return true;
    }
}
