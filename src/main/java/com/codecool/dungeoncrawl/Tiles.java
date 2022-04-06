package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.actors.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;
    public static int round = 0;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("player", new Tile(30, 10)); //@
        tileMap.put("playerAlt", new Tile(31, 10)); //@

        tileMap.put("empty", new Tile(0, 0)); //
        tileMap.put("wall", new Tile(10, 17)); //#
        tileMap.put("floor", new Tile(2, 0)); //.
        tileMap.put("rock", new Tile(2,11)); // r
        tileMap.put("gate", new Tile(18,10)); //g
        tileMap.put("grass", new Tile(6,0));//_


        tileMap.put("skeleton", new Tile(29, 6)); //S
        tileMap.put("spider", new Tile(28,5)); // P
        tileMap.put("bear", new Tile(30,8)); // M

        tileMap.put("teleport", new Tile(19, 18)); //0-9
        tileMap.put("exit", new Tile(17, 31)); //e
        tileMap.put("pistol", new Tile(5, 31)); //p
        tileMap.put("door", new Tile(3, 3)); // d
        tileMap.put("key", new Tile(17, 23)); //k
        tileMap.put("crate", new Tile(3, 5)); //c
        tileMap.put("bomb", new Tile(13, 31)); //b
        tileMap.put("screwdriver", new Tile(4, 31)); // s
        tileMap.put("wrench", new Tile(6, 29)); // a
        tileMap.put("taser", new Tile(8, 28)); // b
        tileMap.put("breastplate", new Tile(4, 23)); // e
        tileMap.put("helmet", new Tile(2, 22)); // h
        tileMap.put("shield", new Tile(5, 26)); // i
        tileMap.put("boss", new Tile(25,8)); // B
        tileMap.put("coin", new Tile(22,4));//$

    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
