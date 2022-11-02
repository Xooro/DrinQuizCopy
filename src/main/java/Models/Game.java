/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author kkris
 */
public class Game {

    private int id;
    private String gameName;
    private Date creationDate;
    private String sources;
    private String categories;

    
    //GETTERS
    public int getID() {
        return id;
    }
        
    public String getGameName() {
        return gameName;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public String getSources() {
        return sources;
    }
    public String getCategories() {
        return categories;
    }

    
    //SETTERS
    public void setID(int newId) {
        id = newId;
    }

    public void setGameName(String newGameName) {
        gameName = newGameName;
    }

    public void setCreationDate(Date newCreationDate) {
        creationDate = newCreationDate;
    }
    public void setSources(String newSources) {
        sources = newSources;
    }
    public void setCategories(String newCategories) {
        categories = newCategories;
    }
}
