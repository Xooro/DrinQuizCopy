/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data.ModelServices.Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kkris
 */
public abstract class BaseModelService {
    public abstract void add(Object modelToAdd);
    public abstract void update(Object modelToUpdate);
    public abstract void remove(Object modelToRemove);
    public abstract List<Object> GetAll();
    
    public void addRange(List<Object> modelsToAdd)
    {
        for(int i=0;i<modelsToAdd.size();++i)
        {
            add(modelsToAdd.get(i));
        }
    }
    
    public void updateRange(List<Object> modelsToUpdate)
    {
        for(int i=0;i<modelsToUpdate.size();++i)
        {
            update(modelsToUpdate.get(i));
        }
    }
    
    public void removeRange(List<Object> modelsToRemove)
    {
        for(int i=0;i<modelsToRemove.size();++i)
        {
            remove(modelsToRemove.get(i));
        }
    }
    
    private Connection connect() {
        String url = "jdbc:sqlite:db_DrinkinQuiz.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.print("Error: " + e.getMessage());
        }
        
        return conn;
    }
}
