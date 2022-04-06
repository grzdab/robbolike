package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Resistor extends Item {

    public Resistor(Cell cell) {
        super(cell, ItemType.RESISTOR);
        int dmg = 3;
    }
    @Override
    public String getTileName() {
        return "resistor";
    }
}
