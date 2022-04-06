package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Screwdriver extends Item {
    public Screwdriver(Cell cell) {
        super(cell, ItemType.SCREWDRIVER);
        int dmg = 5;
    }

    @Override
    public String getTileName() {
        return "screwdriver";
    }
}

