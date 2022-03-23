package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Skeleton extends Monster {
    public Skeleton(Cell cell,int health, int attack) {
        super(cell, health, attack);
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
