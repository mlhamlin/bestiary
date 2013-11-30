/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marthahamlin
 */

import java.util.ArrayList;

public class MonsterEditWinSet extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer MonsterEditWinSet
     */
    public MonsterEditWinSet(javax.swing.JDialog ownr, BestiaryGUI win, MonsterList ls) {
        
        owner = ownr;
        
        listy = ls;
        
        MonsterEdit_ModelMoveList = new javax.swing.DefaultListModel();
        MonsterEdit_ModelQualityList = new javax.swing.DefaultListModel();
        
        initComponents();

        mon = new Monster();
        mainWin = win;
        
        loadMonster();
        
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }
    
    
    public void setMonster(Monster m){
        mon = m;
        loadMonster();
    }
    
    public Monster getMonster(){
        return mon;
    }    
    
    public void loadMonster(){
        this.MonsterEdit_ArmorValue.setValue(mon.getArmor());
        this.MonsterEdit_AttackNameField.setText(mon.getAttackName());
        this.MonsterEdit_DescriptionField.setText(mon.getDescription());
        this.MonsterEdit_AttackMod.setValue(mon.getDmgMod());
        this.MonsterEdit_HPValue.setValue(mon.getHp());
        this.MonsterEdit_InstinctField.setText(mon.getInstinct());
        this.MonsterEdit_NameField.setText(mon.getName());
        
        loadMonsterTags();
        loadAttackTags();
        loadDmgDice();
        loadDmgRollType();
        loadSpecialQualities();
        loadMoves();
    }
    
    public void loadMonsterTags(){
        
        this.MonTagWin_Magical.setSelected(mon.getMonsterTag(0));
        this.MonTagWin_Devious.setSelected(mon.getMonsterTag(1));
        this.MonTagWin_Amorphous.setSelected(mon.getMonsterTag(2));
        this.MonTagWin_Organized.setSelected(mon.getMonsterTag(3));
        this.MonTagWin_Intelligent.setSelected(mon.getMonsterTag(4));
        this.MonTagWin_Hoarder.setSelected(mon.getMonsterTag(5));
        this.MonTagWin_Stealthy.setSelected(mon.getMonsterTag(6));
        this.MonTagWin_Terrifying.setSelected(mon.getMonsterTag(7));
        this.MonTagWin_Cautious.setSelected(mon.getMonsterTag(8));
        this.MonTagWin_Construct.setSelected(mon.getMonsterTag(9));
        this.MonTagWin_Planar.setSelected(mon.getMonsterTag(10));
        this.MonTagWin_Horde.setSelected(mon.getMonsterTag(11));
        this.MonTagWin_Group.setSelected(mon.getMonsterTag(12));
        this.MonTagWin_Solitary.setSelected(mon.getMonsterTag(13));
        this.MonTagWin_Tiny.setSelected(mon.getMonsterTag(14));
        this.MonTagWin_Small.setSelected(mon.getMonsterTag(15));
        this.MonTagWin_Normal.setSelected(mon.getMonsterTag(16));
        this.MonTagWin_Large.setSelected(mon.getMonsterTag(17));
        this.MonTagWin_Huge.setSelected(mon.getMonsterTag(18));

    }
    
    public void loadAttackTags(){
        
        this.AttTagWin_AmmoCheck.setSelected(mon.getMonsterTag(0));
        this.AttTagWin_ForcefulCheck.setSelected(mon.getMonsterTag(1));
        this.AttTagWin_IgnoresArmorCheck.setSelected(mon.getMonsterTag(2));
        this.AttTagWin_MessyCheck.setSelected(mon.getMonsterTag(3));
        this.AttTagWin_PiercingCheck.setSelected(mon.getMonsterTag(4));
        this.AttTagWin_PreciseCheck.setSelected(mon.getMonsterTag(5));
        this.AttTagWin_ReloadCheck.setSelected(mon.getMonsterTag(6));
        this.AttTagWin_StunCheck.setSelected(mon.getMonsterTag(7));
        this.AttTagWin_ThrownCheck.setSelected(mon.getMonsterTag(8));
        this.AttTagWin_HandCheck.setSelected(mon.getMonsterTag(9));
        this.AttTagWin_CloseCheck.setSelected(mon.getMonsterTag(10));
        this.AttTagWin_ReachChange.setSelected(mon.getMonsterTag(11));
        this.AttTagWin_NearCheck.setSelected(mon.getMonsterTag(12));
        this.AttTagWin_FarCheck.setSelected(mon.getMonsterTag(13));
        
        this.AttTagWin_AmmoSpin.setValue(mon.getAmmo());
        this.AttTagWin_PiercingSpin.setValue(mon.getPiercing());
        
    }
    
    public void loadDmgDice(){
        
        String d = "";
        
        Dice od = mon.getDmgDice();
        
        if(od == Dice.D_FOUR){
            d = "d4";
        }else if(od == Dice.D_SIX){
            d = "d6";
        }else if(od == Dice.D_EIGHT){
            d = "d8";
        }else if(od == Dice.D_TEN){
            d = "d10";
        }else if(od == Dice.D_TWELVE){
            d = "d12";
        }else if(od == Dice.D_TWENTY){
            d = "d20";
        }
        
        this.MonsterEdit_Dice.setSelectedItem(d);
        
    }
    
    public void loadDmgRollType(){
        
        String d = "";
        
        RollType od = mon.getDmgRoll();
        
        if(od == RollType.NORMAL){
            d = "Normal";
        }else if(od == RollType.BESTOF){
            d = "Best of 2";
        }else if(od == RollType.WORSTOF){
            d = "Worst of 2";
        }
        
        this.MonsterEdit_Rolls.setSelectedItem(d);
        
    }
    
    public void loadSpecialQualities(){
        
        ArrayList<String> list = mon.getSpecialQualities();
        this.MonsterEdit_ModelQualityList.clear();
        
        for(String s : list){
            this.MonsterEdit_ModelQualityList.addElement(s);
        }
    }
    
    public void loadMoves(){
        
        ArrayList<String> list = mon.getMoves();
        this.MonsterEdit_ModelMoveList.clear();
        
        for(String s : list){
            this.MonsterEdit_ModelMoveList.addElement(s);
        }
    }
    
    public void saveMonster(){
        
        mon.setArmor((Integer)this.MonsterEdit_ArmorValue.getValue());
        mon.setAttackName(this.MonsterEdit_AttackNameField.getText());
        mon.setCanFight(!this.MonsterEdit_AttackNameField.getText().equals(""));
        mon.setDescription(this.MonsterEdit_DescriptionField.getText());
        mon.setDmgMod((Integer)this.MonsterEdit_AttackMod.getValue());
        mon.setHp((Integer)this.MonsterEdit_HPValue.getValue());
        mon.setInstinct(this.MonsterEdit_InstinctField.getText());
        mon.setName(this.MonsterEdit_NameField.getText());
        
        saveMonsterTags();
        saveAttackTags();
        saveDmgDice();
        saveDmgRollType();
        saveSpecialQualities();
        saveMoves();
        
        if(!listy.constainsMonster(mon)){
            listy.addMonster(mon);
        }
        
        mainWin.validate();
        mainWin.repaint();
        mainWin.setMainMonster(mon);
    }
    
    public void saveMonsterTags(){
        
        mon.setMonsterTag(0, this.MonTagWin_Magical.isSelected());
        mon.setMonsterTag(1, this.MonTagWin_Devious.isSelected());
        mon.setMonsterTag(2, this.MonTagWin_Amorphous.isSelected());
        mon.setMonsterTag(3, this.MonTagWin_Organized.isSelected());
        mon.setMonsterTag(4, this.MonTagWin_Intelligent.isSelected());
        mon.setMonsterTag(5, this.MonTagWin_Hoarder.isSelected());
        mon.setMonsterTag(6, this.MonTagWin_Stealthy.isSelected());
        mon.setMonsterTag(7, this.MonTagWin_Terrifying.isSelected());
        mon.setMonsterTag(8, this.MonTagWin_Cautious.isSelected());
        mon.setMonsterTag(9, this.MonTagWin_Construct.isSelected());
        mon.setMonsterTag(10, this.MonTagWin_Planar.isSelected());
        mon.setMonsterTag(11, this.MonTagWin_Horde.isSelected());
        mon.setMonsterTag(12, this.MonTagWin_Group.isSelected());
        mon.setMonsterTag(13, this.MonTagWin_Solitary.isSelected());
        mon.setMonsterTag(14, this.MonTagWin_Tiny.isSelected());
        mon.setMonsterTag(15, this.MonTagWin_Small.isSelected());
        mon.setMonsterTag(16, this.MonTagWin_Normal.isSelected());
        mon.setMonsterTag(17, this.MonTagWin_Large.isSelected());
        mon.setMonsterTag(18, this.MonTagWin_Huge.isSelected());

    }
    
    public void saveAttackTags(){
        
        mon.setAttackTag(0, this.AttTagWin_AmmoCheck.isSelected());
        mon.setAmmo((Integer)this.AttTagWin_AmmoSpin.getValue());
        mon.setAttackTag(1, this.AttTagWin_ForcefulCheck.isSelected());
        mon.setAttackTag(2, this.AttTagWin_IgnoresArmorCheck.isSelected());
        mon.setAttackTag(3, this.AttTagWin_MessyCheck.isSelected());
        mon.setAttackTag(4, this.AttTagWin_PiercingCheck.isSelected());
        mon.setPiercing((Integer)this.AttTagWin_PiercingSpin.getValue());
        mon.setAttackTag(5, this.AttTagWin_PreciseCheck.isSelected());
        mon.setAttackTag(6, this.AttTagWin_ReloadCheck.isSelected());
        mon.setAttackTag(7, this.AttTagWin_StunCheck.isSelected());
        mon.setAttackTag(8, this.AttTagWin_ThrownCheck.isSelected());
        mon.setAttackTag(9, this.AttTagWin_HandCheck.isSelected());
        mon.setAttackTag(10, this.AttTagWin_CloseCheck.isSelected());
        mon.setAttackTag(11, this.AttTagWin_ReachChange.isSelected());
        mon.setAttackTag(12, this.AttTagWin_NearCheck.isSelected());
        mon.setAttackTag(13, this.AttTagWin_FarCheck.isSelected());
        
    }
    
    public void saveDmgDice(){
        
        Dice d = Dice.D_FOUR;
        
        Object combo = this.MonsterEdit_Dice.getSelectedItem();
        
        if(combo.equals("d4")){
            d = Dice.D_FOUR;
        }else if(combo.equals("d6")){
            d = Dice.D_SIX;
        }else if(combo.equals("d8")){
            d = Dice.D_EIGHT;
        }else if(combo.equals("d10")){
            d = Dice.D_TEN;
        }else if(combo.equals("d12")){
            d = Dice.D_TWELVE;
        }else if(combo.equals("d20")){
            d = Dice.D_TWENTY;
        }
        
        mon.setDmgDice(d);
        
    }
    
    public void saveDmgRollType(){
        
        RollType rt = RollType.NORMAL;
        
        Object combo = this.MonsterEdit_Rolls.getSelectedItem();
        
        if(combo.equals("Normal")){
            rt = RollType.NORMAL;
        }else if(combo.equals("Best of 2")){
            rt = RollType.BESTOF;
        }else if(combo.equals("Worst of 2")){
            rt = RollType.WORSTOF;
        }
        
        mon.setDmgRoll(rt);
        
    }
    
    public void saveSpecialQualities(){
        ArrayList<String> list = new ArrayList<String>();
        int size = this.MonsterEdit_ModelQualityList.getSize();
        for(int i = 0; i < size; i++){
            list.add((String)this.MonsterEdit_ModelQualityList.elementAt(i));
        }
        mon.setSpecialQualities(list);
    }
    
    public void saveMoves(){
        ArrayList<String> list = new ArrayList<String>();
        int size = this.MonsterEdit_ModelMoveList.getSize();
        for(int i = 0; i < size; i++){
            list.add((String)this.MonsterEdit_ModelMoveList.elementAt(i));
        }
        mon.setMoves(list);
    }
    
    public boolean validName(String s){
        if(s.equals("")){
            return false; //invalid name
        }else if(!(s.equals(mon.getName())) && listy.containsMonster(s)){
            return false; //name collision
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MonsterTagsWindow = new javax.swing.JDialog();
        MonTagWin_MainPane = new javax.swing.JPanel();
        MonTagWin_GridPane = new javax.swing.JPanel();
        MonTagWin_MonsterTagsLabel = new javax.swing.JLabel();
        MonTagWin_OrgTagsLabel = new javax.swing.JLabel();
        MonTagWin_Magical = new javax.swing.JCheckBox();
        MonTagWin_Horde = new javax.swing.JRadioButton();
        MonTagWin_Devious = new javax.swing.JCheckBox();
        MonTagWin_Group = new javax.swing.JRadioButton();
        MonTagWin_Amorphous = new javax.swing.JCheckBox();
        MonTagWin_Solitary = new javax.swing.JRadioButton();
        MonTagWin_Organized = new javax.swing.JCheckBox();
        MonTagWin_filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        MonTagWin_Intelligent = new javax.swing.JCheckBox();
        MonTagWin_SizeTagsLabel = new javax.swing.JLabel();
        MonTagWin_Hoarder = new javax.swing.JCheckBox();
        MonTagWin_Tiny = new javax.swing.JRadioButton();
        MonTagWin_Stealthy = new javax.swing.JCheckBox();
        MonTagWin_Small = new javax.swing.JRadioButton();
        MonTagWin_Terrifying = new javax.swing.JCheckBox();
        MonTagWin_Normal = new javax.swing.JRadioButton();
        MonTagWin_Cautious = new javax.swing.JCheckBox();
        MonTagWin_Large = new javax.swing.JRadioButton();
        MonTagWin_Construct = new javax.swing.JCheckBox();
        MonTagWin_Huge = new javax.swing.JRadioButton();
        MonTagWin_Planar = new javax.swing.JCheckBox();
        MonTagWin_ButtonPane = new javax.swing.JPanel();
        MonTagWin_CancelButton = new javax.swing.JButton();
        MonTagWin_SaveButton = new javax.swing.JButton();
        MonTagWin_filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MonTagWin_filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonTagWin_filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonTagWin_filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MonTagWin_filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MonTagsWin_OrgTagsGroup = new javax.swing.ButtonGroup();
        MonTagsWin_SizeTagsGroup = new javax.swing.ButtonGroup();
        AttackTagsWindow = new javax.swing.JDialog();
        AttTagWin_MainPane = new javax.swing.JPanel();
        AttTagWin_MainLabel = new javax.swing.JLabel();
        AttTagWin_GridPane = new javax.swing.JPanel();
        AttTagWin_AmmoBox = new javax.swing.JPanel();
        AttTagWin_AmmoCheck = new javax.swing.JCheckBox();
        AttTagWin_AmmoSpin = new javax.swing.JSpinner();
        AttTagWin_AmmoLabel = new javax.swing.JLabel();
        AttTagWin_StunCheck = new javax.swing.JCheckBox();
        AttTagWin_ForcefulCheck = new javax.swing.JCheckBox();
        AttTagWin_ThrownCheck = new javax.swing.JCheckBox();
        AttTagWin_IgnoresArmorCheck = new javax.swing.JCheckBox();
        AttTagWin_HandCheck = new javax.swing.JCheckBox();
        AttTagWin_MessyCheck = new javax.swing.JCheckBox();
        AttTagWin_CloseCheck = new javax.swing.JCheckBox();
        AttTagWin_PiercingBox = new javax.swing.JPanel();
        AttTagWin_PiercingCheck = new javax.swing.JCheckBox();
        AttTagWin_PiercingSpin = new javax.swing.JSpinner();
        AttTagWin_PiercingLabel = new javax.swing.JLabel();
        AttTagWin_ReachChange = new javax.swing.JCheckBox();
        AttTagWin_PreciseCheck = new javax.swing.JCheckBox();
        AttTagWin_NearCheck = new javax.swing.JCheckBox();
        AttTagWin_ReloadCheck = new javax.swing.JCheckBox();
        AttTagWin_FarCheck = new javax.swing.JCheckBox();
        AttTagWin_ButtonBox = new javax.swing.JPanel();
        AttTagWin_CancelButton = new javax.swing.JButton();
        AttTagWin_AttackButton = new javax.swing.JButton();
        AttTagWin_filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        AttTagWin_filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        AttTagWin_filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        AttTagWin_filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonsterEdit_MainPane = new javax.swing.JPanel();
        MonsterEdit_TopPane = new javax.swing.JPanel();
        MonsterEdit_Row1 = new javax.swing.JPanel();
        MonsterEdit_NamePane = new javax.swing.JPanel();
        MonsterEdit_NameLabel = new javax.swing.JLabel();
        MonsterEdit_NameField = new javax.swing.JTextField();
        MonsterEdit_MonsterTagsButton = new javax.swing.JButton();
        MonsterEdit_Row2 = new javax.swing.JPanel();
        MonsterEdit_HPValue = new javax.swing.JSpinner();
        MonsterEdit_HPLabel = new javax.swing.JLabel();
        MonsterEdit_ArmorValue = new javax.swing.JSpinner();
        MonsterEdit_ArmorLabel = new javax.swing.JLabel();
        MonsterEdit_Row3 = new javax.swing.JPanel();
        MonsterEdit_AttackNameLabel = new javax.swing.JLabel();
        MonsterEdit_AttackNameField = new javax.swing.JTextField();
        MonsterEdit_Rolls = new javax.swing.JComboBox();
        MonsterEdit_Dice = new javax.swing.JComboBox();
        MonsterEdit_AttackMod = new javax.swing.JSpinner();
        MonsterEdit_AttackTags = new javax.swing.JButton();
        MonsterEdit_MiddlePane = new javax.swing.JPanel();
        MonsterEdit_SpecialQualitiesPane = new javax.swing.JPanel();
        MonsterEdit_SpecialQualitiesControlsPane = new javax.swing.JPanel();
        MonsterEdit_NewSpecialQualities = new javax.swing.JTextField();
        MonsterEdit_RemoveSpecialQualitiesButton = new javax.swing.JButton();
        MonsterEdit_AddSpecialQualitiesButton = new javax.swing.JButton();
        Monster_EditSpecialQualitiesLabel = new javax.swing.JLabel();
        MonsterEdit_SpecialQualitiesScrollPane = new javax.swing.JScrollPane();
        MonsterEdit_SpecialQualitiesList = new javax.swing.JList();
        MonsterEdit_filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MonsterEdit_filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_DescriptionPane = new javax.swing.JPanel();
        MonsterEdit_DescriptionLabel = new javax.swing.JLabel();
        MonsterEdit_filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_InnerDescriptionPane = new javax.swing.JPanel();
        MonsterEdit_DescriptionScrollPane = new javax.swing.JScrollPane();
        MonsterEdit_DescriptionField = new javax.swing.JTextArea();
        MonsterEdit_filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        MonsterEdit_InstinctPane = new javax.swing.JPanel();
        MonsterEdit_InstinctLabel = new javax.swing.JLabel();
        MonsterEdit_InstinctField = new javax.swing.JTextField();
        MonsterEdit_BottomPane = new javax.swing.JPanel();
        MonsterEdit_MovesControlsPane = new javax.swing.JPanel();
        MonsterEdit_NewMove = new javax.swing.JTextField();
        MonsterEdit_RemoveMoveButton = new javax.swing.JButton();
        MonsterEdit_AddMoveButton = new javax.swing.JButton();
        Monster_EditMovesLabel = new javax.swing.JLabel();
        MonsterEdit_MovesScroll = new javax.swing.JScrollPane();
        MonsterEdit_MovesList = new javax.swing.JList();
        MonsterEdit_EndPane = new javax.swing.JPanel();
        MonsterEdit_SaveButton = new javax.swing.JButton();
        MonsterEdit_CancelButton = new javax.swing.JButton();
        MonsterEdit_filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        MonsterEdit_filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonsterEdit_filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonsterEdit_filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MonsterEdit_filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));

        MonsterTagsWindow.setAlwaysOnTop(true);
        MonsterTagsWindow.setMinimumSize(new java.awt.Dimension(300, 300));
        MonsterTagsWindow.setModal(true);
        MonsterTagsWindow.setResizable(false);

        MonTagWin_MainPane.setLayout(new java.awt.BorderLayout());

        MonTagWin_GridPane.setLayout(new java.awt.GridLayout(12, 2));

        MonTagWin_MonsterTagsLabel.setText("Monster Tags:");
        MonTagWin_GridPane.add(MonTagWin_MonsterTagsLabel);

        MonTagWin_OrgTagsLabel.setText("Organization Tags:");
        MonTagWin_GridPane.add(MonTagWin_OrgTagsLabel);

        MonTagWin_Magical.setText("Magical");
        MonTagWin_Magical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonTagWin_MagicalActionPerformed(evt);
            }
        });
        MonTagWin_GridPane.add(MonTagWin_Magical);

        MonTagsWin_OrgTagsGroup.add(MonTagWin_Horde);
        MonTagWin_Horde.setText("Horde");
        MonTagWin_GridPane.add(MonTagWin_Horde);

        MonTagWin_Devious.setText("Devious");
        MonTagWin_GridPane.add(MonTagWin_Devious);

        MonTagsWin_OrgTagsGroup.add(MonTagWin_Group);
        MonTagWin_Group.setText("Group");
        MonTagWin_Group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonTagWin_GroupActionPerformed(evt);
            }
        });
        MonTagWin_GridPane.add(MonTagWin_Group);

        MonTagWin_Amorphous.setText("Amorphous");
        MonTagWin_GridPane.add(MonTagWin_Amorphous);

        MonTagsWin_OrgTagsGroup.add(MonTagWin_Solitary);
        MonTagWin_Solitary.setText("Solitary");
        MonTagWin_GridPane.add(MonTagWin_Solitary);

        MonTagWin_Organized.setText("Organized");
        MonTagWin_GridPane.add(MonTagWin_Organized);
        MonTagWin_GridPane.add(MonTagWin_filler6);

        MonTagWin_Intelligent.setText("Intelligent");
        MonTagWin_GridPane.add(MonTagWin_Intelligent);

        MonTagWin_SizeTagsLabel.setText("Size Tags:");
        MonTagWin_GridPane.add(MonTagWin_SizeTagsLabel);

        MonTagWin_Hoarder.setText("Hoarder");
        MonTagWin_GridPane.add(MonTagWin_Hoarder);

        MonTagsWin_SizeTagsGroup.add(MonTagWin_Tiny);
        MonTagWin_Tiny.setText("Tiny");
        MonTagWin_GridPane.add(MonTagWin_Tiny);

        MonTagWin_Stealthy.setText("Stealthy");
        MonTagWin_GridPane.add(MonTagWin_Stealthy);

        MonTagsWin_SizeTagsGroup.add(MonTagWin_Small);
        MonTagWin_Small.setText("Small");
        MonTagWin_GridPane.add(MonTagWin_Small);

        MonTagWin_Terrifying.setText("Terrifying");
        MonTagWin_GridPane.add(MonTagWin_Terrifying);

        MonTagsWin_SizeTagsGroup.add(MonTagWin_Normal);
        MonTagWin_Normal.setText("Normal");
        MonTagWin_GridPane.add(MonTagWin_Normal);

        MonTagWin_Cautious.setText("Cautious");
        MonTagWin_GridPane.add(MonTagWin_Cautious);

        MonTagsWin_SizeTagsGroup.add(MonTagWin_Large);
        MonTagWin_Large.setText("Large");
        MonTagWin_GridPane.add(MonTagWin_Large);

        MonTagWin_Construct.setText("Construct");
        MonTagWin_GridPane.add(MonTagWin_Construct);

        MonTagsWin_SizeTagsGroup.add(MonTagWin_Huge);
        MonTagWin_Huge.setText("Huge");
        MonTagWin_GridPane.add(MonTagWin_Huge);

        MonTagWin_Planar.setText("Planar");
        MonTagWin_GridPane.add(MonTagWin_Planar);

        MonTagWin_MainPane.add(MonTagWin_GridPane, java.awt.BorderLayout.CENTER);

        MonTagWin_ButtonPane.setLayout(new java.awt.BorderLayout());

        MonTagWin_CancelButton.setText("Cancel");
        MonTagWin_CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonTagWin_CancelButtonActionPerformed(evt);
            }
        });
        MonTagWin_ButtonPane.add(MonTagWin_CancelButton, java.awt.BorderLayout.WEST);

        MonTagWin_SaveButton.setText("Save");
        MonTagWin_SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonTagWin_SaveButtonActionPerformed(evt);
            }
        });
        MonTagWin_ButtonPane.add(MonTagWin_SaveButton, java.awt.BorderLayout.EAST);
        MonTagWin_ButtonPane.add(MonTagWin_filler5, java.awt.BorderLayout.NORTH);

        MonTagWin_MainPane.add(MonTagWin_ButtonPane, java.awt.BorderLayout.SOUTH);

        MonsterTagsWindow.getContentPane().add(MonTagWin_MainPane, java.awt.BorderLayout.CENTER);
        MonsterTagsWindow.getContentPane().add(MonTagWin_filler1, java.awt.BorderLayout.WEST);
        MonsterTagsWindow.getContentPane().add(MonTagWin_filler2, java.awt.BorderLayout.EAST);
        MonsterTagsWindow.getContentPane().add(MonTagWin_filler3, java.awt.BorderLayout.NORTH);
        MonsterTagsWindow.getContentPane().add(MonTagWin_filler4, java.awt.BorderLayout.SOUTH);

        AttackTagsWindow.setAlwaysOnTop(true);
        AttackTagsWindow.setModal(true);
        AttackTagsWindow.setResizable(false);
        AttackTagsWindow.setSize(new java.awt.Dimension(300, 300));

        AttTagWin_MainPane.setLayout(new java.awt.BorderLayout());

        AttTagWin_MainLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        AttTagWin_MainLabel.setText(" Attack Tags:");
        AttTagWin_MainLabel.setPreferredSize(new java.awt.Dimension(88, 25));
        AttTagWin_MainPane.add(AttTagWin_MainLabel, java.awt.BorderLayout.NORTH);

        AttTagWin_GridPane.setLayout(new java.awt.GridLayout(7, 2));

        AttTagWin_AmmoBox.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        AttTagWin_AmmoBox.add(AttTagWin_AmmoCheck);

        AttTagWin_AmmoSpin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        AttTagWin_AmmoSpin.setPreferredSize(new java.awt.Dimension(55, 28));
        AttTagWin_AmmoBox.add(AttTagWin_AmmoSpin);

        AttTagWin_AmmoLabel.setText(" Ammo");
        AttTagWin_AmmoBox.add(AttTagWin_AmmoLabel);

        AttTagWin_GridPane.add(AttTagWin_AmmoBox);

        AttTagWin_StunCheck.setText("Stun");
        AttTagWin_GridPane.add(AttTagWin_StunCheck);

        AttTagWin_ForcefulCheck.setText("Forceful");
        AttTagWin_ForcefulCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTagWin_ForcefulCheckActionPerformed(evt);
            }
        });
        AttTagWin_GridPane.add(AttTagWin_ForcefulCheck);

        AttTagWin_ThrownCheck.setText("Thrown");
        AttTagWin_ThrownCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTagWin_ThrownCheckActionPerformed(evt);
            }
        });
        AttTagWin_GridPane.add(AttTagWin_ThrownCheck);

        AttTagWin_IgnoresArmorCheck.setText("Ignores Armor");
        AttTagWin_GridPane.add(AttTagWin_IgnoresArmorCheck);

        AttTagWin_HandCheck.setText("Hand");
        AttTagWin_GridPane.add(AttTagWin_HandCheck);

        AttTagWin_MessyCheck.setText("Messy");
        AttTagWin_GridPane.add(AttTagWin_MessyCheck);

        AttTagWin_CloseCheck.setText("Close");
        AttTagWin_GridPane.add(AttTagWin_CloseCheck);

        AttTagWin_PiercingBox.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 2));
        AttTagWin_PiercingBox.add(AttTagWin_PiercingCheck);

        AttTagWin_PiercingSpin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        AttTagWin_PiercingBox.add(AttTagWin_PiercingSpin);

        AttTagWin_PiercingLabel.setText(" Piercing");
        AttTagWin_PiercingBox.add(AttTagWin_PiercingLabel);

        AttTagWin_GridPane.add(AttTagWin_PiercingBox);

        AttTagWin_ReachChange.setText("Reach");
        AttTagWin_GridPane.add(AttTagWin_ReachChange);

        AttTagWin_PreciseCheck.setText("Precise");
        AttTagWin_PreciseCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTagWin_PreciseCheckActionPerformed(evt);
            }
        });
        AttTagWin_GridPane.add(AttTagWin_PreciseCheck);

        AttTagWin_NearCheck.setText("Near");
        AttTagWin_GridPane.add(AttTagWin_NearCheck);

        AttTagWin_ReloadCheck.setText("Reload");
        AttTagWin_GridPane.add(AttTagWin_ReloadCheck);

        AttTagWin_FarCheck.setText("Far");
        AttTagWin_GridPane.add(AttTagWin_FarCheck);

        AttTagWin_MainPane.add(AttTagWin_GridPane, java.awt.BorderLayout.CENTER);

        AttTagWin_ButtonBox.setLayout(new java.awt.BorderLayout());

        AttTagWin_CancelButton.setText("Cancel");
        AttTagWin_CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTagWin_CancelButtonActionPerformed(evt);
            }
        });
        AttTagWin_ButtonBox.add(AttTagWin_CancelButton, java.awt.BorderLayout.WEST);

        AttTagWin_AttackButton.setText("Save");
        AttTagWin_AttackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttTagWin_AttackButtonActionPerformed(evt);
            }
        });
        AttTagWin_ButtonBox.add(AttTagWin_AttackButton, java.awt.BorderLayout.EAST);

        AttTagWin_MainPane.add(AttTagWin_ButtonBox, java.awt.BorderLayout.PAGE_END);

        AttackTagsWindow.getContentPane().add(AttTagWin_MainPane, java.awt.BorderLayout.CENTER);
        AttackTagsWindow.getContentPane().add(AttTagWin_filler1, java.awt.BorderLayout.NORTH);
        AttackTagsWindow.getContentPane().add(AttTagWin_filler2, java.awt.BorderLayout.SOUTH);
        AttackTagsWindow.getContentPane().add(AttTagWin_filler3, java.awt.BorderLayout.WEST);
        AttackTagsWindow.getContentPane().add(AttTagWin_filler4, java.awt.BorderLayout.EAST);

        setPreferredSize(new java.awt.Dimension(700, 600));
        setSize(new java.awt.Dimension(700, 600));
        setLayout(new java.awt.BorderLayout());

        MonsterEdit_MainPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_TopPane.setLayout(new java.awt.GridLayout(0, 1));

        MonsterEdit_Row1.setLayout(new java.awt.BorderLayout());

        MonsterEdit_NameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MonsterEdit_NameLabel.setText("Name:");
        MonsterEdit_NamePane.add(MonsterEdit_NameLabel);

        MonsterEdit_NameField.setPreferredSize(new java.awt.Dimension(300, 28));
        MonsterEdit_NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_NameFieldActionPerformed(evt);
            }
        });
        MonsterEdit_NamePane.add(MonsterEdit_NameField);

        MonsterEdit_Row1.add(MonsterEdit_NamePane, java.awt.BorderLayout.WEST);

        MonsterEdit_MonsterTagsButton.setText("Monster Tags");
        MonsterEdit_MonsterTagsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_MonsterTagsButtonActionPerformed(evt);
            }
        });
        MonsterEdit_Row1.add(MonsterEdit_MonsterTagsButton, java.awt.BorderLayout.EAST);

        MonsterEdit_TopPane.add(MonsterEdit_Row1);

        MonsterEdit_Row2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        MonsterEdit_HPValue.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        MonsterEdit_Row2.add(MonsterEdit_HPValue);

        MonsterEdit_HPLabel.setText("HP      ");
        MonsterEdit_Row2.add(MonsterEdit_HPLabel);

        MonsterEdit_ArmorValue.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        MonsterEdit_Row2.add(MonsterEdit_ArmorValue);

        MonsterEdit_ArmorLabel.setText("Armor");
        MonsterEdit_Row2.add(MonsterEdit_ArmorLabel);

        MonsterEdit_TopPane.add(MonsterEdit_Row2);

        MonsterEdit_Row3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        MonsterEdit_AttackNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MonsterEdit_AttackNameLabel.setText("Attack Name:");
        MonsterEdit_Row3.add(MonsterEdit_AttackNameLabel);

        MonsterEdit_AttackNameField.setPreferredSize(new java.awt.Dimension(175, 28));
        MonsterEdit_AttackNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_AttackNameFieldActionPerformed(evt);
            }
        });
        MonsterEdit_Row3.add(MonsterEdit_AttackNameField);

        MonsterEdit_Rolls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Best of 2", "Worst of 2" }));
        MonsterEdit_Row3.add(MonsterEdit_Rolls);

        MonsterEdit_Dice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "d4", "d6", "d8", "d10", "d12", "d20" }));
        MonsterEdit_Row3.add(MonsterEdit_Dice);

        MonsterEdit_AttackMod.setModel(new javax.swing.SpinnerNumberModel(0, -20, 20, 1));
        MonsterEdit_AttackMod.setVerifyInputWhenFocusTarget(false);
        MonsterEdit_Row3.add(MonsterEdit_AttackMod);

        MonsterEdit_AttackTags.setText("Attack Tags");
        MonsterEdit_AttackTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_AttackTagsActionPerformed(evt);
            }
        });
        MonsterEdit_Row3.add(MonsterEdit_AttackTags);

        MonsterEdit_TopPane.add(MonsterEdit_Row3);

        MonsterEdit_MainPane.add(MonsterEdit_TopPane, java.awt.BorderLayout.NORTH);

        MonsterEdit_MiddlePane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_SpecialQualitiesPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_SpecialQualitiesControlsPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_NewSpecialQualities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_NewSpecialQualitiesActionPerformed(evt);
            }
        });
        MonsterEdit_SpecialQualitiesControlsPane.add(MonsterEdit_NewSpecialQualities, java.awt.BorderLayout.CENTER);

        MonsterEdit_RemoveSpecialQualitiesButton.setText("Remove");
        MonsterEdit_RemoveSpecialQualitiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_RemoveSpecialQualitiesButtonActionPerformed(evt);
            }
        });
        MonsterEdit_SpecialQualitiesControlsPane.add(MonsterEdit_RemoveSpecialQualitiesButton, java.awt.BorderLayout.LINE_START);

        MonsterEdit_AddSpecialQualitiesButton.setText("Add Qualities");
        MonsterEdit_AddSpecialQualitiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_AddSpecialQualitiesButtonActionPerformed(evt);
            }
        });
        MonsterEdit_SpecialQualitiesControlsPane.add(MonsterEdit_AddSpecialQualitiesButton, java.awt.BorderLayout.LINE_END);

        Monster_EditSpecialQualitiesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        Monster_EditSpecialQualitiesLabel.setText(" Special Qualities:");
        MonsterEdit_SpecialQualitiesControlsPane.add(Monster_EditSpecialQualitiesLabel, java.awt.BorderLayout.PAGE_START);

        MonsterEdit_SpecialQualitiesPane.add(MonsterEdit_SpecialQualitiesControlsPane, java.awt.BorderLayout.NORTH);

        MonsterEdit_SpecialQualitiesScrollPane.setPreferredSize(new java.awt.Dimension(43, 75));

        MonsterEdit_SpecialQualitiesList.setModel(MonsterEdit_ModelQualityList);
        MonsterEdit_SpecialQualitiesScrollPane.setViewportView(MonsterEdit_SpecialQualitiesList);

        MonsterEdit_SpecialQualitiesPane.add(MonsterEdit_SpecialQualitiesScrollPane, java.awt.BorderLayout.CENTER);
        MonsterEdit_SpecialQualitiesPane.add(MonsterEdit_filler9, java.awt.BorderLayout.SOUTH);
        MonsterEdit_SpecialQualitiesPane.add(MonsterEdit_filler10, java.awt.BorderLayout.WEST);
        MonsterEdit_SpecialQualitiesPane.add(MonsterEdit_filler11, java.awt.BorderLayout.EAST);

        MonsterEdit_MiddlePane.add(MonsterEdit_SpecialQualitiesPane, java.awt.BorderLayout.NORTH);

        MonsterEdit_DescriptionPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_DescriptionLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MonsterEdit_DescriptionLabel.setText(" Description:");
        MonsterEdit_DescriptionPane.add(MonsterEdit_DescriptionLabel, java.awt.BorderLayout.NORTH);
        MonsterEdit_DescriptionPane.add(MonsterEdit_filler1, java.awt.BorderLayout.WEST);
        MonsterEdit_DescriptionPane.add(MonsterEdit_filler2, java.awt.BorderLayout.EAST);

        MonsterEdit_InnerDescriptionPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_DescriptionField.setColumns(20);
        MonsterEdit_DescriptionField.setLineWrap(true);
        MonsterEdit_DescriptionField.setRows(5);
        MonsterEdit_DescriptionScrollPane.setViewportView(MonsterEdit_DescriptionField);

        MonsterEdit_InnerDescriptionPane.add(MonsterEdit_DescriptionScrollPane, java.awt.BorderLayout.CENTER);
        MonsterEdit_InnerDescriptionPane.add(MonsterEdit_filler12, java.awt.BorderLayout.PAGE_START);

        MonsterEdit_DescriptionPane.add(MonsterEdit_InnerDescriptionPane, java.awt.BorderLayout.CENTER);

        MonsterEdit_MiddlePane.add(MonsterEdit_DescriptionPane, java.awt.BorderLayout.CENTER);

        MonsterEdit_InstinctPane.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        MonsterEdit_InstinctLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        MonsterEdit_InstinctLabel.setText("Instinct:");
        MonsterEdit_InstinctPane.add(MonsterEdit_InstinctLabel);

        MonsterEdit_InstinctField.setPreferredSize(new java.awt.Dimension(300, 28));
        MonsterEdit_InstinctField.setSize(new java.awt.Dimension(200, 28));
        MonsterEdit_InstinctPane.add(MonsterEdit_InstinctField);

        MonsterEdit_MiddlePane.add(MonsterEdit_InstinctPane, java.awt.BorderLayout.SOUTH);

        MonsterEdit_MainPane.add(MonsterEdit_MiddlePane, java.awt.BorderLayout.CENTER);

        MonsterEdit_BottomPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_MovesControlsPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_NewMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_NewMoveActionPerformed(evt);
            }
        });
        MonsterEdit_MovesControlsPane.add(MonsterEdit_NewMove, java.awt.BorderLayout.CENTER);

        MonsterEdit_RemoveMoveButton.setText("Remove");
        MonsterEdit_RemoveMoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_RemoveMoveButtonActionPerformed(evt);
            }
        });
        MonsterEdit_MovesControlsPane.add(MonsterEdit_RemoveMoveButton, java.awt.BorderLayout.LINE_START);

        MonsterEdit_AddMoveButton.setText("Add Move");
        MonsterEdit_AddMoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_AddMoveButtonActionPerformed(evt);
            }
        });
        MonsterEdit_MovesControlsPane.add(MonsterEdit_AddMoveButton, java.awt.BorderLayout.LINE_END);

        Monster_EditMovesLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        Monster_EditMovesLabel.setText(" Moves");
        MonsterEdit_MovesControlsPane.add(Monster_EditMovesLabel, java.awt.BorderLayout.PAGE_START);

        MonsterEdit_BottomPane.add(MonsterEdit_MovesControlsPane, java.awt.BorderLayout.NORTH);

        MonsterEdit_MovesScroll.setPreferredSize(new java.awt.Dimension(100, 75));

        MonsterEdit_MovesList.setModel(MonsterEdit_ModelMoveList);
        MonsterEdit_MovesScroll.setViewportView(MonsterEdit_MovesList);

        MonsterEdit_BottomPane.add(MonsterEdit_MovesScroll, java.awt.BorderLayout.CENTER);

        MonsterEdit_EndPane.setLayout(new java.awt.BorderLayout());

        MonsterEdit_SaveButton.setText("Save");
        MonsterEdit_SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_SaveButtonActionPerformed(evt);
            }
        });
        MonsterEdit_EndPane.add(MonsterEdit_SaveButton, java.awt.BorderLayout.EAST);

        MonsterEdit_CancelButton.setText("Cancel");
        MonsterEdit_CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterEdit_CancelButtonActionPerformed(evt);
            }
        });
        MonsterEdit_EndPane.add(MonsterEdit_CancelButton, java.awt.BorderLayout.WEST);

        MonsterEdit_BottomPane.add(MonsterEdit_EndPane, java.awt.BorderLayout.SOUTH);
        MonsterEdit_BottomPane.add(MonsterEdit_filler3, java.awt.BorderLayout.WEST);
        MonsterEdit_BottomPane.add(MonsterEdit_filler4, java.awt.BorderLayout.EAST);

        MonsterEdit_MainPane.add(MonsterEdit_BottomPane, java.awt.BorderLayout.SOUTH);

        add(MonsterEdit_MainPane, java.awt.BorderLayout.CENTER);
        add(MonsterEdit_filler5, java.awt.BorderLayout.WEST);
        add(MonsterEdit_filler6, java.awt.BorderLayout.EAST);
        add(MonsterEdit_filler7, java.awt.BorderLayout.NORTH);
        add(MonsterEdit_filler8, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void MonsterEdit_NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonsterEdit_NameFieldActionPerformed

    private void MonsterEdit_MonsterTagsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_MonsterTagsButtonActionPerformed
        this.MonsterTagsWindow.setVisible(true);
    }//GEN-LAST:event_MonsterEdit_MonsterTagsButtonActionPerformed

    private void MonsterEdit_AttackNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_AttackNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonsterEdit_AttackNameFieldActionPerformed

    private void MonsterEdit_AttackTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_AttackTagsActionPerformed
        this.AttackTagsWindow.setVisible(true);
    }//GEN-LAST:event_MonsterEdit_AttackTagsActionPerformed

    private void MonsterEdit_NewMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_NewMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonsterEdit_NewMoveActionPerformed

    private void MonsterEdit_RemoveMoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_RemoveMoveButtonActionPerformed
        if(this.MonsterEdit_MovesList.getSelectedIndices().length > 0){
            int[] tmp = this.MonsterEdit_MovesList.getSelectedIndices();
            int[] selectedIndices = this.MonsterEdit_MovesList.getSelectedIndices();

            for(int i = tmp.length-1; i>=0; i--){
                selectedIndices = this.MonsterEdit_MovesList.getSelectedIndices();
                MonsterEdit_ModelMoveList.removeElementAt(selectedIndices[i]);

            }
        }
    }//GEN-LAST:event_MonsterEdit_RemoveMoveButtonActionPerformed

    private void MonsterEdit_AddMoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_AddMoveButtonActionPerformed
        MonsterEdit_ModelMoveList.addElement(this.MonsterEdit_NewMove.getText());
        this.MonsterEdit_NewMove.setText("");
    }//GEN-LAST:event_MonsterEdit_AddMoveButtonActionPerformed

    private void MonsterEdit_SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_SaveButtonActionPerformed

        if(!this.validName(this.MonsterEdit_NameField.getText())){
            javax.swing.JOptionPane.showMessageDialog(this,
                "The name of this monster must be unique and nonempty.");
        }else{
            saveMonster();
            owner.dispose();
        }
        
    }//GEN-LAST:event_MonsterEdit_SaveButtonActionPerformed

    private void MonsterEdit_CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_CancelButtonActionPerformed
        owner.dispose();
    }//GEN-LAST:event_MonsterEdit_CancelButtonActionPerformed

    private void MonTagWin_MagicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonTagWin_MagicalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonTagWin_MagicalActionPerformed

    private void MonTagWin_GroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonTagWin_GroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonTagWin_GroupActionPerformed

    private void MonTagWin_CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonTagWin_CancelButtonActionPerformed
        //Reset Window and don't save
        this.MonsterTagsWindow.setVisible(false);
    }//GEN-LAST:event_MonTagWin_CancelButtonActionPerformed

    private void MonTagWin_SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonTagWin_SaveButtonActionPerformed
        //Save!
        this.MonsterTagsWindow.setVisible(false);
    }//GEN-LAST:event_MonTagWin_SaveButtonActionPerformed

    private void AttTagWin_ForcefulCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTagWin_ForcefulCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttTagWin_ForcefulCheckActionPerformed

    private void AttTagWin_ThrownCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTagWin_ThrownCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttTagWin_ThrownCheckActionPerformed

    private void AttTagWin_PreciseCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTagWin_PreciseCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttTagWin_PreciseCheckActionPerformed

    private void AttTagWin_CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTagWin_CancelButtonActionPerformed
        //Reset Window and don't save
        this.AttackTagsWindow.setVisible(false);
    }//GEN-LAST:event_AttTagWin_CancelButtonActionPerformed

    private void AttTagWin_AttackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttTagWin_AttackButtonActionPerformed
        //Save!
        this.AttackTagsWindow.setVisible(false);
    }//GEN-LAST:event_AttTagWin_AttackButtonActionPerformed

    private void MonsterEdit_NewSpecialQualitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_NewSpecialQualitiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonsterEdit_NewSpecialQualitiesActionPerformed

    private void MonsterEdit_RemoveSpecialQualitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_RemoveSpecialQualitiesButtonActionPerformed
        if(this.MonsterEdit_SpecialQualitiesList.getSelectedIndices().length > 0){
            int[] tmp = this.MonsterEdit_SpecialQualitiesList.getSelectedIndices();
            int[] selectedIndices = this.MonsterEdit_SpecialQualitiesList.getSelectedIndices();

            for(int i = tmp.length-1; i>=0; i--){
                selectedIndices = this.MonsterEdit_SpecialQualitiesList.getSelectedIndices();
                MonsterEdit_ModelQualityList.removeElementAt(selectedIndices[i]);

            }
        }
    }//GEN-LAST:event_MonsterEdit_RemoveSpecialQualitiesButtonActionPerformed

    private void MonsterEdit_AddSpecialQualitiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterEdit_AddSpecialQualitiesButtonActionPerformed
        MonsterEdit_ModelQualityList.addElement(this.MonsterEdit_NewSpecialQualities.getText());
        this.MonsterEdit_NewSpecialQualities.setText("");
    }//GEN-LAST:event_MonsterEdit_AddSpecialQualitiesButtonActionPerformed

    private javax.swing.DefaultListModel MonsterEdit_ModelMoveList;
    private javax.swing.DefaultListModel MonsterEdit_ModelQualityList;
    private javax.swing.JDialog owner;
    private Monster mon;
    private MonsterList listy;
    private BestiaryGUI mainWin;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AttTagWin_AmmoBox;
    private javax.swing.JCheckBox AttTagWin_AmmoCheck;
    private javax.swing.JLabel AttTagWin_AmmoLabel;
    private javax.swing.JSpinner AttTagWin_AmmoSpin;
    private javax.swing.JButton AttTagWin_AttackButton;
    private javax.swing.JPanel AttTagWin_ButtonBox;
    private javax.swing.JButton AttTagWin_CancelButton;
    private javax.swing.JCheckBox AttTagWin_CloseCheck;
    private javax.swing.JCheckBox AttTagWin_FarCheck;
    private javax.swing.JCheckBox AttTagWin_ForcefulCheck;
    private javax.swing.JPanel AttTagWin_GridPane;
    private javax.swing.JCheckBox AttTagWin_HandCheck;
    private javax.swing.JCheckBox AttTagWin_IgnoresArmorCheck;
    private javax.swing.JLabel AttTagWin_MainLabel;
    private javax.swing.JPanel AttTagWin_MainPane;
    private javax.swing.JCheckBox AttTagWin_MessyCheck;
    private javax.swing.JCheckBox AttTagWin_NearCheck;
    private javax.swing.JPanel AttTagWin_PiercingBox;
    private javax.swing.JCheckBox AttTagWin_PiercingCheck;
    private javax.swing.JLabel AttTagWin_PiercingLabel;
    private javax.swing.JSpinner AttTagWin_PiercingSpin;
    private javax.swing.JCheckBox AttTagWin_PreciseCheck;
    private javax.swing.JCheckBox AttTagWin_ReachChange;
    private javax.swing.JCheckBox AttTagWin_ReloadCheck;
    private javax.swing.JCheckBox AttTagWin_StunCheck;
    private javax.swing.JCheckBox AttTagWin_ThrownCheck;
    private javax.swing.Box.Filler AttTagWin_filler1;
    private javax.swing.Box.Filler AttTagWin_filler2;
    private javax.swing.Box.Filler AttTagWin_filler3;
    private javax.swing.Box.Filler AttTagWin_filler4;
    private javax.swing.JDialog AttackTagsWindow;
    private javax.swing.JCheckBox MonTagWin_Amorphous;
    private javax.swing.JPanel MonTagWin_ButtonPane;
    private javax.swing.JButton MonTagWin_CancelButton;
    private javax.swing.JCheckBox MonTagWin_Cautious;
    private javax.swing.JCheckBox MonTagWin_Construct;
    private javax.swing.JCheckBox MonTagWin_Devious;
    private javax.swing.JPanel MonTagWin_GridPane;
    private javax.swing.JRadioButton MonTagWin_Group;
    private javax.swing.JCheckBox MonTagWin_Hoarder;
    private javax.swing.JRadioButton MonTagWin_Horde;
    private javax.swing.JRadioButton MonTagWin_Huge;
    private javax.swing.JCheckBox MonTagWin_Intelligent;
    private javax.swing.JRadioButton MonTagWin_Large;
    private javax.swing.JCheckBox MonTagWin_Magical;
    private javax.swing.JPanel MonTagWin_MainPane;
    private javax.swing.JLabel MonTagWin_MonsterTagsLabel;
    private javax.swing.JRadioButton MonTagWin_Normal;
    private javax.swing.JLabel MonTagWin_OrgTagsLabel;
    private javax.swing.JCheckBox MonTagWin_Organized;
    private javax.swing.JCheckBox MonTagWin_Planar;
    private javax.swing.JButton MonTagWin_SaveButton;
    private javax.swing.JLabel MonTagWin_SizeTagsLabel;
    private javax.swing.JRadioButton MonTagWin_Small;
    private javax.swing.JRadioButton MonTagWin_Solitary;
    private javax.swing.JCheckBox MonTagWin_Stealthy;
    private javax.swing.JCheckBox MonTagWin_Terrifying;
    private javax.swing.JRadioButton MonTagWin_Tiny;
    private javax.swing.Box.Filler MonTagWin_filler1;
    private javax.swing.Box.Filler MonTagWin_filler2;
    private javax.swing.Box.Filler MonTagWin_filler3;
    private javax.swing.Box.Filler MonTagWin_filler4;
    private javax.swing.Box.Filler MonTagWin_filler5;
    private javax.swing.Box.Filler MonTagWin_filler6;
    private javax.swing.ButtonGroup MonTagsWin_OrgTagsGroup;
    private javax.swing.ButtonGroup MonTagsWin_SizeTagsGroup;
    private javax.swing.JButton MonsterEdit_AddMoveButton;
    private javax.swing.JButton MonsterEdit_AddSpecialQualitiesButton;
    private javax.swing.JLabel MonsterEdit_ArmorLabel;
    private javax.swing.JSpinner MonsterEdit_ArmorValue;
    private javax.swing.JSpinner MonsterEdit_AttackMod;
    private javax.swing.JTextField MonsterEdit_AttackNameField;
    private javax.swing.JLabel MonsterEdit_AttackNameLabel;
    private javax.swing.JButton MonsterEdit_AttackTags;
    private javax.swing.JPanel MonsterEdit_BottomPane;
    private javax.swing.JButton MonsterEdit_CancelButton;
    private javax.swing.JTextArea MonsterEdit_DescriptionField;
    private javax.swing.JLabel MonsterEdit_DescriptionLabel;
    private javax.swing.JPanel MonsterEdit_DescriptionPane;
    private javax.swing.JScrollPane MonsterEdit_DescriptionScrollPane;
    private javax.swing.JComboBox MonsterEdit_Dice;
    private javax.swing.JPanel MonsterEdit_EndPane;
    private javax.swing.JLabel MonsterEdit_HPLabel;
    private javax.swing.JSpinner MonsterEdit_HPValue;
    private javax.swing.JPanel MonsterEdit_InnerDescriptionPane;
    private javax.swing.JTextField MonsterEdit_InstinctField;
    private javax.swing.JLabel MonsterEdit_InstinctLabel;
    private javax.swing.JPanel MonsterEdit_InstinctPane;
    private javax.swing.JPanel MonsterEdit_MainPane;
    private javax.swing.JPanel MonsterEdit_MiddlePane;
    private javax.swing.JButton MonsterEdit_MonsterTagsButton;
    private javax.swing.JPanel MonsterEdit_MovesControlsPane;
    private javax.swing.JList MonsterEdit_MovesList;
    private javax.swing.JScrollPane MonsterEdit_MovesScroll;
    private javax.swing.JTextField MonsterEdit_NameField;
    private javax.swing.JLabel MonsterEdit_NameLabel;
    private javax.swing.JPanel MonsterEdit_NamePane;
    private javax.swing.JTextField MonsterEdit_NewMove;
    private javax.swing.JTextField MonsterEdit_NewSpecialQualities;
    private javax.swing.JButton MonsterEdit_RemoveMoveButton;
    private javax.swing.JButton MonsterEdit_RemoveSpecialQualitiesButton;
    private javax.swing.JComboBox MonsterEdit_Rolls;
    private javax.swing.JPanel MonsterEdit_Row1;
    private javax.swing.JPanel MonsterEdit_Row2;
    private javax.swing.JPanel MonsterEdit_Row3;
    private javax.swing.JButton MonsterEdit_SaveButton;
    private javax.swing.JPanel MonsterEdit_SpecialQualitiesControlsPane;
    private javax.swing.JList MonsterEdit_SpecialQualitiesList;
    private javax.swing.JPanel MonsterEdit_SpecialQualitiesPane;
    private javax.swing.JScrollPane MonsterEdit_SpecialQualitiesScrollPane;
    private javax.swing.JPanel MonsterEdit_TopPane;
    private javax.swing.Box.Filler MonsterEdit_filler1;
    private javax.swing.Box.Filler MonsterEdit_filler10;
    private javax.swing.Box.Filler MonsterEdit_filler11;
    private javax.swing.Box.Filler MonsterEdit_filler12;
    private javax.swing.Box.Filler MonsterEdit_filler2;
    private javax.swing.Box.Filler MonsterEdit_filler3;
    private javax.swing.Box.Filler MonsterEdit_filler4;
    private javax.swing.Box.Filler MonsterEdit_filler5;
    private javax.swing.Box.Filler MonsterEdit_filler6;
    private javax.swing.Box.Filler MonsterEdit_filler7;
    private javax.swing.Box.Filler MonsterEdit_filler8;
    private javax.swing.Box.Filler MonsterEdit_filler9;
    private javax.swing.JDialog MonsterTagsWindow;
    private javax.swing.JLabel Monster_EditMovesLabel;
    private javax.swing.JLabel Monster_EditSpecialQualitiesLabel;
    // End of variables declaration//GEN-END:variables
}
