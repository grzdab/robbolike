package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.monsters.Boss;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.items.Wrench;
import com.codecool.dungeoncrawl.logic.items.Taser;
import com.codecool.dungeoncrawl.logic.items.Shield;
import com.codecool.dungeoncrawl.logic.items.Screwdriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DropItem {
    private static List<String> dropItemList = Arrays.asList("screwdriver", "shield", "resistor", "taser", "coin");

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
        System.out.println(actor.getClass().getSimpleName());
        Class<? extends Actor> monsterEachDrop = actor.getClass();
        Cell cell = GameMap.getCell(x, y);
        String itemToDrop = getElementToDrop(monsterEachDrop);
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

    public static String getElementToDrop(Class<? extends Actor> monsterEachDrop) {
//        List<String> a = monsterEachDrop.getMonsterDrop();
//        int index = (int)(Math.random() * a.size());
        int index = (int)(Math.random() * dropItemList.size());
        String itemToDrop = dropItemList.get(index);
        return itemToDrop;
    }
}
