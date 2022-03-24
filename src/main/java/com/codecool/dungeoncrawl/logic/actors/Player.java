package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

public class Player extends Actor {
    private int exp;
    public Player(Cell cell, int health, int attack, int defence, int exp) {
        super(cell, health, attack, defence);
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
}
