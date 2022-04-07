package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.items.Wrench;
import com.codecool.dungeoncrawl.logic.items.Taser;
import com.codecool.dungeoncrawl.logic.items.Shield;
import com.codecool.dungeoncrawl.logic.items.Screwdriver;
import com.codecool.dungeoncrawl.logic.items.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DropItem {
    private List<String> dropItemList = Arrays.asList("sword", "shield", "bow", "axe", "coin");
    int x;
    int y;

//    public void addItemsToListDrop() {
//        dropItemList.add("sword");
//        dropItemList.add("shield");
//        dropItemList.add("bow");
//        dropItemList.add("axe");
//    }
    public void dropItem(Actor actor, GameMap gameMap) {
//        if (dropItemList.isEmpty()) {
//            addItemsToListDrop();
//        }
        x = actor.getX();
        y = actor.getY();
        Cell cell = gameMap.getCell(x, y);
        String itemToDrop = getElementToDrop();
        putDroppedElement(cell, itemToDrop);
    }

    private void putDroppedElement(Cell cell, String itemToDrop) {
        if (Objects.equals(itemToDrop, "sword")) {
            new Screwdriver(cell);
        } else if (Objects.equals(itemToDrop, "shield")) {
            new Shield(cell);
        } else if (Objects.equals(itemToDrop, "bow")) {
            new Taser(cell);
        } else {
            new Wrench(cell);
        }
    }

    public String getElementToDrop() {
        int index = (int)(Math.random() * dropItemList.size());
        String itemToDrop = dropItemList.get(index);
        return itemToDrop;
    }
}
