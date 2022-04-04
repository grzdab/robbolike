package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

public class Boss extends Monster{
    static final int EXP = 25;
    static final int DIRECTION = 0;
    public Boss(Cell cell, int health, int attack, int defence) {
        super(cell, health, attack, defence, DIRECTION, EXP);
    }

    @Override
    public String getTileName() {
        return "boss";
    }

    @Override
    public void moveMonster() {
        if (isReadyToFight()) {
            fight(this, GameMap.getPlayer());
        }
    }
}

