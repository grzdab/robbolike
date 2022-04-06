package com.codecool.dungeoncrawl.logic.items;

public enum ItemType {
    SCREWDRIVER(1),
    WRENCH(2),
    SPRING(1),
    TASER(2),
    SHIELD(0),
    HELMET(0),
    BREASTPLATE(0),
    PANTS(0),
    SHOES(0),
    GLOVES(0),
    KEY(0);

    private final int numberOfSlots;

    ItemType(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }
}
