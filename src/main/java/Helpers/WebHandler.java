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
import Helpers.WebHandlers.NapiKvizWebHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */
public class WebHandler {

    private DrinQuizContext _context;

    public WebHandler() {
        _context = new DrinQuizContext();
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
        _context.Question.addRange(quizes);
        
        //VALAKI KÉSŐBB ADJA HOZZÁ NAPIKVíZ-RŐL A TÖBBI LINKET
//        quizes.addAll(napiKvizHandler.getDataFromWebpage("", Categories));

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
}
