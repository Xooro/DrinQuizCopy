/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author akile
 */
public class ViewHelper {

    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "Értesítés", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void scaleImage(String path, JLabel label) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }
}
