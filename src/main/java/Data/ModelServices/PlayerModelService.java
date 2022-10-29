/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.ModelServices;

import Data.ModelServices.Base.BaseModelService;
import Models.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akile
 */
public class PlayerModelService extends BaseModelService<Player> {

    public void addRange(List<Player> playersToAdd) {
//private int id;
//    private int gameID;
//    private String playerName;
//    private int score;
        String sql = "INSERT INTO Player(gameID,playerName, score) VALUES(?,?,?)";
        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Player playerToAdd : playersToAdd) {

                pstmt.setInt(1, playerToAdd.getGameID());
                pstmt.setString(2, playerToAdd.getPlayerName());
                pstmt.setInt(3, playerToAdd.getScore());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == playersToAdd.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateRange(List<Player> playersToUpdate) {

        String sql = "UPDATE Player SET gameID= ? , "
                + "playerName = ? , "
                + "score = ? "
                + "WHERE id = ?";
        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Player playerToUpdate : playersToUpdate) {

                // set the corresponding param
                pstmt.setInt(1, playerToUpdate.getGameID());
                pstmt.setString(2, playerToUpdate.getPlayerName());
                pstmt.setInt(3, playerToUpdate.getScore());
                pstmt.setInt(4, playerToUpdate.getID());
                // update 
                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == playersToUpdate.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeRange(List<Player> playersToRemove) {

        String sql = "DELETE FROM player WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Player playerToRemove : playersToRemove) {
                // set the corresponding param
                pstmt.setInt(1, playerToRemove.getID());
                // execute the delete statement
                pstmt.addBatch();
                index++;
                if (index % 1000 == 0 || index == playersToRemove.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Player> getAll() {
        String sql = "SELECT * FROM Player";
        List<Player> playerList = new ArrayList<Player>();
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Player player = new Player();

                player.setID(rs.getInt("id"));
                player.setGameID(rs.getInt("gameID"));
                player.setPlayerName(rs.getString("playerName"));
                player.setScore(rs.getInt("score"));

                playerList.add(player);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return playerList;
    }
}
