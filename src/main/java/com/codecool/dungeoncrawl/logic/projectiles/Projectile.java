package com.codecool.dungeoncrawl.logic.projectiles;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Projectile extends Actor {
    private Cell cell;
    private char vector;
    private int step = 0;

    public Projectile(Cell cell, char vector) {
        super(cell, vector);
        this.cell = cell;
        this.vector = vector;
    }

    @Override
    public String getTileName() {
        switch (vector) {
            case 'h':
                if (step == 0) {
                    step = 1;
                    return "shotH1";
                } else if (step == 1) {
                    step = 0;
                    return "shotH2";
                } else {
                    break;
                }
            case 'v':
                if (step == 0) {
                    step = 1;
                    return "shotV1";
                } else if (step == 1) {
                    step = 0;
                    return "shotV2";
                } else {
                    break;
                }
        }
        return null;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
