package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Player;

public class GameMap {
    private static int width;
    private static int height;
    private static Cell[][] cells;

    private static Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public static Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public static Cell[][] getMap() {return cells;}

    public static void setPlayer(Player player) {
        GameMap.player = player;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void removePlayer() {
        player = null;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }




}
