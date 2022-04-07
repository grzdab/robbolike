package com.codecool.dungeoncrawl.controllers;

import com.codecool.dungeoncrawl.InventoryItem;
import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.projectiles.Projectile;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class GameController {
    GameMap map = MapLoader.loadMap("map.txt");
    @FXML
    Canvas canvas;
    GraphicsContext context;

    @FXML
    Label healthValue;

    @FXML
    Label expValue;

    @FXML
    Label attackValue;

    @FXML
    Label defenceValue;

    @FXML
    Label levelValue;

    @FXML
    TableView<InventoryItem> tbInventory;

    @FXML
    TableColumn<InventoryItem, String> clItems;

    @FXML
    TableColumn<InventoryItem, Integer> clCount;

    @FXML
    public void initialize() {
        // System.out.println(canvas);
        context = canvas.getGraphicsContext2D();
        // System.out.println(context);
        clItems.setCellValueFactory(new PropertyValueFactory<>("inventoryName"));
        clCount.setCellValueFactory(new PropertyValueFactory<>("inventoryCount"));
        tbInventory.setItems(map.getPlayer().getInventory().getInventory());
    }

    @FXML
    void restoreRootFocus(MouseEvent event) {
        Scene scene = canvas.getScene();
        scene.getRoot().requestFocus();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
      //   System.out.println("Key pressed");
        if (map.getPlayer() != null) {
            switch (keyEvent.getCode()) {
                case UP:
                    map.getPlayer().move(0, -1, context);
                    refresh();
                    break;
                case DOWN:
                    map.getPlayer().move(0, 1, context);
                    refresh();
                    break;
                case LEFT:
                    map.getPlayer().move(-1, 0, context);
                    refresh();
                    break;
                case RIGHT:
                    map.getPlayer().move(1, 0, context);
                    refresh();
                    break;
                case W:
                    map.getPlayer().shoot(0,-1,context, "up");
                    break;
                case S:
                    map.getPlayer().shoot(0,1,context, "down");
                    break;
                case A:
                    map.getPlayer().shoot(-1,0,context, "left");
                    break;
                case D:
                    map.getPlayer().shoot(1,0,context, "right");
                    break;
            }
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    if (cell.getActor() instanceof Player) {
                        ((Player) cell.getActor()).setAltTileName();
                    }

                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else if (cell.getProjectile() != null) {
                    Tiles.drawTile(context, cell.getProjectile(), x, y);
                } else if (cell.getObstacle() != null) {
                    Tiles.drawTile(context, cell.getObstacle(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        Platform.runLater(() -> {
            healthValue.setText("" + map.getPlayer().getHealth());
            defenceValue.setText("" + map.getPlayer().getDefence());
            attackValue.setText("" + map.getPlayer().getAttack());
            expValue.setText("" + map.getPlayer().getExp());
        });
    }

    private void refreshMonster() {

            MapLoader.monstersMove();
            context.setFill(Color.BLACK);
            context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    Cell cell = map.getCell(x, y);
                    if (cell.getActor() != null) {
                        Tiles.drawTile(context, cell.getActor(), x, y);
                    } else if (cell.getItem() != null) {
                        Tiles.drawTile(context, cell.getItem(), x, y);
                    } else if (cell.getProjectile() != null) {
                        Tiles.drawTile(context, cell.getProjectile(), x, y);
                    } else if (cell.getObstacle() != null) {
                        Tiles.drawTile(context, cell.getObstacle(), x, y);
                    } else {
                        Tiles.drawTile(context, cell, x, y);
                    }
                }
            }
            Platform.runLater(() -> {
                healthValue.setText("" + map.getPlayer().getHealth());
                defenceValue.setText("" + map.getPlayer().getDefence());
                attackValue.setText("" + map.getPlayer().getAttack());
                expValue.setText("" + map.getPlayer().getExp());
            });

    }

    public void handleGameStart(WindowEvent windowEvent) {
        refresh();
        refreshMonster();

        Scene scene = canvas.getScene();
        // System.out.println(scene);
        scene.getRoot().requestFocus();
        scene.setOnKeyPressed(this::onKeyPressed);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                refreshMonster();
            }
        }, 0, 700);

//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                refresCoin();
//            }
//        }, 0, 300);



    }
    private void refresCoin() {
        System.out.println("test drugiego timera");
    }
}

