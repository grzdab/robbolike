package com.codecool.dungeoncrawl.model;

public class InventoryModel extends BaseModel {
    private int id;
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

    public InventoryModel(int id) {
        this.id = id;
    }

    public InventoryModel(int id, int breastplate, int coin, int helmet, int key, int nut, int resistor, int shield, int screwdriver, int spring, int taser, int wrench) {
        this.id = id;
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

    @Override
    public int getId() {
        return id;
    }

    public int getBreastplate() {
        return breastplate;
    }

    public void setBreastplate(int breastplate) {
        this.breastplate = breastplate;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
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

    public void setKey(int key) {
        this.key = key;
    }

    public int getNut() {
        return nut;
    }

    public void setNut(int nut) {
        this.nut = nut;
    }

    public int getResistor() {
        return resistor;
    }

    public void setResistor(int resistor) {
        this.resistor = resistor;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
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

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getTaser() {
        return taser;
    }

    public void setTaser(int taser) {
        this.taser = taser;
    }

    public int getWrench() {
        return wrench;
    }

    public void setWrench(int wrench) {
        this.wrench = wrench;
    }
}
