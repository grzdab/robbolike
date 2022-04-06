package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Shield extends Item {
    public Shield(Cell cell) {
        super(cell, ItemType.SHIELD);
        int defence = 3;
    }

    @Override
    public String getTileName() {
        return "shield";
    }
}
