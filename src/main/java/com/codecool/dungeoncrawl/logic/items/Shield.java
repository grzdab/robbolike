package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Shield extends Item {
    public Shield(Cell cell) {
        super(cell);
        int defence = 3;
        boolean isWeapon = false;
    }

    @Override
    public String getTileName() {
        return "shield";
    }
}
