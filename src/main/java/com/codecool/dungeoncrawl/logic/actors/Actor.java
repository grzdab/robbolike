package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.*;
import com.codecool.dungeoncrawl.logic.actors.monsters.Monster;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Door;
import com.codecool.dungeoncrawl.logic.obstacles.Teleport;
import javafx.application.Platform;

import java.util.Objects;

public abstract class Actor implements Drawable {
    protected volatile Cell cell;
    protected volatile int health;
    private int defence;
    private int attack;
    private boolean hasKey = false; // testowo przed implementacją inventory
    private Item item;
    private boolean swapTile;

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

            if (nextCell.getType() == CellType.WALL || nextCell.getType() == CellType.ROCK ) {
                System.out.println("CANT WALK THROUGH THE WALLS OR ROCK!");
                return;
            } else if (nextCell.getItem() != null) {
                if (this instanceof Player)
                {
                    ((Player) this).getInventory().addItem(nextCell.getItem());
                    if(Objects.equals(nextCell.getItem().getTileName(), "key"))
                    {
                        System.out.println("Added key");
                    }
                }
                takeItem(nextCell.getItem());
    //            editStats(nextCell);
            } else if (nextCell.getObstacle() != null && nextCell.getObstacle() instanceof Teleport) {
                Teleport teleport = (Teleport) nextCell.getObstacle();
                Cell target = teleport.getTarget(this, dx, dy);
                if (target != null) {
                    nextCell = target;
                } else {
                    nextCell = cell;
                }
            } else if (nextCell.getObstacle() != null) {
                if (!checkCollision(nextCell.getObstacle(), dx, dy)) return;
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
            System.out.println("Dead actor!");
            System.out.println("DOESN'T MOVE");
            System.out.println(getCell().getType());
        }
    }

//    private void editStats(Cell nextCell) {
//        Item item = nextCell.getItem();// na pewno do przerobienia
//        String itemTitle = item.getTileName();
//        if (itemTitle == "axe") {
//            Player.getAtack();
//        } else if (item instanceof Bow) {
//
//        } else if (item instanceof Breastplate) {
//
//        } else if (item instanceof Helmet) {
//
//        } else if (item instanceof Shield) {
//
//        } else {
//
//        }
//    }

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
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() ->
                    {
                        if (defender instanceof Monster) {
                            //defender.removeActorFromMap();
                            // MapLoader.monsters.remove(defender);
                            // MapLoader.removeMonster((Monster)defender);
                            // defender.removeActorFromMap();
                        } else if (defender instanceof Player) {
//                        defender.getCell().setType(CellType.EMPTY);
//                        defender.getCell().setActor(null);
                            defender.removeActorFromMap();
                            GameMap.removePlayer();
                            defender.removeActorFromMap();
                        }
                        // MapLoader.monstersMove();
                    });
                    break;
                }
            }

            if (!isDefence(defender, attacker)) {
                attacker.setHealth((attacker.getHealth() - defender.getAttack()));
                System.out.println("Attacker health: " + attacker.getHealth());
                if (isDead(attacker)) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() ->
                    {
                        System.out.println("Attacker is dead");
                        if (attacker instanceof Monster) {
//                        MapLoader.monsters.remove(attacker);
//                        attacker.getCell().setActor(null);
                            attacker.removeActorFromMap();
                            cell.setType(CellType.FLOOR);
                            new Coin(cell);
                            //  MapLoader.removeMonster((Monster)attacker);
                            attacker.removeActorFromMap();
                        } else if (attacker instanceof Player) {

//                        attacker.removeActorFromMap();
                           //  MapLoader.removeMonster((Monster)attacker);
                            attacker.removeActorFromMap();
                        }
                    // MapLoader.monstersMove();
                    });
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
            return ((Crate) object).move(x, y);
        }

//                    .removeItem(new Key(new Cell(null, 0, 0, CellType.EMPTY))
//            for (int mapY = 0;mapY < GameMap.getHeight(); mapY++ ) {
//                for (int mapX = 0; mapX < GameMap.getWidth(); mapX++) {
//                    if (map[mapY][mapX].getX() == thisX && map[mapY][mapX].getY() == thisY) {
//                        System.out.println("To ten teleport");
//                        break;
//                    }
//                }
//            }
    else {
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
        System.out.println("Remove Actor from map");
        this.cell.setActor(null);
        MapLoader.monstersMove();
        // cell.setType(CellType.FLOOR);
    }

}
