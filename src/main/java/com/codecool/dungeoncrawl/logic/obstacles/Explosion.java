package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import javafx.scene.canvas.GraphicsContext;

public class Explosion extends Obstacle {
    GraphicsContext context;
    Cell cell;

    private String[] types = {"explode", "collapse"};
    private String type;
    private String[] explosionTiles = {"hot_explosion0","hot_explosion1","hot_explosion2","hot_explosion3"};
    private String[] collapseTiles = {"cold_explosion0","cold_explosion1","cold_explosion2","cold_explosion3"};
    private int step;

    public Explosion(Cell cell, int step, GraphicsContext context, String type) {
        super(cell);
        this.step = step;
        this.cell = cell;
        this.cell.setObstacle(this);
        this.context = context;
        this.type = type;
    }

    @Override
    public String getTileName() {
        if (type.equals("explode")) {
            return explosionTiles[step];
        } else {
            return collapseTiles[step];
        }
    }

    public void explode() {
        int x = this.cell.getX();
        int y = this.cell.getY();
        Tiles.drawTile(context, this, x, y);
    }
}
