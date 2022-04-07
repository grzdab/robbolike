package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.model.GameState;
import com.codecool.dungeoncrawl.model.InventoryModel;
import com.codecool.dungeoncrawl.model.PlayerModel;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;

public class GameDatabaseManager {
    private static PlayerDao playerDao;
    private static GameStateDao gameStateDao;
    private static InventoryDao inventoryDao;

    public static void setup() throws SQLException {
        DataSource dataSource = connect();
        playerDao = new PlayerDaoJdbc(dataSource);
        gameStateDao = new GameStateDaoJdbc(dataSource);
        inventoryDao = new InventoryDaoJdbc(dataSource);
    }

    public static void savePlayer(Player player) {
        PlayerModel model = new PlayerModel(player);
        playerDao.add(model);
    }

    public static void saveMap(String mapString) {
        gameStateDao.add(new GameState(mapString, new Date(Instant.now().toEpochMilli()), null));
    }

    public static void saveInventory(Player player){
        InventoryModel model = new InventoryModel(player.getInventory().getInventory(), player.getPlayerId());
        inventoryDao.add(model);
    }

    public static PlayerModel getPlayer(int id){
        return playerDao.get(id);
    }
    public static GameState getMap(int id){return gameStateDao.get(id);}
    public static InventoryModel getInventory(int id) {return inventoryDao.get(id);}

    public static void updatePlayer(Player player){
        PlayerModel model = new PlayerModel(player);
        playerDao.update(model);
    }
    public static void updateMap(String mapString){
        gameStateDao.update(new GameState(mapString, new Date(Instant.now().toEpochMilli()), null));
    }
    public static void updateInvenotry(Player player){
        InventoryModel model = new InventoryModel(player.getInventory().getInventory(), player.getPlayerId());
        inventoryDao.update(model);
    }




    private static DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = "robbo";
        String user = "postgres";
        //String password = "Odrodzenia33";
        String password = "postgres";

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setPortNumbers(new int[]{5433});

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }
}