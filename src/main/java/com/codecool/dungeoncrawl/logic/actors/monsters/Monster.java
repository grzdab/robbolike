package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.ActorType;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;
    protected int direction;

    public Monster(Cell cell, int health, int attack, int defence, int direction, ActorType actorType) {
        super(cell, health, attack, defence, actorType);
        this.direction = direction;
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
    public void move(int dx, int dy)  {
        super.move(dx, dy);
    }


}
