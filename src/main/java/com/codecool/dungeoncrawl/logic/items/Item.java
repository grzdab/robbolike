package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Item implements Drawable {
    private Cell cell;
    private ItemType type;



    public Item(Cell cell, ItemType type) {
        this.cell = cell;
        this.cell.setItem(this);
        this.type = type;
    }

    protected Item() {
    }

    public Item(Cell cell) {
    }

    public ItemType getType() {
        return type;
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
    public ItemType getItemType() {
        return itemType;
    }
}
