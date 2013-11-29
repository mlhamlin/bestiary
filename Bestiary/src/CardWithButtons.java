/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martha
 */
public class CardWithButtons extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer CardWithButtons
     */
    public CardWithButtons(BestiaryGUI win, Monster m) {
        mainWin = win;
        mon = m;
        initComponents();
        mon.loadToCard(largeMonsterCard1);
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    
    BestiaryGUI mainWin;
    Monster mon;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        largeMonsterCard1 = new LargeMonsterCard();
        ButtonPane = new javax.swing.JPanel();
        DeleteMonsterButton = new javax.swing.JButton();
        OpenMonsterDetailsButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(800, 400));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setPreferredSize(new java.awt.Dimension(600, 381));
        setSize(new java.awt.Dimension(681, 381));
        setLayout(new java.awt.BorderLayout());

        largeMonsterCard1.setBorder(null);
        add(largeMonsterCard1, java.awt.BorderLayout.CENTER);

        ButtonPane.setSize(new java.awt.Dimension(681, 381));
        ButtonPane.setLayout(new java.awt.BorderLayout());

        DeleteMonsterButton.setText("Delete Monster");
        DeleteMonsterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMonsterButtonActionPerformed(evt);
            }
        });
        ButtonPane.add(DeleteMonsterButton, java.awt.BorderLayout.WEST);

        OpenMonsterDetailsButton.setText("Open Monster Details");
        OpenMonsterDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMonsterDetailsButtonActionPerformed(evt);
            }
        });
        ButtonPane.add(OpenMonsterDetailsButton, java.awt.BorderLayout.EAST);

        add(ButtonPane, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteMonsterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMonsterButtonActionPerformed
        
        int n = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete " + mon.getName() + "?",
            "Confirm Delete",
            javax.swing.JOptionPane.YES_NO_OPTION);
        if(n == javax.swing.JOptionPane.YES_OPTION){
            mainWin.BestiaryMonsters.removeMonster(mon);
            mainWin.updateBestiaryMonsters();
            mainWin.validate();
        }
 
    }//GEN-LAST:event_DeleteMonsterButtonActionPerformed

    private void OpenMonsterDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMonsterDetailsButtonActionPerformed
        mainWin.setMainMonster(mon);
        mainWin.openMonster = mon;
    }//GEN-LAST:event_OpenMonsterDetailsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPane;
    private javax.swing.JButton DeleteMonsterButton;
    private javax.swing.JButton OpenMonsterDetailsButton;
    private LargeMonsterCard largeMonsterCard1;
    // End of variables declaration//GEN-END:variables
}
