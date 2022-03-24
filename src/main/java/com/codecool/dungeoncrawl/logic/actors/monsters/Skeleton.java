package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class Skeleton extends Monster {
    Player player;
    public Skeleton(Cell cell,int health, int attack, int defence, int direction) {
        super(cell, health, attack, defence, direction);
    }

    @Override
    public void moveMonster() {
        super.moveMonster();
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}
