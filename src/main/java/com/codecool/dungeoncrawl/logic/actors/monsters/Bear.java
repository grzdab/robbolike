package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;


import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Monster {

    public Bear(Cell cell, int health, int attack, int defence) {
        super(cell, health, attack, defence);
    }

    public void moveMonster(int direction) {
        if (isCollisionLeft()) {
            direction = 1;
        }
        if (isCollisionRight()) {
            direction = 0;
        }
        if (isCollisionUp()) {
            direction = 2;
        }
        if (isCollisionDown()) {
            direction = 3;
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
            case 2:
                nextCell = cell.getNeighbor(0, -1);
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
                break;
            case 3:
                nextCell = cell.getNeighbor(0, 1);
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
                break;
        }
    }

    public static int monsterDirection(){
        return ThreadLocalRandom.current().nextInt(0,4);
    }

    @Override
    public String getTileName() {
        return "bear";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}
