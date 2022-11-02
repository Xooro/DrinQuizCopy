/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Views.HostJPanels.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jani
 */
public class Settings {

    JPanelBackGround backGround;
    JPanelSettings settings;

    public Settings() {
        backGround = new JPanelBackGround();
        backGround.setBounds(0, 0, 800, 600);

        settings = new JPanelSettings();
        settings.setBounds(0, 0, 800, 600);
        settings.setOpaque(false);

        JFrame frame = new JFrame("Host View");
        ImageIcon icon = new ImageIcon(".//resources/images/icon.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(816, 639));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(settings);
        frame.getContentPane().add(backGround);
    }
}
