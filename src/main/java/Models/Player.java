/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author kkris
 */
public class Player {
    private int id;
    private int gameID;
    private String playerName;
    private int score;

    
    //GETTERS
    public int getID() {
        return id;
    }
    
    public int getGameID() {
        return gameID;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public int getScore() {
        return score;
    }
    
    
    //SETTERS
    public void setID(int newId) {
        id = newId;
    }
    
    public void setGameID(int newGameID) {
        gameID = newGameID;
    }
    
    public void setPlayerName(String newPlayerName) {
        playerName = newPlayerName;
    }
    
    public void setScore(int newScore) {
        score = newScore;
    }
}
