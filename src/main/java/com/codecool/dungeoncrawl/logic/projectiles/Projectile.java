package com.codecool.dungeoncrawl.logic.projectiles;

import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.obstacles.Bomb;
import com.codecool.dungeoncrawl.logic.obstacles.Crate;
import com.codecool.dungeoncrawl.logic.obstacles.Explosion;
import javafx.scene.canvas.GraphicsContext;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Projectile extends Actor implements Runnable {
    private Cell cell;
    private final String vector;
    private int sequence = 0;
    private int vectorX;
    private int vectorY;
    private GraphicsContext context;
    Timer t = new Timer();

    public Projectile(Cell cell, String vector, GraphicsContext context) {
        super(cell, vector);
        this.context = context;
        this.cell = cell;
        this.vector = vector;
        switch (vector) {
            case "up":
                vectorX = 0;
                vectorY = -1;
                break;
            case "down":
                vectorX = 0;
                vectorY = 1;
                break;
            case "left":
                vectorX = -1;
                vectorY = 0;
                break;
            case "right":
                vectorX = 1;
                vectorY = 0;
                break;
        }
    }

    @Override
    public String getTileName() {
        switch (vector) {
            case "up":
            case "down":
                if (sequence == 0) {
                    sequence = 1;
                    return "shotV1";
                } else if (sequence == 1) {
                    sequence = 0;
                    return "shotV2";
                } else {
                    break;
                }
            case "left":
            case "right":
                if (sequence == 0) {
                    sequence = 1;
                    return "shotH1";
                } else if (sequence == 1) {
                    sequence = 0;
                    return "shotH2";
                } else {
                    break;
                }
        }
        return null;
    }


    private void destroyArea(Cell cell) {
        List<Point> coordinates = new ArrayList<>();
        coordinates.add(new Point(-1,-1));
        coordinates.add(new Point(0,-1));
        coordinates.add(new Point(1,-1));
        coordinates.add(new Point(-1,0));
        coordinates.add(new Point(1,0));
        coordinates.add(new Point(-1,1));
        coordinates.add(new Point(0,1));
        coordinates.add(new Point(1,1));

        for (Point point:coordinates) {
            Cell target = cell.getNeighbor(point.x, point.y);
            target.setActor(null);
            if (target.getObstacle() instanceof Crate) {
                target.setObstacle(null);
            }
            explode(target);
        }

    }

    private void move() {
        Cell nextCell = cell.getNeighbor(vectorX, vectorY);
        if (nextCell.getObstacle() != null) {
            t.cancel();
            t.purge();
            if (nextCell.getObstacle() instanceof Bomb) {
                nextCell.setObstacle(null);
                cell.setProjectile(null);
                explode(nextCell);
                destroyArea(nextCell);
            } else {
                cell.setProjectile(null);
                explode(cell);
            }

        } else {
            if (nextCell.getType() == CellType.WALL) {
                cell.setProjectile(null);
                explode(cell);
                return;
            }

            nextCell.setProjectile(this);
            cell.setProjectile(null);
            Tiles.drawTile(context, cell, vectorX, vectorY);
            Tiles.drawTile(context, nextCell.getProjectile(), vectorX, vectorY);
            cell = nextCell;
        }

    }

    public void release() {
        t.scheduleAtFixedRate(new TimerTask() {
            int frames = 10;
            @Override
            public void run() {
                move();
                frames --;
                if (frames == 0) {
                    t.cancel();
                    t.purge();
                    cell.setProjectile(null);
                }
            }
        }, 0, 300);
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        release();
    }

    private void explode(Cell source) {
        Timer explosionTimer = new Timer();
        explosionTimer.scheduleAtFixedRate(new TimerTask() {
            int frames = 0;
            @Override
            public void run() {
                Explosion e = new Explosion(source, frames, context, "explode");
                e.explode();
                System.out.println("e");
                frames++;
                if (frames > 3) {
                    explosionTimer.cancel();
                    explosionTimer.purge();
                    source.setObstacle(null);
                    return;
                }
            }
        }, 0, 300);
    }
}
