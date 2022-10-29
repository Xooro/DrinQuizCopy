/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ModelServices;

import Models.ModelServices.Base.BaseModelService;
import Models.QuestionHistory;
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
public class QuestionHistoryModelService extends BaseModelService<QuestionHistory> {
//    private int id;
//    private int gameID;
//    private int playerID;
//    private int questionID;
//    private int pickedAnswer;

    public void addRange(List<QuestionHistory> questionHistoriesToAdd) {

        String sql = "INSERT INTO QuestionHistory(gameID,playerID,questionID,pickedAnswer) VALUES(?,?,?,?)";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (QuestionHistory questionHistoryToAdd : questionHistoriesToAdd) {
                pstmt.setInt(1, questionHistoryToAdd.getGameID());
                pstmt.setInt(2, questionHistoryToAdd.getPlayerID());
                pstmt.setInt(3, questionHistoryToAdd.getQuestionID());
                pstmt.setInt(4, questionHistoryToAdd.getPickedAnswer());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionHistoriesToAdd.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRange(List<QuestionHistory> questionHistoriesToUpdate) {

        String sql = "UPDATE QuestionHistory SET gameID = ? , "
                + "playerID = ?, "
                + "questionID = ?, "
                + "pickedAnswer = ? "
                + "WHERE id = ?";
        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (QuestionHistory questionHistoryToUpdate : questionHistoriesToUpdate) {

                // set the corresponding param
                pstmt.setInt(1, questionHistoryToUpdate.getGameID());
                pstmt.setInt(2, questionHistoryToUpdate.getPlayerID());
                pstmt.setInt(3, questionHistoryToUpdate.getQuestionID());
                pstmt.setInt(4, questionHistoryToUpdate.getPickedAnswer());
                pstmt.setInt(5, questionHistoryToUpdate.getID());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionHistoriesToUpdate.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeRange(List<QuestionHistory> questionHistoriesToRemove) {

        String sql = "DELETE FROM QuestionHistory WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (QuestionHistory questionHistoryToRemove : questionHistoriesToRemove) {
                pstmt.setInt(1, questionHistoryToRemove.getID());
                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionHistoriesToRemove.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }        
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<QuestionHistory> getAll() {
        String sql = "SELECT * FROM QuestionHistory";
        List<QuestionHistory> questionHistoryList = new ArrayList<QuestionHistory>();
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                QuestionHistory questionHistory = new QuestionHistory();

                questionHistory.setID(rs.getInt("id"));
                questionHistory.setGameID(rs.getInt("gameID"));
                questionHistory.setQuestionID(rs.getInt("questionID"));
                questionHistory.setPickedAnswer(rs.getInt("pickedAnswer"));

                questionHistoryList.add(questionHistory);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return questionHistoryList;
    }
}
