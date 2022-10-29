/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.ModelServices;

import Data.ModelServices.Base.BaseModelService;
import Models.Game;
import Models.Question;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akile
 */
public class GameModelService extends BaseModelService<Game> {

    public void addRange(List<Game> gamesToAdd) {

        String sql = "INSERT INTO Game(gameName,creationDate) VALUES(?,?)";
        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Game gameToAdd : gamesToAdd) {

                pstmt.setString(1, gameToAdd.getGameName());
                pstmt.setDate(2, gameToAdd.getCreationDate());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == gamesToAdd.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateRange(List<Game> gamesToUpdate) {

        String sql = "UPDATE Game SET gameName = ? , "
                + "creationDate = ? "
                + "WHERE id = ?";
        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Game gameToUpdate : gamesToUpdate) {

                // set the corresponding param
                pstmt.setString(1, gameToUpdate.getGameName());
                pstmt.setDate(2, gameToUpdate.getCreationDate());
                pstmt.setInt(3, gameToUpdate.getID());
                // update 
                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == gamesToUpdate.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeRange(List<Game> gamesToRemove) {

        String sql = "DELETE FROM Game WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Game gameToRemove : gamesToRemove) {

                // set the corresponding param
                pstmt.setInt(1, gameToRemove.getID());
                // execute the delete statement
                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == gamesToRemove.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Game> getAll() {
        String sql = "SELECT * FROM Game";
        List<Game> gameList = new ArrayList<Game>();
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Game game = new Game();

                game.setID(rs.getInt("id"));
                game.setGameName(rs.getString("gameName"));
                game.setCreationDate(rs.getDate("creationDate"));

                gameList.add(game);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gameList;
    }
}
