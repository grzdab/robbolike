package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final ObservableList<InventoryItem> inventory = FXCollections.observableArrayList();

    private final Map<String, Integer> nameIds = new HashMap<>();
    private int nextId = 0;

    public void addItem(Item item)
    {
        if (nameIds.containsKey(item.getTileName()))
        {
            InventoryItem object = inventory.get(nameIds.get(item.getTileName()));
            object.addOne();
        }
        else
        {
            nameIds.put(item.getTileName(), nextId);
            nextId++;
            InventoryItem newItem = new InventoryItem(item.getTileName(), 0); // item.getPts()
            newItem.addOne();
            inventory.add(newItem);
        }
    }

    public ObservableList<InventoryItem> getInventory() {
        return inventory;
    }
}
