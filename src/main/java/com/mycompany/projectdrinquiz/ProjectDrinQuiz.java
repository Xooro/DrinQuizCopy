/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import WebHandlers.WebHandler;
import Data.DrinQuizContext;
import Models.Question;
import java.io.IOException;
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

        //DEPENDENCY INJECTION TEST
//        DrinQuizContext _context = new DrinQuizContext();
//        Question question = new Question();
//        question.setQuestion("TestQuestion");
//        _context.Question.add(question);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HostJFrame hostJFrame = new HostJFrame();
                hostJFrame.setVisible(true);
            }
        });
    }
}
