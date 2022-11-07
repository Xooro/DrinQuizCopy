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
    private int cupsLeft;
    private int refillsLeft;
    private boolean isHalfingUsed;
    

    public Player(){}
    
    public Player(int id, int gameID, String playerName, int score, int cupsLeft, int refillsLeft, boolean isHalfingUsed){
        this.id = id;
        this.gameID = gameID;
        this.playerName = playerName;
        this.score = score;
        this.cupsLeft = cupsLeft;
        this.refillsLeft = refillsLeft;
        this.isHalfingUsed = isHalfingUsed;
    }
    
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
    public int getCupsLeft() {
        return cupsLeft;
    }
    public int getRefillsLeft() {
        return refillsLeft;
    }
    public boolean getIsHalfingUsed(){
        return isHalfingUsed;
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
    public void setCupsLeft(int newCupsLeft) {
        cupsLeft = newCupsLeft;
    }
    public void setRefillsLeft(int newRefillsLeft) {
        refillsLeft = newRefillsLeft;
    }
    public void setIsHalfingUsed(boolean  newIsHalfingUsed){
        isHalfingUsed = newIsHalfingUsed;
    }
}
