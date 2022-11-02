/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.HostJPanels;

/**
 *
 * @author Jani
 */
public class JPanelSettings extends javax.swing.JPanel {

    /**
     * Creates new form settings
     */
    public JPanelSettings() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new com.k33ptoo.components.KButton();
        applyButton = new com.k33ptoo.components.KButton();
        applyButton1 = new com.k33ptoo.components.KButton();
        applyButton2 = new com.k33ptoo.components.KButton();
        applyButton3 = new com.k33ptoo.components.KButton();

        backButton.setText("Back");
        backButton.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        backButton.setkBorderRadius(50);
        backButton.setPreferredSize(new java.awt.Dimension(200, 50));

        applyButton.setText("Apply");
        applyButton.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        applyButton.setkBorderRadius(50);
        applyButton.setPreferredSize(new java.awt.Dimension(200, 50));

        applyButton1.setText("Delete Database");
        applyButton1.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        applyButton1.setkBorderRadius(50);
        applyButton1.setPreferredSize(new java.awt.Dimension(200, 50));

        applyButton2.setText("Add Database");
        applyButton2.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        applyButton2.setkBorderRadius(50);
        applyButton2.setPreferredSize(new java.awt.Dimension(200, 50));

        applyButton3.setText("Apply");
        applyButton3.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        applyButton3.setkBorderRadius(50);
        applyButton3.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 370, Short.MAX_VALUE)
                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(applyButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(applyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(applyButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(227, 227, 227)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton applyButton;
    private com.k33ptoo.components.KButton applyButton1;
    private com.k33ptoo.components.KButton applyButton2;
    private com.k33ptoo.components.KButton applyButton3;
    private com.k33ptoo.components.KButton backButton;
    // End of variables declaration//GEN-END:variables
}
