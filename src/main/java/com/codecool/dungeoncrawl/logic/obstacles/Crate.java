package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;

public class Crate extends Obstacle {

    private Cell cell;

    public Crate(Cell cell, ObstaclesType obstaclesType) {
        super(cell, obstaclesType);
        this.cell = cell;
        this.cell.setObstacle(this);
    }

    @Override
    public String getTileName() {
        return "crate";
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
            System.out.println("No space to move the crate");
        }

        return false;

    }

}
