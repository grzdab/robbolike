package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import javafx.scene.canvas.GraphicsContext;

public class Explosion extends Obstacle {
    GraphicsContext context;

    Cell cell;
    private String[] names = {"hot_explosion0","hot_explosion1","hot_explosion2","hot_explosion3"};
    private int step;

    public Explosion(Cell cell, int step, GraphicsContext context) {
        super(cell);
        this.step = step;
        this.cell = cell;
        this.cell.setObstacle(this);
        this.context = context;
    }

    @Override
    public String getTileName() {
        return names[step];
    }

    public void explode() {
        int x = this.cell.getX();
        int y = this.cell.getY();
        Tiles.drawTile(context, this, x, y);
        cell.setActor(null);
    }
}
