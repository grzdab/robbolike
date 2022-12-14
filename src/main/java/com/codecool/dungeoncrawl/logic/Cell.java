package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.obstacles.Obstacle;
import com.codecool.dungeoncrawl.logic.projectiles.Projectile;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private Obstacle obstacle;
    private Projectile projectile;
    private GameMap gameMap;
    private int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public Actor getActor() {
        return actor;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    public Item getItem() {
        return item;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public Projectile getProjectile() {
        return this.projectile;
    }

    public Cell getNeighbor(int dx, int dy) {
        Cell neighbor = gameMap.getCell(x + dx, y + dy);
        return neighbor;
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
