package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import java.util.concurrent.ThreadLocalRandom;

public class Spider extends Monster {
    private Cell cell;
    private int health = 10;

    public Spider(Cell cell) {
        super(cell);
    }


    @Override
    public String getTileName() {
        return "spider";
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    //    @Override
//    public void move(int dx, int dy) {
//        int direction = ThreadLocalRandom.current().nextInt(0,1);
//        switch (direction){
//            //while z kolizja i odbija się od ściany
//
//            case 0: super.move(dx-1, dy);
//                    if (cell.getNeighbor(dx-1,dy) == "wall"){
//                        super.move(dx+1, dy);
//                        direction = 1;
//                    }
//
//            case 1: super.move(dx+1, dy);
//                if (cell.getNeighbor(dx+1,dy) == "wall"){
//                    super.move(dx-1, dy);
//                    direction = 0;
//                }
//        }
//
//    }
}
