package com.codecool.dungeoncrawl.logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MapSaver {
    public static void saver() {
        PrintWriter save = null;

        try {
            save = new PrintWriter("save.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No kurna nie udało się");
        }
        assert save != null;
        save.println(game());
        save.close();
    }

    public static List<String> game() {
        int width = GameMap.getWidth();
        int height = GameMap.getWidth();
        Cell[][] cells = GameMap.getMap();

        List<String> map = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = cells[x][y];
                if (cell.getType() == CellType.FLOOR) {
                    switch (cell.getActor().getActorType()) {
                        case SKELETON:
                            map.add("S");
                            break;
                        case BEAR:
                            map.add("M");
                            break;
                        case SPIDER:
                            map.add("P");
                            break;
                        case PLAYER:
                            map.add("@");
                            break;
                        case BOSS:
                            map.add("B");
                            break;
                    }
                    switch (cell.getItem().getItemType()) {
                        case SWORD:
                            map.add("s");
                            break;
                        case AXE:
                            map.add("a");
                            break;
                        case BOW:
                            map.add("b");
                            break;
                        case BREASTPLATE:
                            map.add("e");
                            break;
                        case HELMET:
                            map.add("h");
                            break;
                        case SHIELD:
                            map.add("i");
                            break;
                        case KEY:
                            map.add("k");
                            break;
                    }
                    switch (cell.getObstacle().getObstaclesType()){
                        case DOOR:
                            map.add("d");
                            break;
                        case TELEPORT:
                            map.add("t");
                            break;
                        case CRATE:
                            map.add("c");
                            break;
                    }
                } else {
                    switch (cell.getType()) {
                        case EMPTY:
                            map.add(" ");
                            break;
                        case WALL:
                            map.add("#");
                            break;
                        case ROCK:
                            map.add("r");
                            break;
                        case FLOOR:
                            map.add(".");
                            break;
                        case GRASS:
                            map.add("_");
                            break;
                        case GATE:
                            map.add("g");
                            break;
                    }

//                        default:
//                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                }
            }
            map.add("/n");
        }
        return map;
    }
}
