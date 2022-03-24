package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.actors.monsters.*;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapLoader {
    public static List<Monster> monsters = new ArrayList<>();

    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case 'r':
                            cell.setType(CellType.ROCK);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Skeleton(cell, 10, 1, 0, Bear.monsterDirection()));
                            break;
                        case 'M':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Bear(cell, 50, 10, 0, Bear.monsterDirection()));
                            break;
                        case 'P':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Spider(cell, 25, 5, 0, Spider.monsterDirection()));
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Axe(cell);
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
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell, 10, 10, 10, 10));
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Boss(cell, 100, 20, 0, Spider.monsterDirection()));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

    public static void monstersMove() {
        for (Monster monster : monsters) {
            monster.moveMonster();
        }
    }
}
