package com.codecool.dungeoncrawl.controllers;

import com.codecool.dungeoncrawl.Main;
import com.codecool.dungeoncrawl.Tiles;
import com.codecool.dungeoncrawl.logic.Cell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label gameTitle;

    @FXML
    protected void onHelloButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("/game-screen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Dungeon Crawl");
            stage.setScene(scene);
            GameController<Object> gameController = fxmlLoader.getController();
            stage.setOnShown(gameController::handleGameStart);
            stage.show();
            Stage oldStage = (Stage) gameTitle.getScene().getWindow();
            oldStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}