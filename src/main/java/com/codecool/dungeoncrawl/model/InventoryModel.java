package com.codecool.dungeoncrawl.model;

import com.codecool.dungeoncrawl.InventoryItem;
import javafx.collections.ObservableList;

public class InventoryModel extends BaseModel {
    private int player_id;
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

    public InventoryModel(int player_id) {
        this.player_id = player_id;
    }

    public InventoryModel(int player_id, int breastplate, int coin, int helmet, int key, int nut, int resistor, int shield, int screwdriver, int spring, int taser, int wrench) {
        this.player_id = player_id;
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

    public InventoryModel(ObservableList<InventoryItem> inventory) {
        for(InventoryItem item : inventory) {
            switch (item.getInventoryName()) {
                case "player_id":
                    this.player_id += item.getInventoryCount();
                    break;
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
                    this.taser += item.inventoryCount;
                    break;
                case "wrench":
                    this.wrench += item.inventoryCount;
                    break;
            }
        }
    }

    public int getPlayer_id() {
        return player_id;
    }

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
