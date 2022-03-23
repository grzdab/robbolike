package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.actors.monsters.*;


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
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Skeleton(cell, 10, 1, 0));
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Bear(cell, 50, 10, 0));
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Spider(cell, 25, 5, 0));
                            break;
                        case 't':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
//                        case 'k':
//                            cell.setType(CellType.FLOOR);
//                            new Key(cell);
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell, 10, 10, 10, 10));
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
        //ogsarnać direction żeby wywoływało się raz na poczatku
        int direction = Bear.monsterDirection();
        for (Monster monster : monsters) {
            monster.moveMonster(direction);
        }
    }
}
