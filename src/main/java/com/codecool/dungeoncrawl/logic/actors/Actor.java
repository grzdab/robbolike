package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health;
    private int defence;
    private int attack;

    public Actor(Cell cell, int health, int attack, int defence) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    public void fight(Actor actor1, Actor actor2) {
        while (isAlive(actor1, actor2)) {
            if (!isDefence(actor1, actor2)) {
                actor2.setHealth(actor2.getHealth() - actor1.getAttack());
                if (!isAlive(actor1, actor2)) {
                    break;
                } else if (!isDefence(actor2, actor1)) {
                    actor1.setHealth((actor1.getHealth() - actor1.getAttack()));
                    if (!isAlive(actor1, actor2)) {
                        break;
                    }
                }
            }
        }
    }
    public boolean isAlive(Actor actor1, Actor actor2){
        return actor1.getHealth() >= 0 || actor2.getHealth() >= 0;
    }
    public boolean isDefence(Actor actor1, Actor actor2){
        return actor1.getDefence() > actor2.getAttack();
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
