package com.codecool.dungeoncrawl.model;

public class MapModel {
    private String currentMap;

    public MapModel(String currentMap) {
        this.currentMap = currentMap;
    }

    public String getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(String currentMap) {
        this.currentMap = currentMap;
    }
}
