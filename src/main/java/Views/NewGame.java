/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Views.HostJPanels.*;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Jani
 */
public class NewGame {

    JPanelBackGround backGround;
    JPanelSources sources;
    JPanelCategories categories;
    JPanelGameName gameName;

    public NewGame() {
        backGround = new JPanelBackGround();
        backGround.setBounds(0, 0, 800, 600);

        sources = new JPanelSources();
        sources.setBounds(0, 0, 800, 600);
        sources.setOpaque(false);

        categories = new JPanelCategories();
        categories.setBounds(0, 0, 800, 600);
        categories.setOpaque(false);

        gameName = new JPanelGameName();
        gameName.setBounds(0, 0, 800, 600);
        gameName.setOpaque(false);

        JFrame frame = new JFrame("Host View");
        ImageIcon icon = new ImageIcon(".//resources/images/icon.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(816, 639));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(sources);
        frame.getContentPane().add(backGround);
    }
}
