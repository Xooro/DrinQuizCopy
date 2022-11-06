/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static Helpers.ViewHelper.scaleImageInLabel;

/**
 *
 * @author Jani
 */
public class JFrameHost extends javax.swing.JFrame {

    /**
     * Creates new form JFrameHost
     */
    ImageIcon icon = new ImageIcon(".//resources/images/icon.png");

    public JFrameHost() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        showOnScreen(2, this);

        scaleImageInLabel(".//resources/images/half.png", gameHost_jLblHalf);
        scaleImageInLabel(".//resources/images/call.png", gameHost_jLblCall);
        scaleImageInLabel(".//resources/images/group.png", gameHost_jLblGroup);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLyrdPn = new javax.swing.JLayeredPane();
        gameHost_kGrdntPnl = new com.k33ptoo.components.KGradientPanel();
        gameHost_kBttnEndGame = new com.k33ptoo.components.KButton();
        gameHost_jLblPlayerName = new javax.swing.JLabel();
        gameHost_jLblGameName = new javax.swing.JLabel();
        gameHost_kBttnNextQuestion = new com.k33ptoo.components.KButton();
        gameHost_kBttnShowAnswer = new com.k33ptoo.components.KButton();
        gameHost_jLblQuestion = new javax.swing.JLabel();
        gameHost_kBttnNewPlayer = new com.k33ptoo.components.KButton();
        gameHost_jLblHalf = new javax.swing.JLabel();
        gameHost_jLblGroup = new javax.swing.JLabel();
        gameHost_jLblCall = new javax.swing.JLabel();
        gameHost_kBttnRefillCups = new com.k33ptoo.components.KButton();
        exit_kGrdntPnl = new com.k33ptoo.components.KGradientPanel();
        exit_kBttnExit = new com.k33ptoo.components.KButton();
        exit_kBttnNewGame = new com.k33ptoo.components.KButton();
        exit_JLblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(icon.getImage());
        setName("frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        gameHost_kGrdntPnl.setkEndColor(new java.awt.Color(100, 0, 0));
        gameHost_kGrdntPnl.setkGradientFocus(1000);
        gameHost_kGrdntPnl.setkStartColor(new java.awt.Color(139, 46, 87));

        gameHost_kBttnEndGame.setBorder(null);
        gameHost_kBttnEndGame.setText("Játék vége");
        gameHost_kBttnEndGame.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_kBttnEndGame.setkBorderRadius(50);
        gameHost_kBttnEndGame.setPreferredSize(new java.awt.Dimension(200, 50));

        gameHost_jLblPlayerName.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_jLblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblPlayerName.setText("Játék neve: *J.N.*");
        gameHost_jLblPlayerName.setPreferredSize(new java.awt.Dimension(366, 50));

        gameHost_jLblGameName.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_jLblGameName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblGameName.setText("Játékos neve: *J.N.*");
        gameHost_jLblGameName.setPreferredSize(new java.awt.Dimension(366, 50));

        gameHost_kBttnNextQuestion.setBorder(null);
        gameHost_kBttnNextQuestion.setText("Következő kérdés");
        gameHost_kBttnNextQuestion.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_kBttnNextQuestion.setkBorderRadius(50);
        gameHost_kBttnNextQuestion.setPreferredSize(new java.awt.Dimension(200, 50));

        gameHost_kBttnShowAnswer.setBorder(null);
        gameHost_kBttnShowAnswer.setText("Válasz mutatása");
        gameHost_kBttnShowAnswer.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_kBttnShowAnswer.setkBorderRadius(50);
        gameHost_kBttnShowAnswer.setPreferredSize(new java.awt.Dimension(200, 50));

        gameHost_jLblQuestion.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_jLblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblQuestion.setText("*insert question here*");

        gameHost_kBttnNewPlayer.setBorder(null);
        gameHost_kBttnNewPlayer.setText("Új játékos");
        gameHost_kBttnNewPlayer.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_kBttnNewPlayer.setkBorderRadius(50);
        gameHost_kBttnNewPlayer.setPreferredSize(new java.awt.Dimension(200, 50));

        gameHost_jLblHalf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblHalf.setPreferredSize(new java.awt.Dimension(50, 50));

        gameHost_jLblGroup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblGroup.setPreferredSize(new java.awt.Dimension(50, 50));

        gameHost_jLblCall.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameHost_jLblCall.setPreferredSize(new java.awt.Dimension(50, 50));

        gameHost_kBttnRefillCups.setBorder(null);
        gameHost_kBttnRefillCups.setText("Poharak újratöltése");
        gameHost_kBttnRefillCups.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        gameHost_kBttnRefillCups.setkBorderRadius(50);
        gameHost_kBttnRefillCups.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout gameHost_kGrdntPnlLayout = new javax.swing.GroupLayout(gameHost_kGrdntPnl);
        gameHost_kGrdntPnl.setLayout(gameHost_kGrdntPnlLayout);
        gameHost_kGrdntPnlLayout.setHorizontalGroup(
            gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameHost_kGrdntPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameHost_kGrdntPnlLayout.createSequentialGroup()
                        .addComponent(gameHost_kBttnShowAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(gameHost_kBttnRefillCups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gameHost_kBttnNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gameHost_jLblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameHost_kGrdntPnlLayout.createSequentialGroup()
                        .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gameHost_jLblGameName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gameHost_jLblPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameHost_kGrdntPnlLayout.createSequentialGroup()
                                .addComponent(gameHost_jLblHalf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gameHost_jLblCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gameHost_jLblGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gameHost_kBttnEndGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gameHost_kBttnNewPlayer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        gameHost_kGrdntPnlLayout.setVerticalGroup(
            gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameHost_kGrdntPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gameHost_jLblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gameHost_kBttnEndGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gameHost_jLblHalf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameHost_jLblCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameHost_jLblGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameHost_jLblGameName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameHost_kBttnNewPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gameHost_jLblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addGroup(gameHost_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameHost_kBttnNextQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameHost_kBttnShowAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameHost_kBttnRefillCups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        exit_kGrdntPnl.setkEndColor(new java.awt.Color(100, 0, 0));
        exit_kGrdntPnl.setkGradientFocus(1000);
        exit_kGrdntPnl.setkStartColor(new java.awt.Color(139, 46, 87));

        exit_kBttnExit.setBorder(null);
        exit_kBttnExit.setText("Kilépés");
        exit_kBttnExit.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        exit_kBttnExit.setkBorderRadius(50);
        exit_kBttnExit.setPreferredSize(new java.awt.Dimension(200, 50));

        exit_kBttnNewGame.setBorder(null);
        exit_kBttnNewGame.setText("Kilépés");
        exit_kBttnNewGame.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        exit_kBttnNewGame.setkBorderRadius(50);
        exit_kBttnNewGame.setPreferredSize(new java.awt.Dimension(200, 50));

        exit_JLblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_JLblLogo.setIcon(new ImageIcon("resources/images/DrinQuiz.gif"));

        javax.swing.GroupLayout exit_kGrdntPnlLayout = new javax.swing.GroupLayout(exit_kGrdntPnl);
        exit_kGrdntPnl.setLayout(exit_kGrdntPnlLayout);
        exit_kGrdntPnlLayout.setHorizontalGroup(
            exit_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exit_kGrdntPnlLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(exit_kBttnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(exit_kGrdntPnlLayout.createSequentialGroup()
                .addGroup(exit_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(exit_kGrdntPnlLayout.createSequentialGroup()
                        .addContainerGap(594, Short.MAX_VALUE)
                        .addComponent(exit_kBttnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(exit_JLblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        exit_kGrdntPnlLayout.setVerticalGroup(
            exit_kGrdntPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exit_kGrdntPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exit_JLblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(exit_kBttnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(exit_kBttnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLyrdPn.setLayer(gameHost_kGrdntPnl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLyrdPn.setLayer(exit_kGrdntPnl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLyrdPnLayout = new javax.swing.GroupLayout(jLyrdPn);
        jLyrdPn.setLayout(jLyrdPnLayout);
        jLyrdPnLayout.setHorizontalGroup(
            jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gameHost_kGrdntPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(exit_kGrdntPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLyrdPnLayout.setVerticalGroup(
            jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gameHost_kGrdntPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLyrdPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(exit_kGrdntPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLyrdPn)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLyrdPn)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameHost().setVisible(true);
            }
        });
    }

    public static void showOnScreen(int screen, JFrame frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        if (screen > -1 && screen < gd.length) {
            //gd[screen].setFullScreenWindow(frame);
            frame.setLocation(gd[screen].getDefaultConfiguration().getBounds().x, frame.getY());
        } else if (gd.length > 0) {
            //gd[0].setFullScreenWindow(frame);
            frame.setLocation(gd[0].getDefaultConfiguration().getBounds().x, frame.getY());
        } else {
            throw new RuntimeException("No screen found!");

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit_JLblLogo;
    private com.k33ptoo.components.KButton exit_kBttnExit;
    private com.k33ptoo.components.KButton exit_kBttnNewGame;
    private com.k33ptoo.components.KGradientPanel exit_kGrdntPnl;
    private javax.swing.JLabel gameHost_jLblCall;
    private javax.swing.JLabel gameHost_jLblGameName;
    private javax.swing.JLabel gameHost_jLblGroup;
    private javax.swing.JLabel gameHost_jLblHalf;
    private javax.swing.JLabel gameHost_jLblPlayerName;
    private javax.swing.JLabel gameHost_jLblQuestion;
    private com.k33ptoo.components.KButton gameHost_kBttnEndGame;
    private com.k33ptoo.components.KButton gameHost_kBttnNewPlayer;
    private com.k33ptoo.components.KButton gameHost_kBttnNextQuestion;
    private com.k33ptoo.components.KButton gameHost_kBttnRefillCups;
    private com.k33ptoo.components.KButton gameHost_kBttnShowAnswer;
    private com.k33ptoo.components.KGradientPanel gameHost_kGrdntPnl;
    private javax.swing.JLayeredPane jLyrdPn;
    // End of variables declaration//GEN-END:variables
}
