package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;

public class Teleport extends Obstacle {

    private Cell cell;

    public Teleport(Cell cell, ObstaclesType obstaclesType) {
        super(cell, obstaclesType);
        this.cell = cell;
        this.cell.setObstacle(this);
    }

    @Override
    public String getTileName() {
        return "teleport";
    }


    public void transfer() {};

}
