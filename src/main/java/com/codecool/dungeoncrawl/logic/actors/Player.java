package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Player extends Actor {
    private int defence;
    private int exp;
    public Player(Cell cell, int health, int attack, int defence, int exp) {
        super(cell, health, attack);
        this.defence = defence;
        this.exp = exp;
    }

    public String getTileName() {
        return "player";
    }
}
