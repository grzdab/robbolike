package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Breastplate extends Item {

    public Breastplate(Cell cell) {
        super(cell, ItemType.BREASTPLATE);
        int defence = 4;
    }

    @Override
    public String getTileName() {
        return "breastplate";
    }
}
