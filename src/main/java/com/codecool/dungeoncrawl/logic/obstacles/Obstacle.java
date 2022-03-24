package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

public abstract class Obstacle extends Item implements Drawable {

    private Cell cell;

    public Obstacle(Cell cell) {
        this.cell = cell;
        this.cell.setObstacle(this);
    }

}
