package com.codecool.dungeoncrawl;

public class InventoryItem {
    public Integer inventoryCount = 0;
    public String inventoryName;
    public Integer inventoryPts;

    public InventoryItem(String inventoryName, int inventoryPts) {
        this.inventoryName = inventoryName;
        this.inventoryPts = inventoryPts;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getInventoryPts() {
        return inventoryPts;
    }

    public void setInventoryPts(int inventoryPts) {
        this.inventoryPts = inventoryPts;
    }

    public void addOne() {
        this.inventoryCount++;
    }
}

