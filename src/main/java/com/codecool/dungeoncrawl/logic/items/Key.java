package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Key extends Item {
    public Key(Cell cell, ItemType itemType) {
        super(cell, itemType);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
