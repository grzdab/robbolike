package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.controllers.GameController;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.ActorType;
import com.codecool.dungeoncrawl.logic.actors.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Monster {

    public Bear(Cell cell, int health, int attack, int defence, int direction, ActorType actorType) {
        super(cell, health, attack, defence, direction, actorType);
    }

    @Override
    public void moveMonster() {
        List<Integer> possibleDirections = new ArrayList<>();
        if (isReadyToFight()) {
            fight(this, GameMap.getPlayer());
        }
        boolean collision = false;
        if (!isCollisionLeft()) {
            possibleDirections.add(0);
        } else {
            collision = true;
        }
        if (!isCollisionRight()) {
            possibleDirections.add(1);
        } else {
        collision = true;
    }
        if (!isCollisionUp()) {
            possibleDirections.add(3);
        } else {
            collision = true;
        }
        if (!isCollisionDown()) {
            possibleDirections.add(2);
        } else {
            collision = true;
        }

        if (collision) {
            int index = ThreadLocalRandom.current().nextInt(0, possibleDirections.size());
            direction = possibleDirections.get(index);
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
