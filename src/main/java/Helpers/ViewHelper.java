/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author akile
 */

//UI segédlet
public class ViewHelper {

    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, "A nap értesítése", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void scaleImageInLabel(String path, JLabel label) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }

    public static void switchPanelView(JPanel oldPanel, JPanel newPanel) {
        oldPanel.setVisible(false);
        newPanel.setVisible(true);
    }
}
