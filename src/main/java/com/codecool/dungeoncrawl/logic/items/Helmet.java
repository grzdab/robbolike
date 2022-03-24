package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Helmet extends Item {
    public Helmet(Cell cell) {
        super(cell);
        int defence = 2;
        boolean isWeapon = false;
    }

    @Override
    public String getTileName() {
        return "helmet";
    }
}
