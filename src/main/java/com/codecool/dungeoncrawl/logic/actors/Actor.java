package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.*;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;

public abstract class Actor implements Drawable {
    protected volatile Cell cell;
    private volatile int health;
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
        if (health > 0) {
            Cell nextCell = cell.getNeighbor(dx, dy);

            if (nextCell.getType() == CellType.WALL) {
                System.out.println("CANT WALK THROUGH THE WALLS!");
                return;
            } else if (nextCell.getItem() != null) {
                if (this instanceof Player) {
                    ((Player) this).getInventory().addItem(nextCell.getItem());
                }
                takeItem(nextCell.getItem());
            } else if (nextCell.getObstacle() != null) {
                if (!checkCollision(nextCell.getObstacle(), dx, dy)) return;
                ;
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
        else {
            System.out.println("Dead monster!");
            System.out.println("DOESN'T MOVE");
            System.out.println(getCell().getType());
        }
    }

    public void fight(Actor attacker, Actor defender) {
        System.out.println("FIGHT!");
        while (true) {
            System.out.println("Attacker: " + attacker);
            System.out.println("Defender: " + defender);
            if (!isDefence(attacker, defender)) {
                defender.setHealth(defender.getHealth() - attacker.getAttack());
                System.out.println("Defender health: " + defender.getHealth());
                if (isDead(defender)) {
                    System.out.println("Defender is dead!");
                    if (defender instanceof Monster) {
                        defender.removeActorFromMap();
                        // MapLoader.monsters.remove(defender);
                        // MapLoader.removeMonster((Monster)defender);
                        defender.removeActorFromMap();
                    } else if (defender instanceof Player) {
//                        defender.getCell().setType(CellType.EMPTY);
//                        defender.getCell().setActor(null);
                        defender.removeActorFromMap();
                        GameMap.removePlayer();
                        defender.removeActorFromMap();
                    }
                    break;
                }
            }

            if (!isDefence(defender, attacker)) {
                attacker.setHealth((attacker.getHealth() - defender.getAttack()));
                System.out.println("Attacker health: " + attacker.getHealth());
                if (isDead(attacker)) {
                    System.out.println("Attacker is dead");
                    if (attacker instanceof Monster) {
//                        MapLoader.monsters.remove(attacker);
//                        attacker.getCell().setActor(null);
                        attacker.removeActorFromMap();
                       //  MapLoader.removeMonster((Monster)attacker);
                        attacker.removeActorFromMap();
                    } else if (attacker instanceof Player) {
//                        attacker.getCell().setActor(null);
//                        attacker.getCell().setType(CellType.EMPTY);
                        attacker.removeActorFromMap();
                        GameMap.removePlayer();
                        attacker.removeActorFromMap();
                    }
                    break;
                }
            }
        }
    }

    public boolean isDead(Actor actor){
        return actor.health <= 0;
    }
    public boolean isDefence(Actor actor1, Actor actor2){
        return actor2.getDefence() > actor1.getAttack();
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
            if (((Player) this).getInventory().hasItem("key")) {
                ((Door) object).open();
                ((Player) this).getInventory().removeItem(new Key(new Cell(null, 0, 0, CellType.EMPTY)));
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
            System.out.println(object.getClass().getName());
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

    public void removeActorFromMap() {
        this.cell.setActor(null);
        // cell.setType(CellType.FLOOR);
    }

}
