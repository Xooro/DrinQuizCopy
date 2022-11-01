/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import Helpers.WebHandler;
import Data.DrinQuizContext;
import Helpers.GameHandler;
import Models.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import userInterface.HostJFrame;

/**
 *
 * @author kkris
 */
public class ProjectDrinQuiz {

    public static void main(String[] args)
            throws IOException {

        //WEBHANDLER TEST
//        WebHandler webHandler = new WebHandler();
//        webHandler.importNapikvizToDatabase();

//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                HostJFrame hostJFrame = new HostJFrame();
//                hostJFrame.setVisible(true);
//            }
//        });

        GameHandler game = new GameHandler(1);
        
        Question question = game.getNewQuestion();
        
        String[] test = game.getAnswersSeparated(question.getAnswers());
        
        System.out.print(test[0] + test[1] + test[2]);
        
    }
}
