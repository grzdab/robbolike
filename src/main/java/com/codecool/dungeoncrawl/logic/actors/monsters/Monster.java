package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import java.util.List;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;

    public Monster(Cell cell) {
        super(cell);
    }


    public void moveMonster(int direction) {
    }

    public boolean isCollisionLeft() {
        Cell nextCell = cell.getNeighbor(- 1, 0);
        return nextCell.getType() == CellType.WALL;
    }

    public boolean isCollisionRight() {
        Cell nextCell = cell.getNeighbor(1, 0);
        return nextCell.getType() == CellType.WALL;
    }
    public boolean isCollisionUp() {
        Cell nextCell = cell.getNeighbor(0, 1);
        return nextCell.getType() == CellType.WALL;
    }
    public boolean isCollisionDown() {
        Cell nextCell = cell.getNeighbor(0, -1);
        return nextCell.getType() == CellType.WALL;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}
