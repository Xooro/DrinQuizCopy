/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author akile
 */
public class QuestionHistory {

    private int id;
    private int gameID;
    private int playerID;
    private int questionID;
    private int pickedAnswer;

    public QuestionHistory(){};
    public QuestionHistory(int id, int gameID, int playerID, int questionID, int pickedAnswer)
    {
        this.id = id;
        this.gameID = gameID;
        this.playerID = playerID;
        this.questionID = questionID;
        this.pickedAnswer = pickedAnswer;
    }
    
    //GETTERS
    public int getID() {
        return id;
    }

    public int getGameID() {
        return gameID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public int getPickedAnswer() {
        return pickedAnswer;
    }

    //SETTERS
    public void setID(int newID) {
        id = newID;
    }

    public void setGameID(int newGameID) {
        gameID = newGameID;
    }

    public void setPlayerID(int newPlayerID) {
        playerID = newPlayerID;
    }

    public void setQuestionID(int newQuestionID) {
        questionID = newQuestionID;
    }

    public void setPickedAnswer(int newPickedAnswer) {
        pickedAnswer = newPickedAnswer;
    }
}