package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Axe extends Item {
    public Axe(Cell cell, ItemType itemType) {
        super(cell, itemType);
        int dmg = 11;
        boolean isWeapon = true;
    }

    @Override
    public String getTileName() {
        return "axe";
    }
}
