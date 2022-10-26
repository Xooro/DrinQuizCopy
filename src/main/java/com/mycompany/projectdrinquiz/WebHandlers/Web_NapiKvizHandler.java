/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrinquiz.WebHandlers;

import com.mycompany.projectdrinquiz.WebHandlers.Base.BaseWebHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author kkris
 */
public class Web_NapiKvizHandler extends BaseWebHandler {

    public Web_NapiKvizHandler(String source, String encoding) {
        super(source, encoding);
    }

    @Override
    protected List<String> convertWebPageStringToList(String htmlDataString) {
        
        String[] htmlDataSeparated = htmlDataString.split("<br>");
        List<String> htmlAnswers = new ArrayList<String>();
        List<String> htmlQuestions = new ArrayList<String>();
        List<Integer> htmlRightAnswerID = new ArrayList<Integer>();
                  
//        List<Question> questions = new ArrayList<Question>();
        
        for (int i=0; i<htmlDataSeparated.length;++i)
        {
            if(htmlDataSeparated[i].contains("laszok: ") 
                    && htmlDataSeparated[i].chars().filter(ch -> ch == ',').count()==2 )
                {
                    htmlQuestions.add(htmlDataSeparated[i - 1]);
                    var htmlAnswersRow = htmlDataSeparated[i].split(". Megoldás:");
                    htmlAnswers.add(htmlAnswersRow[0].replace(",",separator).replace("Válaszok:",""));
                    htmlRightAnswerID.add(Arrays.asList(htmlAnswers.get(htmlAnswers.size()-1).split(separator)).indexOf(htmlAnswersRow[1]));
                    
                    //DEBUG------------
//                    System.out.println(htmlDataSeparated[i]);

//                    System.out.println("Question:        "+htmlQuestions.get(htmlQuestions.size()-1 ));
//                    System.out.println("Answers:         "+htmlAnswers.get(htmlAnswers.size()-1 ));
//                    System.out.println("Right Answer ID: "+htmlRightAnswerID.get(htmlRightAnswerID.size()-1 ));
//                    System.out.println("\n");
                    //DEBUG.END--------
                    
                    //lists to questions here
                }
        }
        
//        return questions;
        return null;
    }
    
}
