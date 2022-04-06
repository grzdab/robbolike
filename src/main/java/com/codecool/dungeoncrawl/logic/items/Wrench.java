package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Wrench extends Item {
    public Wrench(Cell cell) {
        super(cell, ItemType.WRENCH);
        int dmg = 11;
    }

    @Override
    public String getTileName() {
        return "wrench";
    }
}
