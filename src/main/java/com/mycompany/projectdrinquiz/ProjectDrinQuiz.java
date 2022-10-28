/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import WebHandlers.WebHandler;
import Data.DrinQuizContext;
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

////        DEPENDENCY INJECTION TEST
//        DrinQuizContext _context = new DrinQuizContext();
//        Question question = new Question(0,"testQuestion", "testAnswers", 0, "testCategory", "testSource");
//        Question question1 = new Question(0,"testQuestion1", "testAnswers1", 01, "testCategory1", "testSource1");
//        
//        List<Object> lst = new ArrayList<Object>();
//        lst.add(question);
//        lst.add(question1);
//        
//        _context.Question.addRange(lst);
//          List<Question> lst = _context.Question.getAll();
//          for(int i=0;i<lst.size();++i)
//          {
//              System.out.println(lst.get(i).getQuestion());
//              System.out.println(lst.get(i).getAnswers());
//          }
          

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HostJFrame hostJFrame = new HostJFrame();
                hostJFrame.setVisible(true);
            }
        });
    }
}
