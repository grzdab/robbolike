package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.items.Wrench;
import com.codecool.dungeoncrawl.logic.items.Taser;
import com.codecool.dungeoncrawl.logic.items.Shield;
import com.codecool.dungeoncrawl.logic.items.Screwdriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DropItem {
    private static List<String> dropItemList = Arrays.asList("screwdriver", "shield", "resistor", "taser", "coin");
    int x;
    int y;

//    public void addItemsToListDrop() {
//        dropItemList.add("sword");
//        dropItemList.add("shield");
//        dropItemList.add("bow");
//        dropItemList.add("axe");
//    }
    public static void dropItem(Actor actor) {
//        if (dropItemList.isEmpty()) {
//            addItemsToListDrop();
//        }
        int x = actor.getX();
        int y = actor.getY();
        Cell cell = GameMap.getCell(x, y);
        String itemToDrop = getElementToDrop();
        putDroppedElement(cell, itemToDrop);
    }

    private static void putDroppedElement(Cell cell, String itemToDrop) {
        if (Objects.equals(itemToDrop, "screwdriver")) {
            new Screwdriver(cell);
        } else if (Objects.equals(itemToDrop, "shield")) {
            new Shield(cell);
        } else if (Objects.equals(itemToDrop, "taser")) {
            new Taser(cell);
        } else {
            new Wrench(cell);
        }
    }

    public static String getElementToDrop() {
        int index = (int)(Math.random() * dropItemList.size());
        String itemToDrop = dropItemList.get(index);
        return itemToDrop;
    }
}
