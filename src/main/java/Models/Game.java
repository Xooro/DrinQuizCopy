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
    private LocalDateTime creationDate;

    
    //GETTERS
    public int getID() {
        return id;
    }
        
    public String getGameName() {
        return gameName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    
    //SETTERS
    public void setID(int newId) {
        id = newId;
    }

    public void setGameName(String newGameName) {
        gameName = newGameName;
    }

    public void setCreationDate(LocalDateTime newCreationDate) {
        creationDate = newCreationDate;
    }
}
