package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bear extends Actor {
    public Bear(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "bear";
    }
}
