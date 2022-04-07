package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.controllers.GameController;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.ActorType;
import com.codecool.dungeoncrawl.logic.actors.Player;
import javafx.scene.canvas.GraphicsContext;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Monster {
    public static final List<String> monsterDrop = Arrays.asList("taser", "nut");
    static final int MIN_EXP = 15;
    static final int MAX_EXP = 21;
    static final int LEFT_BOUND_DIRECTION = 0;
    static final int RIGHT_BOUND_DIRECTION = 4;

    public Bear(Cell cell, int health, int attack, int defence, ActorType actorType) {
        super(cell, health, attack, defence, ThreadLocalRandom.current()
                .nextInt(LEFT_BOUND_DIRECTION, RIGHT_BOUND_DIRECTION),
                ThreadLocalRandom.current().nextInt(MIN_EXP, MAX_EXP), actorType);
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
    public void move(int dx, int dy, GraphicsContext context) {
        super.move(dx, dy, context);
    }

    public static List<String> getMonsterDrop() {
        return monsterDrop;
    }
}
