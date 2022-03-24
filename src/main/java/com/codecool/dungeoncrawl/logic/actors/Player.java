package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.Inventory;
import com.codecool.dungeoncrawl.logic.Cell;

public class Player extends Actor {
    Inventory inventory;
    public Player(Cell cell) {
        super(cell);
//        super(cell, monsters);
    }

    public String getTileName() {
        return "player";
    }
}
