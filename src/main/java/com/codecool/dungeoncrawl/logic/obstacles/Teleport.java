package com.codecool.dungeoncrawl.logic.obstacles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Teleport extends Obstacle {

    private Cell cell;
    private final int match;

    public Teleport(Cell cell, int match) {
        super(cell);
        this.cell = cell;
        this.match = match;
        this.cell.setObstacle(this);
    }

    @Override
    public String getTileName() {
        return "teleport";
    }

    public int getMatch() {
        return this.match;
    }

    public Cell getCell() {
        return cell;
    }

    public Cell getTarget(Actor actor, int x, int y) {
        Teleport matchingTeleport = null;
        findMmatchingTeleport:
        for (int i = 0; i < GameMap.getMap().length; i++) {
            Cell[] row = GameMap.getMap()[i];
            for (Cell cell : row) {
                if (cell.getObstacle() != null &&
                    cell.getObstacle() instanceof Teleport &&
                    cell.getObstacle() != this &&
                    match == ((Teleport) cell.getObstacle()).getMatch()) {
                    matchingTeleport = (Teleport) cell.getObstacle();
                    break findMmatchingTeleport;
                }
            }
        }

        //check if theres space to transfer to the matching teleport
        if (matchingTeleport != null) {
            if (matchingTeleport.getCell().getNeighbor(x, y).getObstacle() == null &&
                matchingTeleport.getCell().getNeighbor(x, y).getActor() == null &&
                matchingTeleport.getCell().getNeighbor(x, y).getType() != CellType.WALL) {
                return matchingTeleport.getCell().getNeighbor(x, y);
            } else {
                System.out.println("Theres no space to transfer to another teleport!");
            }
        }
    return null;
    }

}
