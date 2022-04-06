package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Coin extends Item {
    public Coin(Cell cell) {
        super(cell, ItemType.COIN);
        int dmg = 0;
    }

    @Override
    public String getTileName() {
        return "coin";
    }
}

