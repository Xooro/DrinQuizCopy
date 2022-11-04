/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import javax.swing.JOptionPane;

/**
 *
 * @author akile
 */
public class ViewHelper {
    
    
    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "Értesítés", JOptionPane.INFORMATION_MESSAGE);
    }
}
