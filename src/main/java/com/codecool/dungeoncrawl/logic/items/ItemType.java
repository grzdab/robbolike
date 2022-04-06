package com.codecool.dungeoncrawl.logic.items;

public enum ItemType {
    SCREWDRIVER(1),
    WRENCH(2),
    SPRING(1),
    TASER(2),
    SHIELD(0),
    HELMET(0),
    BREASTPLATE(0),
    COIN(0),
    KEY(0),
    PROJECTILE(0),
    NUT(0),
    RESISTOR(0);

    private final int numberOfSlots;

    ItemType(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }
}
