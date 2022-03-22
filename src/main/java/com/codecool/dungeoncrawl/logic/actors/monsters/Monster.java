package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import java.util.List;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;
    Cell cell;

    public Monster(Cell cell) {
        super(cell, monsters);
    }


    public void move() {
    }

    private boolean isCollisionLeft() {
        Cell nextCell = cell.getNeighbor(cell.getX() - 1, cell.getY());
        return nextCell.getType() == CellType.WALL;
    }

    private boolean isCollisionRight() {
        Cell nextCell = cell.getNeighbor(cell.getX() + 1, cell.getY());
        return nextCell.getType() == CellType.WALL;
    }
}
