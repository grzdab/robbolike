package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Taser extends Item {
    public Taser(Cell cell) {
        super(cell, ItemType.TASER);
        int dmg = 3;
    }

    @Override
    public String getTileName() {
        return "taser";
    }
}
