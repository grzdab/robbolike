package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;

import java.util.ArrayList;
import java.util.List;


public class DropItem {
    public List<String> listOfDrop = new ArrayList<>();

    int x;
    int y;
    public DropItem(Actor actor, GameMap gameMap) {
        x = actor.getX();
        y = actor.getY();
        Cell cell = gameMap.getCell(x, y);
    }



}
