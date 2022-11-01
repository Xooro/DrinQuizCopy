/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Question;
import Models.QuestionHistory;
import java.util.List;
import java.util.Random;

/**
 *
 * @author akile
 */
public class GameHandler {
   private DrinQuizContext _context;
   private int gameID;
   
   public GameHandler(int gameID){
       this.gameID = gameID; 
       _context = new DrinQuizContext();
   }
   
   
   public Question getNewQuestion(){
       List<Question> questions = _context.Question.getAll();
       Question question;
               
       Random rnd = new Random();
       
       do{
           question = questions.get(rnd.nextInt(questions.size()));
       }while(isQuestionUsed(question));
       
       return question;
   }
   
   
   private Boolean isQuestionUsed(Question question){
       List<QuestionHistory> usedQuestions = _context.QuestionHistory.getAll();
       for(QuestionHistory usedQuestion : usedQuestions){
           if(usedQuestion.getQuestionID() == question.getID() && usedQuestion.getGameID() ==  gameID){
               return true;
           }
       }       
       return false;
   } 
   
   public String[] getAnswersSeparated(String answerBlock){
       String[] answers = answerBlock.split(";;SEP;;");
       
       return answers;
   } 
//   public void giveAnswersToButtons(){}
}
