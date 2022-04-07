package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.Inventory;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;

public class Player extends Actor {
    private final Inventory inventory = new Inventory();
    private int exp;
    private String name = "player";
    private int playerId;

    public Player(Cell cell, int health, int attack, int defence, int exp, ActorType actorType, int playerId) {
        super(cell, health, attack, defence,  actorType);
        this.exp = exp;
        this.playerId = playerId;
    }

    public String getTileName() {
        return name;
    }

    public void setAltTileName() {
        name = name.equals("player")? "playerAlt" : "player";
    }

    public String getAlternateTileName() {
        return "playerAlt";
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

    public int getPlayerId() {
        return playerId;
    }
}
