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
    
    
    public void add(Game gameToAdd) {

        String sql = "INSERT INTO Game(gameName,creationDate) VALUES(?,?)";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gameToAdd.getGameName());
            pstmt.setDate(2, gameToAdd.getCreationDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void update(Game gameToUpdate) {

        String sql = "UPDATE Game SET gameName = ? , "
                + "creationDate = ? "
                + "WHERE id = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, gameToUpdate.getGameName());
            pstmt.setDate(2, gameToUpdate.getCreationDate());
            pstmt.setInt(3, gameToUpdate.getID());
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Game gameToRemove) {

        String sql = "DELETE FROM Game WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, gameToRemove.getID());
            // execute the delete statement
            pstmt.executeUpdate();

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