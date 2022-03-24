package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.util.List;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;
    protected int direction;

    public Monster(Cell cell, int health, int attack, int defence, int direction) {
        super(cell, health, attack, defence);
        this.direction = direction;
    }


    public void moveMonster() {
    }

    public boolean isCollisionLeft() {
        Cell nextCell = cell.getNeighbor(- 1, 0);
        return nextCell.getType() != CellType.FLOOR || nextCell.getObstacle() != null || nextCell.getActor() != null;
    }

    public boolean isCollisionRight() {
        Cell nextCell = cell.getNeighbor(1, 0);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null;
    }
    public boolean isCollisionUp() {
        Cell nextCell = cell.getNeighbor(0, 1);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null;
    }
    public boolean isCollisionDown() {
        Cell nextCell = cell.getNeighbor(0, -1);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}
