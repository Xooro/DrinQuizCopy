/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ModelServices.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */

//Absztrakt osztály CRUD alapjait valósítja meg
public abstract class BaseModelService<T> {
    public abstract void addRange(List<T> modelsToAdd);
    public abstract void updateRange(List<T> modelsToUpdate);
    public abstract void removeRange(List<T> modelsToRemove);
    public abstract List<T> getAll();
    
    public void add(T modelToAdd)
    {  
        List<T> soloModel = new ArrayList<T>();
        soloModel.add(modelToAdd);
        addRange(soloModel);
    }
    
    public void update(T modelToUpdate)
    {
        List<T> soloModel = new ArrayList<T>();
        soloModel.add(modelToUpdate);
        updateRange(soloModel);
    }
    
    public void remove(T modelToRemove)
    {
        List<T> soloModel = new ArrayList<T>();
        soloModel.add(modelToRemove);
        removeRange(soloModel);
    }
    
    public void clear()
    {
        removeRange(getAll());
    }
    
    protected Connection connect() {
        String url = "jdbc:sqlite:db_DrinkinQuiz.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.print("Error: " + e.getMessage());
        }
        return conn;
    }
    
}           

