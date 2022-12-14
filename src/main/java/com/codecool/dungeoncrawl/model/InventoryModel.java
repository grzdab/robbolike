package com.codecool.dungeoncrawl.model;

import com.codecool.dungeoncrawl.InventoryItem;
import javafx.collections.ObservableList;

public class InventoryModel extends BaseModel {
//    private PlayerModel player;
    private  int playerId;
    private int breastplate;
    private int coin;
    private int helmet;
    private int key;
    private int nut;
    private int resistor;
    private int shield;
    private int screwdriver;
    private int spring;
    private int taser;
    private int wrench;

//    public InventoryModel(PlayerModel player) {
//        this.player = player;
//    }

    public InventoryModel(int playerId, int breastplate, int coin, int helmet, int key, int nut, int resistor, int shield, int screwdriver, int spring, int taser, int wrench) {
        this.playerId = playerId;
        this.breastplate = breastplate;
        this.coin = coin;
        this.helmet = helmet;
        this.key = key;
        this.nut = nut;
        this.resistor = resistor;
        this.shield = shield;
        this.screwdriver = screwdriver;
        this.spring = spring;
        this.taser = taser;
        this.wrench = wrench;
    }

    public InventoryModel(ObservableList<InventoryItem> inventory, int playerId) {
        this.playerId = playerId;
        for(InventoryItem item : inventory) {
            switch (item.getInventoryName()) {
//                case "player_id":
//                    this.player += getPlayer();
//                    break;
                case "breastplate":
                    this.breastplate += item.getInventoryCount();
                    break;
                case "coin":
                    this.coin += item.getInventoryCount();
                    break;
                case "helmet":
                    this.helmet += item.getInventoryCount();
                    break;
                case "key":
                    this.key += item.getInventoryCount();
                    break;
                case "nut":
                    this.nut += item.getInventoryCount();
                    break;
                case "resistor":
                    this.resistor += item.getInventoryCount();
                    break;
                case "shield":
                    this.shield += item.getInventoryCount();
                    break;
                case "screwdriver":
                    this.screwdriver += item.getInventoryCount();
                    break;
                case "spring":
                    this.spring += item.getInventoryCount();
                    break;
                case "taser":
                    this.taser += item.getInventoryCount();
                    break;
                case "wrench":
                    this.wrench += item.getInventoryCount();
                    break;
            }
        }
    }

    public int getPlayerId() {
        return playerId;
    }

//    public PlayerModel getPlayer() {
//        return player;
//    }

    public int getBreastplate() {
        return breastplate;
    }

    public int getCoin() {
        return coin;
    }
    public int getHelmet() {
        return helmet;
    }

    public void setHelmet(int helmet) {
        this.helmet = helmet;
    }

    public int getKey() {
        return key;
    }
    public int getNut() {
        return nut;
    }
    public int getResistor() {
        return resistor;
    }
    public int getShield() {
        return shield;
    }
    public int getScrewdriver() {
        return screwdriver;
    }

    public void setScrewdriver(int screwdriver) {
        this.screwdriver = screwdriver;
    }

    public int getSpring() {
        return spring;
    }
    public int getTaser() {
        return taser;
    }

    public int getWrench() {
        return wrench;
    }

}
