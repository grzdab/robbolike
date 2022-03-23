package com.codecool.dungeoncrawl.logic.inventory;

import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<Item> itemsInInventory = new ArrayList<>();

    public static void setItemsInInventory(List<Item> itemsInInventory) {
        Inventory.itemsInInventory = itemsInInventory;
    }
}
