package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public abstract class Monster extends Actor {
    public Monster(Cell cell) {
        super(cell);
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}
