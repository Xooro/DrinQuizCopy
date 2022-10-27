/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author kkris
 */
public class Question {

    private int id;
    private String question;
    private String answers;
    private int rightAnswerID;
    private String category;
    private String source;

    
    //GETTERS
    public int getID() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswers() {
        return answers;
    }

    public int getRightAnswerID() {
        return rightAnswerID;
    }

    public String getCategory() {
        return category;
    }

    public String getSource() {
        return source;
    }

    
    //SETTERS
    public void setID(int newId) {
        id = newId;
    }

    public void setQuestion(String newQuestion) {
        question = newQuestion;
    }

    public void setAnswers(String newAnswers) {
        answers = newAnswers;
    }

    public void setRightAnswerID(int newRightAnswerID) {
        rightAnswerID = newRightAnswerID;
    }

    public void setCategory(String newCategory) {
        category = newCategory;
    }

    public void setSource(String newSource) {
        source = newSource;
    }
}
