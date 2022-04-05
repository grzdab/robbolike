package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Coin extends Item {
    public Coin(Cell cell, ItemType itemType) {
        super(cell, itemType);
        int dmg = 0;
        boolean isWeapon = false;
    }

    @Override
    public String getTileName() {
        return "coin";
    }
}

