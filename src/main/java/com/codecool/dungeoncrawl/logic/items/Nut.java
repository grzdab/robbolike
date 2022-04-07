package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Nut extends Item {
    public Nut(Cell cell) {
        super(cell, ItemType.NUT);
        int dmg = 3;
    }

    @Override
    public String getTileName() {
        return "nut";
    }
}
