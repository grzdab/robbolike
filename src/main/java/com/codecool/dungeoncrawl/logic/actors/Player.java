package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

public class Player extends Actor {

    public Player(Cell cell) {
        super(cell);
//        super(cell, monsters);
    }

    public String getTileName() {
        return "player";
    }
}
