package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

import java.util.concurrent.ThreadLocalRandom;

public class Skeleton extends Monster {
    static final int MIN_EXP = 0;
    static final int MAX_EXP = 6;
    static final int DIRECTION = 0;

    public Skeleton(Cell cell, int health, int attack, int defence) {
        super(cell, health, attack, defence, DIRECTION, ThreadLocalRandom.current().nextInt(MIN_EXP, MAX_EXP));
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public void moveMonster() {
        if (isReadyToFight()) {
            fight(this, GameMap.getPlayer());
        }
    }
}
