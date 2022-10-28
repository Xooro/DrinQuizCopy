/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.ModelServices;

import Data.ModelServices.Base.BaseModelService;
import Models.Question;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author kkris
 */
public class QuestionModelService extends BaseModelService {

    @Override
    public void add(Object modelToAdd) {
        Question questionToAdd = (Question) modelToAdd;

        String sql = "INSERT INTO Question(question, answers, rightAnswerID, category, source) VALUES(?,?,?,?,?)";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, questionToAdd.getQuestion());
            pstmt.setString(2, questionToAdd.getAnswers());
            pstmt.setInt(3, questionToAdd.getRightAnswerID());
            pstmt.setString(4, questionToAdd.getCategory());
            pstmt.setString(5, questionToAdd.getSource());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void update(Object modelToUpdate) {
        Question questionToUpdate = (Question) modelToUpdate;

        String sql = "UPDATE Question SET question = ? , "
                + "answers = ? "
                + "rightAnswerId= ? "
                + "category = ? "
                + "source = ? "
                + "WHERE id = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, questionToUpdate.getQuestion());
            pstmt.setString(2, questionToUpdate.getAnswers());
            pstmt.setInt(3, questionToUpdate.getRightAnswerID());
            pstmt.setString(4, questionToUpdate.getCategory());
            pstmt.setString(5, questionToUpdate.getSource());
            pstmt.setInt(6, questionToUpdate.getID());
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Object modelToRemove) {
        Question questionToRemove = (Question) modelToRemove;

        String sql = "DELETE FROM Question WHERE ID = ?";

        try ( Connection conn = connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, questionToRemove.getID());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        @Override
        public List<Object> getAll() {
        String sql = "SELECT * FROM Question";
        List<Object> questionList = new ArrayList<Object>(); 
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
