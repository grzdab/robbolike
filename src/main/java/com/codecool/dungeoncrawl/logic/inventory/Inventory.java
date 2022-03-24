package com.codecool.dungeoncrawl.logic.inventory;

public class Inventory {
    private Integer itemId;
    private Integer numberOfItems;
    private String itemName;
    private String typeOfItem;
    private Integer value;

    public Inventory(Integer itemId, Integer numberOfItems, String itemName, String typeOfItem, Integer value) {
        this.numberOfItems = numberOfItems;
        this.itemName = itemName;
        this.typeOfItem = typeOfItem;
        this.value = value;
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

    public Integer getValue() {
        return value;
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

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
