/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.Base;

import static Helpers.ViewHelper.scaleImageInLabel;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kkris
 */
public abstract class CustomJFrame extends javax.swing.JFrame {
    protected int frameHeight, frameWidth;
    
    protected void setFrameToFullscreen()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();

        setPreferredSize(dimension);

        pack();

        frameWidth = dimension.width;
        frameHeight = dimension.height;
    }
    
    protected void generateAnswerPanels(KGradientPanel displayPanel, String[] answers)
    {
        KGradientPanel[] panels = new KGradientPanel[0];
        switch (answers.length)
        {
            case 3:
                panels = get3AnswersPanel(answers);
                break;
        }
        for (int i = 0; i < answers.length; i++) {
            displayPanel.add(panels[i]);
        }
    }
    
    protected KGradientPanel[] get3AnswersPanel(String[] answers)
    {
        KGradientPanel[] panels = new KGradientPanel[3];
        for (int i = 0; i < answers.length; i++) {
            KGradientPanel kPanel = getAnswersKPanelToFrame(i, answers[i]);
            changePanelBound(kPanel, (-frameWidth/3)+frameWidth/3*i, 0, frameWidth/4, frameHeight/3);
            panels[i] = kPanel;
        }
        return panels;
    }
    
    protected KGradientPanel getAnswersKPanelToFrame(int index, String answer) {
        int number = 0;
        KGradientPanel game_kGrdntPnlAnswer = new KGradientPanel();
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel jLblPlus = new JLabel();
        JLabel jLblMinus = new JLabel();
        JLabel jLblCups = new JLabel();
        JLabel jLblAnswer = new JLabel();

        jLblAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblAnswer.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLblAnswer.setFont(new java.awt.Font("Century Gothic", 3, 18));
        jLblAnswer.setForeground(Color.BLACK);
        jLblAnswer.setText(answer);

        jLblCups.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCups.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLblCups.setFont(new java.awt.Font("Century Gothic", 3, 18));
        jLblCups.setForeground(Color.BLACK);
        jLblCups.setText(Integer.toString(number));

        jLblPlus.setSize(50, 50);
        jLblPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblPlus.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLblPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLblMinus.setSize(50, 50);
        jLblMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMinus.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLblPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCups(jLblCups, index);
            }
        });
        jLblMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subtractCups(jLblCups, index);
            }
        });

        game_kGrdntPnlAnswer.setkBorderRadius(100);
        game_kGrdntPnlAnswer.setkStartColor(new java.awt.Color(128, 128, 128));
        game_kGrdntPnlAnswer.setkEndColor(new java.awt.Color(128, 128, 128));
        game_kGrdntPnlAnswer.setOpaque(false);

        //game_kGrdntPnlAnswer.setBounds(400 * index, frameHeight / 2, 300, 300);
        game_kGrdntPnlAnswer.setLayout(new GridBagLayout());

        scaleImageInLabel(".//resources/images/plus.png", jLblPlus);
        scaleImageInLabel(".//resources/images/minus.png", jLblMinus);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = 3;
        game_kGrdntPnlAnswer.add(jLblAnswer, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        game_kGrdntPnlAnswer.add(jLblPlus, gbc);
        gbc.gridx = 1;
        game_kGrdntPnlAnswer.add(jLblCups, gbc);
        gbc.gridx = 2;
        game_kGrdntPnlAnswer.add(jLblMinus, gbc);

        return game_kGrdntPnlAnswer;
    }
    
    protected abstract void addCups(JLabel label, int index);
    protected abstract void subtractCups(JLabel label, int index);
    
    protected void removeOldAnswerKPanel(KGradientPanel kPanel) {
        KGradientPanel kgp = new KGradientPanel();

        for (Component component : kPanel.getComponents()) {
            if (component.getClass() == kgp.getClass()) {
                kPanel.remove(component);
            }
        }
    }
    
    protected void changePanelBound(JPanel panel, int x, int y, int width, int height)
    {
        changePanelSize(panel, width, height);
        changeLocation(panel, x, y);
    }
    
    protected void changeLocation(Component comp, int x, int y) {
        comp.setLocation(frameWidth / 2 - comp.getWidth() / 2 + x,
                frameHeight / 2 - comp.getHeight() / 2 + y);
    }
    
    protected void changePanelSize(JPanel panel, int width, int height){
        panel.setSize(width, height);
    }
}
