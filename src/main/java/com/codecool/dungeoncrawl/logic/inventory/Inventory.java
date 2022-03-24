package com.codecool.dungeoncrawl.logic.inventory;

public class Inventory {
    private Integer itemId;
    private Integer numberOfItems;
    private String itemName;
    private String typeOfItem;
    private Integer inventoryCount;

    public Inventory(Integer itemId, Integer numberOfItems, String itemName, String typeOfItem, Integer inventorCount) {
        this.numberOfItems = numberOfItems;
        this.itemName = itemName;
        this.typeOfItem = typeOfItem;
        this.inventoryCount = inventorCount;
        this.itemId = itemId;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
