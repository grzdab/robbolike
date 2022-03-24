package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Item implements Drawable {
    private Cell cell;



    public Item(Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
    }

    protected Item() {
    }

//    public int randomItem(){
////        List<String> possibleItems = new ArrayList<>();
////        possibleItems = List.of("Axe","Bow","Breastplate", "Helmet", "Shield", "Sword");
//     return ThreadLocalRandom.current().nextInt(0, 6);
//    }
    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
