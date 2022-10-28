/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebHandlers;

import Data.DrinQuizContext;
import Models.Question;
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
        Web_NapiKvizHandler napiKvizHandler = new Web_NapiKvizHandler("NapiKvíz", "ISO8859_1");
        List<Question> quizes = new ArrayList<>();

        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem", "Történelem"));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=foldrajz", "Földrajz"));
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
}
