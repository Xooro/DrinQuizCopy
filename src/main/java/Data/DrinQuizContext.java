/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Data.ModelServices.QuestionModelService;
import java.sql.*;
import java.util.*;

/**
 *
 * @author akile
 */
public class DrinQuizContext {    
    public QuestionModelService Question = new QuestionModelService();
}


/*
    String sql = "SELECT * FROM Person";

        try ( Connection conn = connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t" + rs.getString("Sex"));
            }
        } //LOOP THROUGH RESULT SET
        catch (SQLException e) {
            System.out.println("FUCK ME" + e.getMessage());
        }


    public void SelectAll() throws SQLException {
        Person person;
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM Person";

        try ( Connection conn = connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("Name") + "\t" + rs.getString("Sex"));
            }
        } //LOOP THROUGH RESULT SET
        catch (SQLException e) {
            System.out.println("FUCK ME" + e.getMessage());
        }

    }*/

/* ProjectDrinQuiz app = new ProjectDrinQuiz();
        try {
            app.SelectAll();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }*/