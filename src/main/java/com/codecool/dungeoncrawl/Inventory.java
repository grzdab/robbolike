package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory {
    private final ObservableList<InventoryItem> inventory = FXCollections.observableArrayList();

    private final Map<String, Integer> nameIds = new HashMap<>();
    private int nextId = 0;

    public boolean hasItem(String name)
    {
        for (InventoryItem item: inventory) {
            if (Objects.equals(item.getInventoryName(), name))
                return true;
        }
        return false;
    }

    public void addItem(Item item)
    {
        if (nameIds.containsKey(item.getTileName()))
        {
            System.out.println("Added " + item.getTileName());
            InventoryItem object = inventory.get(nameIds.get(item.getTileName()));
            object.addOne();
            System.out.println(object.getInventoryCount());
            inventory.set(nameIds.get(item.getTileName()), object);
        }
        else
        {
            System.out.println("Added " + item.getTileName());
            nameIds.put(item.getTileName(), nextId);
            nextId++;
            InventoryItem newItem = new InventoryItem(item.getTileName(), 0); // item.getPts()
            newItem.addOne();
            inventory.add(newItem);
        }
    }

    private void moveNameIdsUp(int removedId)
    {
        //int i = removedId;
        for (Map.Entry<String, Integer> entry : nameIds.entrySet()) {
            if (entry.getValue() == removedId) {
                nameIds.remove(entry.getKey());
                break;
            }
        }
        for (int i = removedId; i < nameIds.size() - 1; ++i) {
            int movedId = i + 1;
            // String replacedName = null;
            String replacingName = null;
            for (Map.Entry<String, Integer> entry : nameIds.entrySet()) {
                if (entry.getValue() == movedId) {
                    replacingName = entry.getKey();
                    nameIds.put(replacingName, i);
                    break;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : nameIds.entrySet()) {
            if (entry.getValue() == nameIds.size() - 1) {
                nameIds.remove(entry.getKey());
                break;
            }
        }
        System.out.println(nameIds);

    }

    public void removeItem(Item item) {
        if (nameIds.containsKey(item.getTileName()))
        {
            System.out.println("Removed " + item.getTileName());
            InventoryItem object = inventory.get(nameIds.get(item.getTileName()));
            object.removeOne();
            System.out.println(object.getInventoryCount());
            if (object.getInventoryCount() == 0)
            {
                inventory.remove(object);
                moveNameIdsUp(nameIds.get(item.getTileName()));
                nextId--;
            }
            else {
                // inventory.remove(object);
                inventory.set(nameIds.get(item.getTileName()), object);
            }
        }
    }

    public ObservableList<InventoryItem> getInventory() {
        return inventory;
    }
}
