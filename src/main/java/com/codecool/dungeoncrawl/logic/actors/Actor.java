package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.monsters.Bear;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.actors.monsters.Skeleton;
import com.codecool.dungeoncrawl.logic.actors.monsters.Spider;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Obstacle;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;

import java.util.List;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health;
    private int defence;
    private int attack;
    private boolean hasKey = false; // testowo przed implementacją inventory


    public Actor(Cell cell, int health, int attack, int defence) {
        this.cell = cell;
        this.cell.setActor(this);
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }


    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (nextCell.getType() == CellType.WALL) {
            System.out.println("CANT WALK THROUGH THE WALLS!");
            return;
        } else if (nextCell.getItem() != null) {
            takeItem(nextCell.getItem());
        } else if (nextCell.getObstacle() != null) {
            if (!checkCollision(nextCell.getObstacle(), dx, dy)) return;;
        } else if (nextCell.getActor() != null) {
            checkCollision(nextCell.getActor(), dx, dy);
            return;
        }

        cell.setActor(null);
        if (takeItem(nextCell.getItem())) {
            cell.setItem(null);
        }
        nextCell.setActor(this);
        cell = nextCell;
    }

    public void fight(Actor actor1, Actor actor2) {
        while (isAlive(actor1, actor2)) {
            if (!isDefence(actor1, actor2)) {
                actor2.setHealth(actor2.getHealth() - actor1.getAttack());
                if (!isAlive(actor1, actor2)) {
                    break;
                } else if (!isDefence(actor2, actor1)) {
                    actor1.setHealth((actor1.getHealth() - actor1.getAttack()));
                    if (!isAlive(actor1, actor2)) {
                        break;
                    }
                }
            }
        }
    }
    public boolean isAlive(Actor actor1, Actor actor2){
        return actor1.getHealth() >= 0 || actor2.getHealth() >= 0;
    }
    public boolean isDefence(Actor actor1, Actor actor2){
        return actor1.getDefence() > actor2.getAttack();
    }
    private boolean takeItem(Item item) {

        if (item instanceof Key) {
            System.out.println("YOU FOUND THE KEY");
            hasKey = true;
        }

        return true;
    }



    private boolean checkCollision(Object object, int x, int y) {

        if (object instanceof Door) {
            if (hasKey) {
                ((Door) object).open();
                hasKey = false;
                return true;
            } else {
                System.out.println("YOU NEED A KEY TO OPEN THIS DOOR!");
            }
            return false;
        } else if (object instanceof Crate) {
            if (!((Crate) object).move(x,y)) {
                return false;
            }
        } else if (object instanceof Teleport) {
            Cell thisTeleport = ((Teleport) object).getCell();
            Cell[][] map = GameMap.getMap();
            int thisX = thisTeleport.getX();
            int thisY = thisTeleport.getY();
            for (int mapY = 0;mapY < GameMap.getHeight(); mapY++ ) {
                for (int mapX = 0; mapX < GameMap.getWidth(); mapX++) {
                    if (map[mapY][mapX].getX() == thisX && map[mapY][mapX].getY() == thisY) {
                        System.out.println("To ten teleport");
                        break;
                    }
                }
            }





        } else {
            System.out.println("Another obstacle");
        }

        return true;
    }




    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
