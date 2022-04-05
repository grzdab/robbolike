package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Bow extends Item {
    public Bow(Cell cell, ItemType itemType) {
        super(cell, itemType);
        int dmg = 3;
        boolean isWeapon = true;
    }

    @Override
    public String getTileName() {
        return "bow";
    }
}
