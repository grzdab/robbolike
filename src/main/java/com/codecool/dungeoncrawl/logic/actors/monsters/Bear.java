package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;


import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Monster {

    public Bear(Cell cell, int health, int attack, int defence,int direction) {
        super(cell, health, attack, defence, direction);
    }

    @Override
    public void moveMonster() {
        int randomIndex = new Random().nextInt(3);
        List<Integer> collisionRight = List.of(0,2,3);
        List<Integer> collisionLeft = List.of(1,2,3);
        List<Integer> collisionUp = List.of(0,1,2);
        List<Integer> collisionDown = List.of(0,1,3);

        if (isCollisionLeft()) {
                direction = collisionLeft.get(randomIndex);
//                if (isCollisionUp()) {
//                    direction = collisionUp.get(randomIndex);
//                } else if (isCollisionDown()) {
//                    direction = collisionDown.get(randomIndex);
//                }
            System.out.println("colisionLeft");
        }
        if (isCollisionRight()) {
                direction = collisionRight.get(randomIndex);
//            if (isCollisionUp()) {
//                direction = collisionUp.get(randomIndex);
//            } else if (isCollisionDown()) {
//                direction = collisionDown.get(randomIndex);
//            }
            System.out.println("colisionR");
        }
        if (isCollisionUp()) {
                direction = collisionUp.get(randomIndex);
//            if (isCollisionUp()) {
//                direction = collisionUp.get(randomIndex);
//            } else if (isCollisionDown()) {
//                direction = collisionDown.get(randomIndex);
//            }
            System.out.println("colisionUp");
        }
        if (isCollisionDown()) {
                direction = collisionDown.get(randomIndex);
            System.out.println("colisionDown");
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
