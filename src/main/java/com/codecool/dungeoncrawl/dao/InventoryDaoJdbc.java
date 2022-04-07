package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.model.InventoryModel;
import com.codecool.dungeoncrawl.model.PlayerModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class InventoryDaoJdbc implements InventoryDao {
    private DataSource dataSource;

    public  InventoryDaoJdbc(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void add(InventoryModel inventory) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO inventory (breastplate, coin, helmet, key, nut, resistor, shield, screwdriver, spring, taser, wrench) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, inventory.getBreastplate());
            statement.setInt(2, inventory.getCoin());
            statement.setInt(3, inventory.getHelmet());
            statement.setInt(4, inventory.getKey());
            statement.setInt(5, inventory.getNut());
            statement.setInt(6, inventory.getResistor());
            statement.setInt(7, inventory.getShield());
            statement.setInt(8, inventory.getScrewdriver());
            statement.setInt(9, inventory.getSpring());
            statement.setInt(10, inventory.getTaser());
            statement.setInt(11, inventory.getWrench());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            inventory.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(InventoryModel inventory) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE inventory " +
                    "SET breastplate = ?, coin = ?, helmet = ?, key = ?, nut = ?, resistor = ?, shield = ?, " +
                    "screwdriver = ?, spring = ?, taser = ?, wrench = ?" +
                    "WHERE player_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, inventory.getBreastplate());
            statement.setInt(2, inventory.getCoin());
            statement.setInt(3, inventory.getHelmet());
            statement.setInt(4, inventory.getKey());
            statement.setInt(5, inventory.getNut());
            statement.setInt(6, inventory.getResistor());
            statement.setInt(7, inventory.getShield());
            statement.setInt(8, inventory.getScrewdriver());
            statement.setInt(9, inventory.getSpring());
            statement.setInt(10, inventory.getTaser());
            statement.setInt(11, inventory.getWrench());
            statement.setInt(12, inventory.getPlayer_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            inventory.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InventoryModel get(int id) {

        int player_id = 0;
        int breastplate = 0, coin = 0, helmet = 0, key = 0, nut = 0, resistor = 0, shield = 0, screwdriver = 0,
                spring = 0, taser = 0, wrench = 0;
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT breastplate, coin, helmet, key, nut, resistor, shield, screwdriver, spring, taser, wrench " +
                    "FROM inventory where player_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                breastplate = resultSet.getInt("breastplate");
                coin = resultSet.getInt("coin");
                helmet = resultSet.getInt("helmet");
                key = resultSet.getInt("key");
                nut = resultSet.getInt("nut");
                resistor = resultSet.getInt("resistor");
                shield = resultSet.getInt("shield");
                screwdriver = resultSet.getInt("screwdriver");
                spring = resultSet.getInt("spring");
                taser = resultSet.getInt("taser");
                wrench = resultSet.getInt("wrench");
            }
        } catch (SQLException e) {
            return null;
        }

        return new InventoryModel(player_id, breastplate, coin, helmet, key, nut, resistor, shield, screwdriver, spring, taser, wrench);
    }
    @Override
    public List<InventoryModel> getAll() {
        return null;
    }
}
