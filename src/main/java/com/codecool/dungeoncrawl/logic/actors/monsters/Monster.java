package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;
    protected int direction;
    protected int exp;

    public int getExp() {
        return exp;
    }

    public Monster(Cell cell, int health, int attack, int defence, int direction, int exp) {
        super(cell, health, attack, defence);
        this.direction = direction;
        this.exp = exp;
    }
    public void moveMonster() {
    }
    public boolean isCollisionLeft() {
        Cell nextCell = cell.getNeighbor(- 1, 0);
        return nextCell.getType() != CellType.FLOOR || nextCell.getObstacle() != null || nextCell.getActor() != null
                || nextCell.getItem() != null;
    }
    public boolean isCollisionRight() {
        Cell nextCell = cell.getNeighbor(1, 0);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null
                || nextCell.getItem() != null;
    }
    public boolean isCollisionUp() {
        Cell nextCell = cell.getNeighbor(0, 1);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null
                || nextCell.getItem() != null;
    }
    public boolean isCollisionDown() {
        Cell nextCell = cell.getNeighbor(0, -1);
        return nextCell.getType() != CellType.FLOOR  || nextCell.getObstacle() != null || nextCell.getActor() != null
                || nextCell.getItem() != null;
    }
    public boolean isReadyToFight() {
        return isReadyToFightLeft() || isReadyToFightRight() || isReadyToFightUp() || isReadyToFightDown();
    }
    public boolean isReadyToFightLeft() {
        Cell nextCell = cell.getNeighbor(- 1, 0);
        return nextCell.getActor() == GameMap.getPlayer();}
    public boolean isReadyToFightRight() {
        Cell nextCell = cell.getNeighbor(1, 0);
        return  nextCell.getActor() == GameMap.getPlayer();}
    public boolean isReadyToFightUp() {
        Cell nextCell = cell.getNeighbor(0, 1);
        return  nextCell.getActor() == GameMap.getPlayer();}
    public boolean isReadyToFightDown() {
        Cell nextCell = cell.getNeighbor(0, -1);
        return  nextCell.getActor() == GameMap.getPlayer();}

    @Override
    public void move(int dx, int dy, GraphicsContext context) {
        super.move(dx, dy, context);
    }


}
