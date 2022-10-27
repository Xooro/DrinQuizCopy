/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebHandlers;

import Models.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */
public class WebHandler {
    public void importNapikvizToDatabase() throws IOException
    {
        Web_NapiKvizHandler napiKvizHandler = new Web_NapiKvizHandler("NapiKvíz","ISO8859_1");
        List<Question> quizes = new ArrayList<>();
            
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem", "Történelem"));
        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=foldrajz", "Földrajz"));
        
        
        //DEBUG-------------------------
//        for(int i=0;i<quizes.size();++i)
//        {
//            System.out.println("ID:        | " + quizes.get(i).getID());
//            System.out.println("Question:  | " + quizes.get(i).getQuestion());
//            System.out.println("Answers:   | " + quizes.get(i).getAnswers());
//            System.out.println("RAnswerID: | " + quizes.get(i).getRightAnswerID());
//            System.out.println("Category:  | " + quizes.get(i).getCategory());
//            System.out.println("Source:    | " + quizes.get(i).getSource());
//            System.out.println("\n");
//            
//        }
        //DEBUG.END---------------------
    } 
}
