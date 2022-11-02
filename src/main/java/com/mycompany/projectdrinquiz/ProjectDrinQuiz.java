/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import Helpers.WebHandler;
import java.io.IOException;
import javax.swing.SwingUtilities;
import userInterface.hostFrame;

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

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                hostFrame hostJFrame = new hostFrame();
                hostJFrame.setVisible(true);
            }
        });

    }
}
