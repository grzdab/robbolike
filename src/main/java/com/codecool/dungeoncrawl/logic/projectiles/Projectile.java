package com.codecool.dungeoncrawl.logic.projectiles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

public class Projectile extends Item implements Drawable {

    public Projectile(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "projectile";
    }
}
