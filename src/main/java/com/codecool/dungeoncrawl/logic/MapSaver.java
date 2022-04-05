package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.ActorType;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.monsters.Boss;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapSaver {
    public static void saver(List<String> game) throws FileNotFoundException {
        PrintWriter save = new PrintWriter("save.txt");
        save.println(game);
        save.close();
    }

    public static List<String> game() {
        int width = GameMap.getWidth();
        int height = GameMap.getWidth();
        Cell[][] cells = GameMap.getMap();

        List<String> map = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x < width) {
                    Cell cell = cells[y][x];
                    if (cell.getType() == CellType.FLOOR) {
                        switch (cell.getActor().getActorType()) {
                            case ActorType.SKELETON:
                                map.add("S");
                                break;
                            case ActorType.BEAR:
                                map.add("M");
                                break;
                            case ActorType.SPIDER:
                                map.add("P");
                                break;
                            case ActorType.PLAYER:
                                map.add("@");
                                break;
                            case ActorType.BOSS:
                                map.add("B");
                                break;
                        }
                        switch (cell.getItem().getItemType()){

                    }

                            case 's':
                                cell.setType(CellType.FLOOR);
                                new Sword(cell);
                                break;
                            case 'a':
                                cell.setType(CellType.FLOOR);
                                new Axe(cell, ItemType.AXE);
                                break;
                            case 'b':
                                cell.setType(CellType.FLOOR);
                                new Bow(cell);
                                break;
                            case 'e':
                                cell.setType(CellType.FLOOR);
                                new Breastplate(cell);
                                break;
                            case 'h':
                                cell.setType(CellType.FLOOR);
                                new Helmet(cell);
                                break;
                            case 'i':
                                cell.setType(CellType.FLOOR);
                                new Shield(cell);
                                break;
                            case 'd':
                                cell.setType(CellType.FLOOR);
                                new Door(cell);
                                break;
                            case 'k':
                                cell.setType(CellType.FLOOR);
                                new Key(cell);
                                break;
                            case 't':
                                cell.setType(CellType.FLOOR);
                                new Teleport(cell);
                                break;
                            case 'c':
                                cell.setType(CellType.FLOOR);
                                new Crate(cell);
                                break;
                        }
                    } else {
                        switch (cell.getType()) {
                            case CellType.EMPTY:
                                map.add(" ");
                                break;
                            case CellType.WALL:
                                map.add("#");
                                break;
                            case CellType.ROCK:
                                map.add("r");
                                break;
                            case CellType.FLOOR:
                                map.add(".");
                                break;
                            case CellType.GRASS:
                                map.add("_");
                                break;
                            case CellType.GATE:
                                map.add("g");
                                break;
                        }

//                        default:
//                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }
}
