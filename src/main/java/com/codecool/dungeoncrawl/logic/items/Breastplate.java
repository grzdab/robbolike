package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Breastplate extends Item {
    public Breastplate(Cell cell, ItemType itemType) {
        super(cell, itemType);
        int defence = 4;
        boolean isWeapon = false;
    }

    @Override
    public String getTileName() {
        return "breastplate";
    }
}
