package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bomb extends Obstacle{

    private Cell cell;
    private String[] names = {"bomb"};
    private int step = 0;
    boolean explodes = false;

    public Bomb(Cell cell) {
        super(cell);
        this.cell = cell;
        this.cell.setObstacle(this);
    }

    @Override
    public String getTileName() {
        return "bomb";
    }

    public boolean move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getActor() == null &&
            nextCell.getItem() == null &&
            nextCell.getObstacle() == null &&
            nextCell.getType() != CellType.WALL
        ) {
            cell.setObstacle(null);
            nextCell.setObstacle(this);
            cell = nextCell;
            return true;
        } else {
            System.out.println("No space to move the bomb");
        }

        return false;
    }

    public void explode(int step, GraphicsContext context) {
        Explosion e = new Explosion(this.cell, step, context);
        e.explode();
    }

}
