/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import Views.JFrameMain;
import java.io.IOException;
import javax.swing.SwingUtilities;

/**
 *
 * @author kkris
 */
public class ProjectDrinQuiz {

    public static void main(String[] args)
            throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                JFrameMain mainFrame = new JFrameMain();
//                mainFrame.setVisible(true);
                JFrameMain.main(new String[]{});
            }
        });
    }
}
