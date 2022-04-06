package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, SQLException {
        try {
            GameDatabaseManager.setup();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/hello.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            primaryStage.setTitle("Hello!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException exc)
        {
            // continue
        }
    }
}
