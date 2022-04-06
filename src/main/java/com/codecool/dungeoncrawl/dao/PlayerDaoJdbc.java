package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.PlayerModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PlayerDaoJdbc implements PlayerDao {
    private DataSource dataSource;

    public PlayerDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(PlayerModel player) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO player (player_name, hp, x, y, exp, att, def) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, player.getPlayerName());
            statement.setInt(2, player.getHp());
            statement.setInt(3, player.getX());
            statement.setInt(4, player.getY());
            statement.setInt(5, player.getExp());
            statement.setInt(6, player.getAtt());
            statement.setInt(7, player.getDef());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            player.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(PlayerModel player) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE player " +
                    "SET hp = ?,  x = ?, y = ?, exp = ?, att = ?, def = ?" +
                    "WHERE player_name = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, player.getHp());
            statement.setInt(2, player.getX());
            statement.setInt(3, player.getY());
            statement.setInt(4, player.getExp());
            statement.setInt(5, player.getAtt());
            statement.setInt(6, player.getDef());
            statement.setString(7, player.getPlayerName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
//            player.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlayerModel get(int id) {

        String playerName = "";
        int x = 0, y = 0;
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT player_name, x, y FROM player where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                playerName = resultSet.getString("player_name");
                x = resultSet.getInt("x");
                y = resultSet.getInt("y");
            }
        } catch (SQLException e) {
            return null;
        }

        return new PlayerModel(playerName, x, y);
    }


    @Override
    public List<PlayerModel> getAll() {
        List<PlayerModel> players = new LinkedList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM player";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.executeQuery();
            int id, hp, x, y, exp, att, def;
            String player_name;
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                player_name = resultSet.getString("player_name");
                hp = resultSet.getInt("hp");
                x = resultSet.getInt("x");
                y = resultSet.getInt("y");
                exp = resultSet.getInt("exp");
                att = resultSet.getInt("att");
                def = resultSet.getInt("def");
                players.add(new PlayerModel(id, player_name, x,y, hp,exp, att, def));
            }
        } catch (SQLException e) {
            return null;
        }
        return players;
    }
}
