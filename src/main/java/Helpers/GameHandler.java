/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Game;
import Models.Question;
import Models.QuestionHistory;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author akile
 */
public class GameHandler {
   private DrinQuizContext _context;
   private Game game;
   
   public GameHandler(Game game){
       this.game = game; 
       _context = new DrinQuizContext();
   }
   
   
   public Question getNewQuestion() throws Exception{
       Question question = new Question();
       Random rnd = new Random();
       List<Question> questions = getFilteredQuestions();
       
       if(questions.isEmpty())
               throw new Exception("Out of questions");
       question = questions.get(rnd.nextInt(questions.size()));   
       
//       do{
//           if(questions.isEmpty()){
//               throw new Exception("Out of questions");
//           }
//           question = questions.get(rnd.nextInt(questions.size()));   
//           
//       }while(isQuestionUsed(question));
       return question;
   }
   
    private List<Question> getFilteredQuestions(){
       List<Question> questions = _context.Question.getAll();
       String[] sources = ConverterHelper.convertSeparatedStringToStringArray(game.getSources());
       String[] categories = ConverterHelper.convertSeparatedStringToStringArray(game.getCategories());
       
       questions = questions.stream().filter(
                q -> (Arrays.stream(sources).anyMatch(q.getSource()::contains)) 
                        && (Arrays.stream(categories).anyMatch(q.getCategory()::contains)) 
                        && (
                            !isQuestionUsed(q)
                        )
       ).toList();
       return questions;
    }
   
   private Boolean isQuestionUsed(Question question){
       List<QuestionHistory> usedQuestions = _context.QuestionHistory.getAll();
       for(QuestionHistory usedQuestion : usedQuestions){
           if(usedQuestion.getQuestionID() == question.getID() && usedQuestion.getGameID() ==  game.getID()){
               return true;
           }
       }       
       return false;
   } 
   
   private void addQuestionToQuestionHistory(Question question)
   {
       QuestionHistory questionHistory = new QuestionHistory(0,game.getID(),0,question.getID(),0);
       _context.QuestionHistory.add(questionHistory);
   }
}
