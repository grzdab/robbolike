package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.items.Axe;
import com.codecool.dungeoncrawl.logic.items.Bow;
import com.codecool.dungeoncrawl.logic.items.Shield;
import com.codecool.dungeoncrawl.logic.items.Sword;

import java.util.ArrayList;
import java.util.List;

public class DropItem {
    private List<String> dropItemList = new ArrayList<>();
    public void addItemsToListDrop() {
        dropItemList.add("sword");
        dropItemList.add("shield");
        dropItemList.add("bow");
        dropItemList.add("axe");
    }
    int x;
    int y;
    public void dropItem(Actor actor, GameMap gameMap) {
        if (dropItemList.isEmpty()) {
            addItemsToListDrop();
        }
        x = actor.getX();
        y = actor.getY();
        Cell cell = gameMap.getCell(x, y);
        String itemToDrop = getElementToDrop();
        putDroppedElement(cell, itemToDrop);
    }

    private void putDroppedElement(Cell cell, String itemToDrop) {
        if (itemToDrop == "sword") {
            new Sword(cell);
        } else if (itemToDrop == "shield") {
            new Shield(cell);
        } else if (itemToDrop == "bow") {
            new Bow(cell);
        } else {
            new Axe(cell);
        }
    }

    public String getElementToDrop() {
        int index = (int)(Math.random() * dropItemList.size());
        String itemToDrop = dropItemList.get(index);
        return itemToDrop;
    }
}
