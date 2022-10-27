/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import com.mycompany.projectdrinquiz.WebHandlers.WebHandler;
import java.io.IOException;
import javax.swing.SwingUtilities;
import userInterface.HostJFrame;

/**
 *
 * @author kkris
 */
public class ProjectDrinQuiz {

    public static void main(String[] args) throws IOException {
//        WebHandler webHandler = new WebHandler();
//        webHandler.importNapikvizToDatabase();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HostJFrame hostJFrame = new HostJFrame();
                hostJFrame.setVisible(true);
            }
        });
    }
}
