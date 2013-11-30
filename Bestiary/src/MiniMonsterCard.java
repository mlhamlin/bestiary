/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marthahamlin
 */
public class MiniMonsterCard extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer MiniMonsterCard
     */
    public MiniMonsterCard() {
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }
    
    public void setdMonsterName(String name){
        cMonsterName.setText(name);
        cMonsterName.setToolTipText(name);
        resizeFont(cInstinct, 18);
    }
    
    public String getdMonsterName(){
        return cMonsterName.getText();
    }
    
    public void setdMonsterTags(String txt){
        cMonsterTags.setText(txt);
        cMonsterTags.setToolTipText(txt);
        resizeFont(cInstinct, 14);
    }
    
    public String getdMonsterTags(){
        return cMonsterTags.getText();
    }
    
    public void setdAttack(String txt){
        cAttack.setText(txt);
        resizeFont(cInstinct, 14);
    }
    
    public String getdAttack(){
        return cAttack.getText();
    }
    
    public void setdHP(String txt){
        cHP.setText(txt);
        resizeFont(cInstinct, 14);
    }
    
    public String getdHP(){
        return cHP.getText();
    }
    
    public void setdArmor(String txt){
        cArmor.setText(txt);
        resizeFont(cInstinct, 14);
    }
    
    public String getdArmor(){
        return cArmor.getText();
    }
    
    public void setdAttackTags(String txt){
        cAttackTags.setText(txt);
        cAttackTags.setToolTipText(txt);
        resizeFont(cInstinct, 14);
    }
    
    public String getdAttackTags(){
        return cAttackTags.getText();
    }
    
    public void setdQualities(String txt){
        cQualities.setText(txt);
        cQualities.setToolTipText(txt);
        resizeFont(cInstinct, 12);
    }
    
    public String getdQualities(){
        return cQualities.getText();
    }

    public void setdInstinct(String txt){
        cInstinct.setText(txt);
        cInstinct.setToolTipText(txt);
        resizeFont(cInstinct, 13);
    }
    
    public String getdInstinct(){
        return cInstinct.getText();
    }

    public void setdMonsterDescription(String txt){
        cMonsterDescription.setText(txt);
    }
    
    public String getdMonsterDescription(){
        return cMonsterDescription.getText();
    }
    
    public void setdMoveList(String txt){
        
        cMoves.setText(txt);
    }
    
    public String getdMoveList(){
        
        return cMoves.getText();
        
    }

       protected void resizeFont(javax.swing.JLabel label, int startSize){
        java.awt.Graphics gfx = this.getGraphics();
        if(gfx==null){
            return;
        }
        
        int maxWidth = label.getWidth();
        int fontSize = startSize;
        java.awt.Font font = label.getFont();
        int curWidth;
        
        
        while (fontSize>2){
            curWidth = getTextSize(label, font.deriveFont(font.getStyle(), fontSize));
            if (curWidth <= maxWidth){
                break;
            }
            fontSize = fontSize - 1;
        }
        
        label.setFont(font.deriveFont(font.getStyle(), fontSize));
    }
    
    private int getTextSize(javax.swing.JLabel label, java.awt.Font font){
        java.awt.Graphics gfx = label.getGraphics();
        java.awt.FontMetrics fm = gfx.getFontMetrics(font);
        return fm.stringWidth(label.getText());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MonsterCard = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cMonsterName = new javax.swing.JLabel();
        cMonsterTags = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cAttack = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        cHP = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        cArmor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cAttackTags = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cQualities = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cMonsterDescription = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cMoves = new javax.swing.JTextPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cInstinct = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        setLayout(new java.awt.BorderLayout());

        MonsterCard.setPreferredSize(new java.awt.Dimension(475, 350));
        MonsterCard.setLayout(new java.awt.BorderLayout());
        MonsterCard.add(filler1, java.awt.BorderLayout.NORTH);

        jPanel12.setPreferredSize(new java.awt.Dimension(500, 350));
        jPanel12.setLayout(new java.awt.GridLayout(3, 0));

        jPanel1.setLayout(new java.awt.GridLayout(4, 0));

        jPanel4.setLayout(new java.awt.BorderLayout());

        cMonsterName.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        cMonsterName.setText("Name");
        cMonsterName.setPreferredSize(new java.awt.Dimension(250, 22));
        cMonsterName.setSize(new java.awt.Dimension(250, 22));
        jPanel4.add(cMonsterName, java.awt.BorderLayout.WEST);

        cMonsterTags.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        cMonsterTags.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cMonsterTags.setText("Monster, Tags");
        cMonsterTags.setPreferredSize(new java.awt.Dimension(200, 17));
        jPanel4.add(cMonsterTags, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        cAttack.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cAttack.setText("Attack");
        cAttack.setPreferredSize(new java.awt.Dimension(300, 17));
        cAttack.setSize(new java.awt.Dimension(300, 17));
        jPanel5.add(cAttack, java.awt.BorderLayout.CENTER);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cHP.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cHP.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cHP.setText("0");
        cHP.setPreferredSize(new java.awt.Dimension(20, 17));
        cHP.setSize(new java.awt.Dimension(20, 17));
        jPanel9.add(cHP);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("HP");
        jPanel9.add(jLabel5);

        jPanel8.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cArmor.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cArmor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cArmor.setText("0");
        cArmor.setPreferredSize(new java.awt.Dimension(20, 17));
        cArmor.setSize(new java.awt.Dimension(20, 17));
        jPanel10.add(cArmor);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Armor");
        jPanel10.add(jLabel7);

        jPanel8.add(jPanel10);

        jPanel5.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(400, 17));
        jPanel6.setLayout(new java.awt.BorderLayout());

        cAttackTags.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        cAttackTags.setText("Attack, Tags");
        cAttackTags.setPreferredSize(new java.awt.Dimension(400, 17));
        cAttackTags.setSize(new java.awt.Dimension(400, 17));
        jPanel6.add(cAttackTags, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Special Qualities: ");
        jPanel7.add(jLabel9, java.awt.BorderLayout.WEST);

        cQualities.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        cQualities.setText("Stuff and Things");
        cQualities.setMaximumSize(null);
        cQualities.setMinimumSize(new java.awt.Dimension(20, 15));
        cQualities.setPreferredSize(new java.awt.Dimension(300, 15));
        jPanel7.add(cQualities, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7);

        jPanel12.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        cMonsterDescription.setEditable(false);
        cMonsterDescription.setBackground(new java.awt.Color(238, 238, 238));
        cMonsterDescription.setColumns(20);
        cMonsterDescription.setLineWrap(true);
        cMonsterDescription.setRows(5);
        cMonsterDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris dapibus purus metus, non tempor lacus accumsan viverra. Morbi id mi quis ligula aliquet feugiat. Praesent vel pretium ante. Mauris pretium mi metus, vel eleifend libero aliquam eget. In in nisl et dolor tincidunt imperdiet id eu ante. Quisque pretium massa ac luctus molestie. Quisque elementum lorem at ligula dictum bibendum. Praesent velit leo, condimentum in turpis et, elementum tincidunt arcu. Phasellus a dolor in justo eleifend pulvinar quis vel velit. Proin orci sem, hendrerit in mollis sit amet, pulvinar eu libero. Ut et arcu ut est fringilla consectetur vel sit amet metus.");
        cMonsterDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(cMonsterDescription);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        cMoves.setEditable(false);
        cMoves.setBackground(new java.awt.Color(238, 238, 238));
        cMoves.setBorder(null);
        cMoves.setContentType("text/html"); // NOI18N
        cMoves.setText("<html><body bgcolor=\"#EEEEEE\"><ul> \t<li> move1</li> \t<li> move2</li> \t<li> move3</li> \t<li> move4</li> </ul></body></html> ");
        jScrollPane2.setViewportView(cMoves);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabel1.setText("Instinct: ");
        jPanel13.add(jLabel1, java.awt.BorderLayout.WEST);

        cInstinct.setText("to do things");
        cInstinct.setPreferredSize(new java.awt.Dimension(350, 16));
        jPanel13.add(cInstinct, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel13, java.awt.BorderLayout.NORTH);

        jPanel12.add(jPanel3);

        MonsterCard.add(jPanel12, java.awt.BorderLayout.CENTER);
        MonsterCard.add(filler3, java.awt.BorderLayout.EAST);
        MonsterCard.add(filler4, java.awt.BorderLayout.WEST);

        add(MonsterCard, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MonsterCard;
    private javax.swing.JLabel cArmor;
    private javax.swing.JLabel cAttack;
    private javax.swing.JLabel cAttackTags;
    private javax.swing.JLabel cHP;
    private javax.swing.JLabel cInstinct;
    private javax.swing.JTextArea cMonsterDescription;
    private javax.swing.JLabel cMonsterName;
    private javax.swing.JLabel cMonsterTags;
    private javax.swing.JTextPane cMoves;
    private javax.swing.JLabel cQualities;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
