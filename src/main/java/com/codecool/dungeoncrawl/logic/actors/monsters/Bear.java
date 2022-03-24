package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.controllers.GameController;
import com.codecool.dungeoncrawl.logic.Cell;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Monster {
    GameController gameController;

    public Bear(Cell cell, int health, int attack, int defence,int direction) {
        super(cell, health, attack, defence, direction);
    }

    @Override
    public void moveMonster() {
        List<Integer> possibleDirections = new ArrayList<>();
        boolean colistion = false;

        if (!isCollisionLeft()) {
            possibleDirections.add(0);
            System.out.println("colisionLeft");
        } else {
            colistion = true;
        }
        if (!isCollisionRight()) {
            possibleDirections.add(1);
            System.out.println("colisionR");
        } else {
        colistion = true;
    }
        if (!isCollisionUp()) {
            possibleDirections.add(3);
            System.out.println("colisionUp");
        } else {
            colistion = true;
        }
        if (!isCollisionDown()) {
            possibleDirections.add(2);
            System.out.println("colisionDown");
        } else {
            colistion = true;
        }

        if (colistion) {
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
