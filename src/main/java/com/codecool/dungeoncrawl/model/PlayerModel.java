package com.codecool.dungeoncrawl.model;

import com.codecool.dungeoncrawl.logic.actors.Player;

import java.util.List;

public class PlayerModel extends BaseModel {
    private String playerName;
    private int exp;
    private int hp;
    private int att;
    private int def;
    private int x;
    private int y;
    private List inventory;
    private int id;

    public PlayerModel(String playerName, int x, int y) {
        this.playerName = playerName;
        this.x = x;
        this.y = y;
    }

    public PlayerModel(Player player) {
        this.playerName = player.getName();
        this.x = player.getX();
        this.y = player.getY();
        this.exp = player.getExp();
        this.hp = player.getHealth();
        this.att = player.getAttack();
        this.def = player.getDefence();
        this.inventory = player.getInventory().getInventory();

    }

    public PlayerModel(int id, String playerName, int x, int y, int hp, int exp, int att, int def) {
        this.id = id;
        this.playerName = playerName;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.exp = exp;
        this.att = att;
        this.def = def;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public List getInventory() {
        return inventory;
    }

    public void setInventory(List inventory) {
        this.inventory = inventory;
    }
}