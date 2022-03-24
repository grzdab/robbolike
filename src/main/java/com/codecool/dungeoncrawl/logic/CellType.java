package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    ROCK("rock"),
    MONSTER_SPIDER("spider"),
    MONSTER_BEAR("bear"),
    MONSTER_SKELETON("skeleton"),
    MONSTER_BOSS("boss"),
    GATE("gate"),
    PLAYER("player");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
