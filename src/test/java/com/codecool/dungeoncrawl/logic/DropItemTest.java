package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.DropItem;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.monsters.Boss;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DropItemTest {
    Cell cell = new Cell(null, 1, 1, null);
    List<Object> actorsTest = new ArrayList<>(Arrays.asList(
            new Boss(cell, 1, 1, 1),
            new Object(),
            null));
    List<String> exceptedItems = new ArrayList<>(Arrays.asList("screwdriver", null, null));

    @Test
    void testRightDrop() {
        int count = -1;
        for (Object actor : actorsTest) {
            count++;
            String output = null;
            try {
                output = DropItem.getElementToDrop((Actor) actor);
            } catch (ClassCastException e) {
            }
            assertEquals(exceptedItems.get(count), output);
        }
    }
}
