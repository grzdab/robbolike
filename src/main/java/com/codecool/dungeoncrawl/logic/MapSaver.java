package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MapSaver {
    public static void saver() {
        PrintWriter save = null;

        try {
            System.out.println(System.getProperty("user.dir") + "/src/main/resources/save.txt");
            save = new PrintWriter(System.getProperty("user.dir") + "/src/main/resources/save.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No kurna nie udało się");
        }
        assert save != null;
        String mapString = mapString();
        GameDatabaseManager.saveMap(mapString);
        save.println(mapString);
        save.close();
    }

    public static String mapString() {
        int width = GameMap.getWidth();
        int height = GameMap.getHeight();
        Cell[][] cells = GameMap.getMap();

        StringBuilder mapString = new StringBuilder();
        mapString.append("\n");
        mapString.append(width);
        mapString.append(" ");
        mapString.append(height);
        mapString.append("\n");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean omit = false;
                Cell cell = cells[x][y];
                if (cell.getType() == CellType.FLOOR && cell.getActor() != null) {
                    omit = true;
                    switch (cell.getActor().getActorType()) {
                        case SKELETON:
                            mapString.append("S");
                            break;
                        case BEAR:
                            mapString.append("M");
                            break;
                        case SPIDER:
                            mapString.append("P");
                            break;
                        case PLAYER:
                            mapString.append("@");
                            break;
                        case BOSS:
                            mapString.append("B");
                            break;
                    }
                }
                if(cell.getType() == CellType.FLOOR && cell.getItem() != null) {
                    omit = true;
                    switch (cell.getItem().getItemType()) {
                        case SWORD:
                            mapString.append("s");
                            break;
                        case AXE:
                            mapString.append("a");
                            break;
                        case BOW:
                            mapString.append("b");
                            break;
                        case BREASTPLATE:
                            mapString.append("e");
                            break;
                        case HELMET:
                            mapString.append("h");
                            break;
                        case SHIELD:
                            mapString.append("i");
                            break;
                        case KEY:
                            mapString.append("k");
                            break;
                        case COIN:
                            mapString.append("*");
                    }
                }
                if(cell.getType() == CellType.FLOOR && cell.getObstacle() != null) {
                    omit = true;
                    switch (cell.getObstacle().getObstaclesType()){
                        case DOOR:
                            mapString.append("d");
                            break;
                        case TELEPORT:
                            mapString.append("t");
                            break;
                        case CRATE:
                            mapString.append("c");
                            break;
                    }
                }

                if (!omit) {
                    switch (cell.getType()) {
                        case EMPTY:
                            mapString.append(" ");
                            break;
                        case WALL:
                            mapString.append("#");
                            break;
                        case ROCK:
                            mapString.append("r");
                            break;
                        case FLOOR:
                            mapString.append(".");
                            break;
                        case GRASS:
                            mapString.append("_");
                            break;
                        case GATE:
                            mapString.append("g");
                            break;
                    }
                }
            }
            mapString.append("\n");
        }
        System.out.println(mapString);
        return mapString.toString();
    }
}
