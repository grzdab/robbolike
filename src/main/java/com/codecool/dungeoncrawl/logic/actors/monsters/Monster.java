package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import java.util.List;

public abstract class Monster extends Actor {
    private static final List<Monster> monsters = null;

    public Monster(Cell cell) {
        super(cell, monsters);
    }


    public void move() {
    }
}
