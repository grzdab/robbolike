package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.Inventory;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

public class Player extends Actor {
    private final Inventory inventory = new Inventory();
    private int exp;
    public Player(Cell cell, int health, int attack, int defence, int exp, ActorType actorType) {
        super(cell, health, attack, defence, actorType);
        this.exp = exp;
    }

    public String getTileName() {
        return "player";
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return "name - not implement. yet ;)";
    }
}
