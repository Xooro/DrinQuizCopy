/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Enums.Categories;
import Models.Enums.Sources;
import Models.Question;
import Helpers.WebHandlers.NapiKvizWebHandler;
import Models.Game;
import Models.Player;
import Models.QuestionHistory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */
public class DatabaseHandler {

    private DrinQuizContext _context;

    public DatabaseHandler() {
        _context = new DrinQuizContext();
    }

    public void importAllKvizToDatabase() throws IOException
    {
        importNapikvizToDatabase();
    }
    
    public void importNapikvizToDatabase() throws IOException {
        NapiKvizWebHandler napiKvizHandler = new NapiKvizWebHandler(Sources.NapiKvíz, "ISO8859_1");
        List<Question> quizes = new ArrayList<>();
//
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem", Categories.Történelem));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=foldrajz", Categories.Földrajz));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=bulvar", Categories.Bulvár));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=elovilag", Categories.Élővilág));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=zene", Categories.Zene));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=sport", Categories.Sport));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=film-szinhaz", Categories.Film_színház));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=kepzomuveszet", Categories.Képzőművészet)); 
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=irodalom", Categories.Irodalom));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=etelek-italok", Categories.Ételek_italok));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=unnepek", Categories.Ünnepek));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=csillagaszat", Categories.Csillagászat));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tv-sorozatok", Categories.Tv_sorozatok));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=kozlekedes,_jarmuvek", Categories.Közlekedés_járművek));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=szolasok-kozmondasok", Categories.Szólások_közmondások));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=egyeb", Categories.Egyéb));
       _context.Question.addRange(quizes);

//        List<Question> testlist = _context.Question.getAll();
//        for (Question q : testlist) {
//            System.out.println("ID:        | " + q.getID());
//            System.out.println("Question:  | " + q.getQuestion());
//            System.out.println("Answers:   | " + q.getAnswers());
//            System.out.println("RAnswerID: | " + q.getRightAnswerID());
//            System.out.println("Category:  | " + q.getCategory());
//            System.out.println("Source:    | " + q.getSource());
//            System.out.println("\n");
//        }
    }
    
    public void deleteGameInDatabase(Game game)
    {
        List<Player> players = _context.Player.getAll();
        List<QuestionHistory> questionHistories = _context.QuestionHistory.getAll();
        players = players.stream().filter(p -> p.getGameID() == game.getID()).toList();
        questionHistories = questionHistories.stream().filter(q -> q.getGameID() == game.getID()).toList();
        
        _context.QuestionHistory.removeRange(questionHistories);
        _context.Player.removeRange(players);
        _context.Game.remove(game);
    }
    
    public void clearQuestionsInDatabase()
    {    
        clearGamesInDatabase();     
        _context.Question.clear();
    }
    
    public void clearGamesInDatabase()
    {
        _context.QuestionHistory.clear();
        _context.Game.clear();
        _context.Player.clear();
    }
}
