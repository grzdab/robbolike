package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.ActorType;

public class Boss extends Monster{
    public Boss(Cell cell, int health, int attack, int defence, int direction, ActorType actorType) {
        super(cell, health, attack, defence, direction, actorType);
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

