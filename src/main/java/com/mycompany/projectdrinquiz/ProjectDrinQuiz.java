/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.projectdrinquiz;

import Helpers.UserProperties;
import Views.JFrameMain;
import javax.swing.SwingUtilities;

/**
 *
 * @author kkris
 */

//Program inditó függvénye
public class ProjectDrinQuiz {

    public static void main(String[] args) {
        UserProperties.userPropertiesInstance = new UserProperties();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameMain.main(new String[]{});
            }
        });
    }
}
