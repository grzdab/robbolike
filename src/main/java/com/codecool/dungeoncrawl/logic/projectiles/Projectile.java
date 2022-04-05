package com.codecool.dungeoncrawl.logic.projectiles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.ItemType;

public class Projectile extends Item implements Drawable {

    public Projectile(Cell cell, ItemType itemType) {
        super(cell, itemType);
    }

    @Override
    public String getTileName() {
        return "projectile";
    }
}
