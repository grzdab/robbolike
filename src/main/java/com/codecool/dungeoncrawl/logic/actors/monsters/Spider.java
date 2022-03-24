package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.lang.management.PlatformLoggingMXBean;
import java.util.concurrent.ThreadLocalRandom;

public class Spider extends Monster {

    public Spider(Cell cell, int health, int attack, int defence, int direction) {
        super(cell, health, attack, defence, direction);
    }

    public void moveMonster() {
        if (isReadyToFight()) {
            fight(this, GameMap.getPlayer());
        }
        if (isCollisionLeft()) {
            direction = 1;
        }
        if (isCollisionRight()) {
            direction = 0;
        }
            switch (direction) {
                case 0:
                    Cell nextCell = cell.getNeighbor(- 1, 0);
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                    break;
                case 1:
                    nextCell = cell.getNeighbor(1, 0);
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                    break;
            }
    }

    public static int monsterDirection(){
        return ThreadLocalRandom.current().nextInt(0, 2);
    }

    @Override
    public String getTileName() {
        return "spider";
    }
}

