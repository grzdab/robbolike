package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import com.codecool.dungeoncrawl.logic.actors.monsters.*;
import com.codecool.dungeoncrawl.logic.items.Wrench;
import com.codecool.dungeoncrawl.logic.items.Taser;
import com.codecool.dungeoncrawl.logic.items.Shield;
import com.codecool.dungeoncrawl.logic.items.Screwdriver;

import com.codecool.dungeoncrawl.logic.items.*;

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
        String itemToDrop = getElementToDrop(actor);
        putDroppedElement(cell, itemToDrop);
    }

    private static void putDroppedElement(Cell cell, String itemToDrop) {
        if (Objects.equals(itemToDrop, "screwdriver")) {
            new Screwdriver(cell);
        } else if (Objects.equals(itemToDrop, "shield")) {
            new Shield(cell);
        } else if (Objects.equals(itemToDrop, "taser")) {
            new Taser(cell);
        } else if (Objects.equals(itemToDrop, "breastplate")) {
            new Breastplate(cell);
        } else if (Objects.equals(itemToDrop, "helmet")) {
            new Helmet(cell);
        } else if (Objects.equals(itemToDrop, "nut")) {
            new Nut(cell);
        } else {
            new Wrench(cell);
        }
    }

    public static String getElementToDrop(Actor actor) {
//        List<String> a = monsterEachDrop.getMonsterDrop();

        if (actor instanceof Boss) {
            List<String> monsterDrop = Boss.getMonsterDrop();
            return getElementByIndex(monsterDrop);
        } else if (actor instanceof Bear) {
            List<String> monsterDrop = Bear.getMonsterDrop();
            return getElementByIndex(monsterDrop);
        } else if (actor instanceof Skeleton) {
            List<String> monsterDrop = Skeleton.getMonsterDrop();
            return getElementByIndex(monsterDrop);
        } else if (actor instanceof Spider) {
            List<String> monsterDrop = Spider.getMonsterDrop();
            return getElementByIndex(monsterDrop);
        }

        return null;
    }

    public static int getRandomIndex(List<String> monsterDrop) {
        int index = (int)(Math.random() * monsterDrop.size());
        return index;
    }

    public static String getElementByIndex(List<String> monsterDrop) {
        int index = getRandomIndex(monsterDrop);
        return monsterDrop.get(index);
    }
}
