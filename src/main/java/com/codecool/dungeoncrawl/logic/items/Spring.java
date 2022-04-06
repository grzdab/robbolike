package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Spring extends Item{
    public Spring(Cell cell) {
        super(cell, ItemType.SHIELD);
        int dmg = 3;
    }

    @Override
    public String getTileName() {
        return "spring";
    }
}
