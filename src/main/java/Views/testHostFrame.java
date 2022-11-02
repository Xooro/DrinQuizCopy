/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

/**
 *
 * @author Jani
 */
import Views.HostJPanels.*;
import javax.swing.*;
import java.awt.*;

public class testHostFrame {

    public testHostFrame() {

        JPanelBackGround backGround = new JPanelBackGround();
        backGround.setBounds(0, 0, 800, 600);

        JPanelMainMenu mainMenu = new JPanelMainMenu();
        mainMenu.setBounds(0, 0, 800, 600);
        mainMenu.setOpaque(false);

        JFrame frame = new JFrame("Host View");
        ImageIcon icon = new ImageIcon(".//resources/images/icon.png");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(816, 639));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(mainMenu);
        frame.getContentPane().add(backGround);
    }

}
