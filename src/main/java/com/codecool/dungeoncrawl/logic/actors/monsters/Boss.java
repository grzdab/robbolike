package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boss extends Monster{
    private static final List<String> monsterDrop = Arrays.asList("screwdriver");
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

    public static List<String> getMonsterDrop() {
        return monsterDrop;
    }
}

