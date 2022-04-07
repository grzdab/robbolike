package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.actors.monsters.*;
import com.codecool.dungeoncrawl.logic.obstacles.Bomb;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;


import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class MapLoader {
    public static volatile List<Monster> monsters = new CopyOnWriteArrayList<>();

    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/level00.txt");
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
                        case '_':
                            cell.setType(CellType.GRASS);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Skeleton(cell, 10, 1, 0));
                            break;
                        case 'M':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Bear(cell, 50, 10, 0));
                            break;
                        case 'P':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Spider(cell, 25, 5, 0));
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
                        case 'o':
                            cell.setType(CellType.FLOOR);
                            new Bomb(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            cell.setType(CellType.FLOOR);
                            new Teleport(cell, Character.valueOf(line.charAt(x)));
                            break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Crate(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell, 100, 100, 100, 0));
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            monsters.add(new Boss(cell, 100, 20, 0));
                            break;
                        case 'g':
                            cell.setType(CellType.GATE);
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);

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
            if(monster.getHealth() <= 0)
            {
                removeMonster(monster);
                System.out.println("Dead monster!");
                System.out.println("Try to move");
                System.out.println(monster.getCell().getType());
            }
            else {
                monster.moveMonster();
            }
        }
    }

    public static void removeMonster(Monster monster) {
        monsters.remove(monster);
        monster.removeActorFromMap();
        System.out.println("Dead monster!");
        System.out.println(monster.getCell().getType());
    }
}
