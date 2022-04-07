package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Spider extends Monster {
    public final List<String> monsterDrop = Arrays.asList();
    static final int MIN_EXP = 5;
    static final int MAX_EXP = 11;
    static final int LEFT_BOUND_DIRECTION = 0;
    static final int RIGHT_BOUND_DIRECTION = 2;

    public Spider(Cell cell, int health, int attack, int defence) {
        super(cell, health, attack, defence, ThreadLocalRandom.current().
                        nextInt(LEFT_BOUND_DIRECTION, RIGHT_BOUND_DIRECTION),
                ThreadLocalRandom.current().nextInt(MIN_EXP, MAX_EXP));
    }

    public void moveMonster() {
        if (health > 0) {
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
                    Cell nextCell = cell.getNeighbor(-1, 0);
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
        else {
                System.out.println("Dead monster!");
                System.out.println("DOESN'T MOVE");
                System.out.println(getCell().getType());
                this.removeActorFromMap();
        }
    }

    @Override
    public String getTileName() {
        return "spider";
    }

    public List<String> getMonsterDrop() {
        return monsterDrop;
    }
}

