package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;

import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private final List<Monster> monsters;


    public Actor(Cell cell, List<Monster> monsters) {
        this.cell = cell;
        this.monsters = monsters;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    public void generateMonsters(int numberOfSkeleton, int numberOfSpiders, int numberOfBears){
        for (int i = 0; i < numberOfSkeleton; i++) {
            Skeleton skeleton = new Skeleton(cell);
            monsters.add(skeleton);
        }
        for (int i = 0; i < numberOfSpiders; i++) {
            Spider spider = new Spider(cell);
            monsters.add(spider);
        }
        for (int i = 0; i < numberOfBears; i++) {
            Bear bear = new Bear(cell);
            monsters.add(bear);
        }
    }
    public void monstersMove(){
        for (Monster monster : monsters) {
            monster.move();
        }
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
