package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

public abstract class Obstacle extends Item implements Drawable {

    private Cell cell;
    private ObstaclesType obstaclesType;

    public Obstacle(Cell cell, ObstaclesType obstaclesType) {
        this.cell = cell;
        this.cell.setObstacle(this);
        this.obstaclesType = obstaclesType;
    }
    public Obstacle(Cell cell) {
    }

    public ObstaclesType getObstaclesType() {
        return obstaclesType;
    }

}
