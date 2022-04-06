package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Door extends Obstacle {

    private Cell cell;

    public Door(Cell cell) {
        super(cell,ObstaclesType.DOOR);
        this.cell = cell;
        this.cell.setObstacle(this);
    }

    @Override
    public String getTileName() {
        return "door";
    }

    public void open() {
        cell.setObstacle(null);
    }

}
