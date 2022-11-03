/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Game;
import java.util.List;
import Models.Question;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Game getGame(){
        return game;
    }
    
    public String[] getSourcesInDatabase(){
        String[] sources;
        List<Question> questions = _context.Question.getAll();
        
        Map<String, List<Question>> questionMap =
            questions.stream().collect(Collectors.groupingBy(q->q.getSource()));
        
        sources = questionMap.keySet().toArray(new String[0]);
        return sources;
    }
    
    public String[] getCategoriesBySourcesInDatabase(){
        if(game.getSources() == null){
            System.out.print("Nincsen kiválasztott forrás");
            throw null;
        }
    
        String[] sources = ConverterHelper.convertSeparatedStringToStringArray(game.getSources());
        String[] categories;

        List<Question> questions = _context.Question.getAll();
        questions = questions.stream().filter(
                q -> Arrays.stream(sources).anyMatch(q.getSource()::contains)
        ).toList();
        
        Map<String, List<Question>> questionMap =
            questions.stream().collect(Collectors.groupingBy(q->q.getCategory()));
        
        categories = questionMap.keySet().toArray(new String[0]);
        
        return categories; 
    }
    
    
    public void setChosenSources(String[] sources){
        if(sources.length == 0) {
            System.out.print("Nem választottál kategóriát!");
            return;
        }
        game.setSources(ConverterHelper.convertStringArrayToSeparatedString(sources));
        
    }
    
    public void setChosenCategories(String[] categories){
        game.setCategories(ConverterHelper.convertStringArrayToSeparatedString(categories));       
    }
    
    public void setChosenName(String name){
        game.setGameName(name);
    }
    
    public void generateGame(String name)
    {
        setChosenName(name);
        Date todayDate = new Date();
        game.setCreationDate(new java.sql.Date(todayDate.getTime()));
        
        _context.Game.add(game);
        refreshGame();
        
        Game testgame = _context.Game.getAll().get(0);
//        System.out.println(game.getGameName());
//        System.out.println(game.getCreationDate());
//        System.out.println(game.getSources());
//        System.out.println(game.getCategories());
    }
    
    private void refreshGame()
    {
        List<Game> games = _context.Game.getAll();
        game = games.get(games.size()-1);
    }
}
