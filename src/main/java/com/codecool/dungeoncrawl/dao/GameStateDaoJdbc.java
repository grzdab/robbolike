package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.GameState;
import com.codecool.dungeoncrawl.model.PlayerModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameStateDaoJdbc implements GameStateDao {

    private DataSource dataSource;

    public GameStateDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(GameState state) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO game_state (current_map, saved_at, player_id) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, state.getCurrentMap());
            statement.setDate(2, state.getSavedAt());
//            statement.setInt(3, state.getPlayer().getId());
            statement.setInt(3, 1);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            state.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(GameState state) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE game_state " +
                    "SET current_map = ?,  saved_at = ?" +
                    "WHERE player_id  = ?;";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, state.getCurrentMap());
            statement.setDate(2, state.getSavedAt());
//            statement.setInt(3, state.getPlayer().getId());
            statement.setInt(3, 1);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            String sql2 = "SELECT id FROM game_state WHERE player_id = ?";
            PreparedStatement st = conn.prepareStatement(sql2);
            st.setInt(1, 1);
            ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                // Error
                throw new RuntimeException("Error in ResultSet in GamStateJdbC in 58 line or so");
            }
            state.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GameState get(int id) {
        String current_map = "";
//        Date saved_at = null;
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT current_map FROM game_state WHERE player_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                current_map = resultSet.getString("current_map");
//                saved_at = resultSet.getDate("saved_at");
            }
        } catch (SQLException e) {
            return null;
        }
        return new GameState(current_map);
    }


    @Override
    public List<GameState> getAll() {return null;}

}