package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Boss extends Monster{
    public Boss(Cell cell, int health, int attack, int defence, int direction) {
        super(cell, health, attack, defence, direction);
    }

    @Override
    public String getTileName() {
        return "boss";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }
}

