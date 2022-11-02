/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Game;
import java.util.List;
import static Helpers.ConverterHelper.convertSeparatedStringToStringArray;
import static Helpers.ConverterHelper.convertStringArrayToSeparatedString;
import Models.Question;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author akile
 */
public class GameGenerator {
    private DrinQuizContext _context;
    private Game game;
    
    public GameGenerator(){
        game = new Game();
        _context = new DrinQuizContext();
    }
    
    public void setChosenSources(String[] sources){
        if(sources.length == 0) {
            System.out.print("Nem választottál kategóriát!");
            return;
        }
        game.setSources(convertStringArrayToSeparatedString(sources));
        
    }
    public void setChosenCategories(String[] categories){
        game.setCategories(convertStringArrayToSeparatedString(categories));       
    }
    
    public String[] getSourcesCategories(){
        if(game.getSources() == null){
            System.out.print("Nincsen kiválasztott forrás");
            throw null;
        }
//        List<Question> questions = _context.Question.getAll();
//        Map<String, Map<Integer, List<Question>>> map = questions.stream()
//        .collect(Collectors.groupingBy(e -> YearMonth.from(e.getWhen()),
//                    Collectors.groupingBy(x -> x.getWhat(), Collectors.counting()))
//                   );
//        String[] sources;
//        List<String> categories;
//        List<Question> questions = _context.Question.getAll();
//        
//        for(Question question : questions){ 
//            for(int i = 0; i < sources.length;++i){
//                if(question.getSource().contains(sources[i])) 
//                    categories.add(question.getCategory());
//            }
//        }
//        
//        questions.stream().filter(q -> q.getSource().);
        
        return null;
        
    }
}
