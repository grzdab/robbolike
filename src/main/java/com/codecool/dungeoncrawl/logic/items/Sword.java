package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sword extends Item {
    public Sword(Cell cell) {
        super(cell, ItemType.SMALL_SHORT_RANGE_WEAPON);
        int dmg = 5;
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}

