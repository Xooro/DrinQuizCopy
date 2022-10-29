/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebHandlers;

import Models.Question;
import WebHandlers.Base.BaseWebHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author kkris
 */
public class Web_NapiKvizHandler extends BaseWebHandler {

    public Web_NapiKvizHandler(String source, String encoding) {
        super(source, encoding);
    }

    @Override
    protected List<Question> convertWebPageStringArrayToQuestionList(String[] htmlDataSeparated, String category) {

        List<Question> questions = new ArrayList<Question>();

        for (int i = 0; i < htmlDataSeparated.length; ++i) {
            if (htmlDataSeparated[i].contains("laszok: ")
                    && htmlDataSeparated[i].chars().filter(ch -> ch == ',').count() == 2) {

                String htmlQuestion = htmlDataSeparated[i - 1];
                String[] htmlAnswersRow = htmlDataSeparated[i].split(". Megoldás:");
                String htmlAnswers = htmlAnswersRow[0].replace(",", separator).replace("Válaszok:", "");
                int htmlRightAnswerID = Arrays.asList(htmlAnswers.split(separator)).indexOf(htmlAnswersRow[1]);

                questions.add(new Question(0,htmlQuestion,htmlAnswers,htmlRightAnswerID,category,source));
                
                //DEBUG------------
//                System.out.println(htmlDataSeparated[i]);
//                System.out.println("Question:        " + htmlQuestions);
//                System.out.println("Answers:         " + htmlAnswers);
//                System.out.println("Right Answer ID: " + htmlRightAnswerID);
//                System.out.println("\n");
                //DEBUG.END--------
                //lists to questions here
            }
        }

        return questions;
    }

}
