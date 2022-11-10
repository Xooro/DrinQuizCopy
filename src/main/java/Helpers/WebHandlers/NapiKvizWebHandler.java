/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.WebHandlers;

import static Helpers.ConverterHelper.SEPARATOR;
import Models.Enums.Categories;
import Models.Enums.Sources;
import Models.Question;
import Helpers.WebHandlers.Base.BaseWebHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kkris
 */

//Napikviz weboldal kvízeinek letöltését és átalakítását valósítja meg
public class NapiKvizWebHandler extends BaseWebHandler {

    public NapiKvizWebHandler(Sources source, String encoding) {
        super(source, encoding);
    }

    @Override
    protected List<Question> convertWebPageStringArrayToQuestionList(String[] htmlDataSeparated, Categories category) {

        List<Question> questions = new ArrayList<Question>();

        for (int i = 0; i < htmlDataSeparated.length; ++i) {
            if (htmlDataSeparated[i].contains("laszok: ")
                    && htmlDataSeparated[i].chars().filter(ch -> ch == ',').count() == 2) {

                String htmlQuestion = htmlDataSeparated[i - 1];
                String[] htmlAnswersRow = htmlDataSeparated[i].split(". Megoldás:");
                String htmlAnswers = htmlAnswersRow[0].replace(",", SEPARATOR).replace("Válaszok:", "");
                int htmlRightAnswerID = Arrays.asList(htmlAnswers.split(SEPARATOR)).indexOf(htmlAnswersRow[1]);
                
                questions.add(new Question(0,htmlQuestion,htmlAnswers,htmlRightAnswerID,category.toString(),source.toString()));
            }
        }

        return questions;
    }

}
