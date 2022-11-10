/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ModelServices;

import Models.ModelServices.Base.BaseModelService;
import Models.Question;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author kkris
 */

//CRUD QuestionHistory tábla
public class QuestionModelService extends BaseModelService<Question> {

    @Override
    public void addRange(List<Question> questionsToAdd) {

        String sql = "INSERT INTO Question(question, answers, rightAnswerID, category, source) VALUES(?,?,?,?,?)";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Question questionToAdd : questionsToAdd) {
                pstmt.setString(1, questionToAdd.getQuestion());
                pstmt.setString(2, questionToAdd.getAnswers());
                pstmt.setInt(3, questionToAdd.getRightAnswerID());
                pstmt.setString(4, questionToAdd.getCategory());
                pstmt.setString(5, questionToAdd.getSource());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionsToAdd.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRange(List<Question> questionsToUpdate) {

        String sql = "UPDATE Question SET question = ? , "
                + "answers = ? "
                + "rightAnswerId= ? "
                + "category = ? "
                + "source = ? "
                + "WHERE id = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Question questionToUpdate : questionsToUpdate) {
                pstmt.setString(1, questionToUpdate.getQuestion());
                pstmt.setString(2, questionToUpdate.getAnswers());
                pstmt.setInt(3, questionToUpdate.getRightAnswerID());
                pstmt.setString(4, questionToUpdate.getCategory());
                pstmt.setString(5, questionToUpdate.getSource());
                pstmt.setInt(6, questionToUpdate.getID());

                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionsToUpdate.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeRange(List<Question> questionsToRemove) {

        String sql = "DELETE FROM Question WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int index = 0;
            for (Question questionToRemove : questionsToRemove) {
                pstmt.setInt(1, questionToRemove.getID());
                pstmt.addBatch();
                index++;

                if (index % 1000 == 0 || index == questionsToRemove.size()) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Question> getAll() {
        String sql = "SELECT * FROM Question";
        List<Question> questionList = new ArrayList<Question>();
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                Question question = new Question();

                question.setID(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setAnswers(rs.getString("answers"));
                question.setRightAnswerID(rs.getInt("rightAnswerID"));
                question.setCategory(rs.getString("category"));
                question.setSource(rs.getString("source"));

                questionList.add(question);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return questionList;
    }
}
