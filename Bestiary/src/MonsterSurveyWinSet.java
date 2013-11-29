/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marthahamlin
 */
public class MonsterSurveyWinSet extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer MonsterSurveyWinSet
     */
    public MonsterSurveyWinSet(javax.swing.JDialog ownr, BestiaryGUI win, MonsterList ls) {
        owner = ownr;
        mon = new Monster();
        working = false;
        listy = ls;
        this.mainWin = win;
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    public void setMonster(Monster m){
        mon = m;
    }
    
    public Monster getMonster(){
        return mon;
    }
    
    public void setList(MonsterList m){
        listy = m;
    }
    
    public MonsterList getList(){
        return listy;
    }
    
    public void setWorking(boolean b){
        working = b;
    }
    
    public boolean getWorking(){
        return working;
    }
    
    public void completeMonsterSurvey(){
        
        processPage1();
        processPage2();
        processPage3();
        processPage4();
        processPage5();
        processPage6();
        processPage7();
        processPage8();
        processPage9();
        
        listy.addMonster(mon);
        
        working = false;
        
        mainWin.validate();
        mainWin.repaint();
        mainWin.setMainMonster(mon);
        owner.dispose();
    }
    
    public boolean validName(String s){
        return (!s.equals("")) && (!listy.containsMonster(s));
    }
    
    public void processPage1(){
        mon.setName(this.mSurveyName.getText());
    }
    
    public void processPage2(){
        String move = this.mSurveyMove.getText();
        if(!move.equals("")){
            mon.addMove(move);
        }
    }
    
    public void processPage3(){
        String inst = this.mSurveyInstinct.getText();
        if(!inst.equals("")){
            mon.setInstinct(inst);
        }
    }
    
    public void processPage4(){
        if(this.mSurveyHorde.isSelected()){
            mon.setMonsterTag(11, true);
            mon.setDmgDice(Dice.D_SIX);
            mon.setHp(3);
        }else if(this.mSurveyGroup.isSelected()){
            mon.setMonsterTag(12, true);
            mon.setDmgDice(Dice.D_EIGHT);
            mon.setHp(6);
        }else if(this.mSurveySolitary.isSelected()){
            mon.setMonsterTag(13, true);
            mon.setDmgDice(Dice.D_TEN);
            mon.setHp(12);        
        }
    }
    
    public void processPage5(){
        if(this.mSurveyTiny.isSelected()){
            mon.setMonsterTag(14, true);
            mon.setAttackTag(9, true);
            mon.changeDmgMod(-2);
        }else if(this.mSurveySmall.isSelected()){
            mon.setMonsterTag(15, true);
            mon.setAttackTag(10, true);
        }else if(this.mSurveyNormal.isSelected()){
            mon.setMonsterTag(16, true);
            mon.setAttackTag(10, true);
        }else if(this.mSurveyLarge.isSelected()){
            mon.setMonsterTag(17, true);
            mon.setAttackTag(10, true);
            mon.setAttackTag(11, true);
            mon.changeHP(4);
            mon.changeDmgMod(1);
        }else if(this.mSurveyHuge.isSelected()){
            mon.setMonsterTag(18, true);
            mon.setAttackTag(11, true);
            mon.changeHP(8);
            mon.changeDmgMod(3);
        }
    }
    
    public void processPage6(){
       if(this.mSurveyDefenseNone.isSelected()){
           mon.setArmor(0);
       }else if(this.mSurveyDefenseBuffaloBill.isSelected()){
           mon.setArmor(1);
       }else if(this.mSurveyDefenseTisButAScratch.isSelected()){
           mon.setArmor(2);
       }else if(this.mSurveyDefenseCubone.isSelected()){
           mon.setArmor(3);
       }else if(this.mSurveyDefenseForceField.isSelected()){
           mon.setArmor(4);
           mon.setMonsterTag(0, true);
       }
    }
    
    public void processPage7(){
        
        if(this.mSurveyInfamousStrength.isSelected()){
            mon.changeDmgMod(2);
            mon.setAttackTag(1, true);
        }
        
        if(this.mSurveyInfamousOffense.isSelected()){
            mon.betterDmgRoll();
        }
        
        if(this.mSurveyInfamousDefense.isSelected()){
            mon.changeArmor(1);
        }
        
        if(this.mSurveyInfamousDeft.isSelected()){
            mon.setAttackTag(4, true);
            mon.changePiercing(1);
        }
        
        if(this.mSurveyInfamousEndurance.isSelected()){
            mon.changeHP(4);
        }
        
        if(this.mSurveyInfamousJoker.isSelected()){
            mon.setMonsterTag(6, true);
            mon.addMove(this.DeceitAndTrickeryField.getText());
        }
        
        if(this.mSurveyInfamousAdapt.isSelected()){
            mon.addSpecialQuality(this.UsefulAdaptField.getText());
        }
        
        if(this.mSurveyInfamousGodsLoveMe.isSelected()){
            if(this.FavorOfGodsPlusDamage.isSelected()){
                mon.changeDmgMod(2);
            }
            
            if(this.FavorOfGodsPlusHP.isSelected()){
                mon.changeHP(2);
            }
        }
        
        if(this.mSurveyInfamousMagicMissile.isSelected()){
            mon.setMonsterTag(0, true);
            mon.addMove(this.SpellsAndMagicField.getText());
        }

    }
    
    public void processPage8(){
        
        if(this.mSurveyAttackVicious.isSelected()){
            mon.changeDmgMod(2);
        }
        
        if(this.mSurveyAttackBay.isSelected()){
            mon.setAttackTag(11, true);
        }
        
        if(this.mSurveyAttackWeak.isSelected()){
            mon.decreaseDmgDice();
        }
        
        if(this.mSurveyAttackMetal.isSelected()){
            mon.setAttackTag(3, true);
            
            if(this.SliceOrPiercePlusOne.isSelected()){
               mon.changePiercing(1);
            }else{
               mon.changePiercing(3);
            }
        }
        
        if(this.mSurveyAttackWhereIsYourGodNow.isSelected()){
            mon.setAttackTag(2, true);
        }
        
        if(this.mSurveyAttackRanged.isSelected()){
            if(this.AttacksAtRangeNear.isSelected()){
                mon.setAttackTag(12, true);
            }
            
            if(this.AttacksAtRangeFar.isSelected()){
                mon.setAttackTag(13, true);
            }
        }
        
    }
    
    public void processPage9(){
        if(this.mSurveyDescTricksyDamage.isSelected()){
            mon.setMonsterTag(1, true);
            mon.decreaseDmgDice();
            mon.addMove(this.DeceitAndTrickeryField.getText());
        }
        
        if(this.mSurveyDescOrganized.isSelected()){
            mon.setMonsterTag(3, true);
            mon.addMove(this.OrganizeGroupsField.getText());
        }
        
        if(this.mSurveyDescSmartass.isSelected()){
            mon.setMonsterTag(4, true);
        }
        
        if(this.mSurveyDescShield.isSelected()){
            mon.setMonsterTag(8, true);
            mon.changeArmor(1);
        }
        
        if(this.mSurveyDescTrinkets.isSelected()){
            mon.setMonsterTag(5, true);
        }
        
        if(this.mSurveyDescBeyond.isSelected()){
            mon.setMonsterTag(10, true);
            mon.addSpecialQuality(this.OtherWorldField.getText());
        }
        
        if(this.mSurveyDescProppedUp.isSelected()){
            mon.changeHP(4);
        }
        
        if(this.mSurveyDescMade.isSelected()){
            mon.setMonsterTag(9, true);
            mon.addSpecialQuality(this.MadeField.getText());
        }
        
        if(this.mSurveyDescLooksWickedAwful.isSelected()){
            mon.setMonsterTag(7, true);
            mon.addSpecialQuality(this.AppearanceField.getText());
        }
        
        if(this.mSurveyDescProbablySlime.isSelected()){
            mon.setMonsterTag(2, true);
            mon.changeArmor(1);
            mon.changeHP(3);
        }
        
        if(this.mSurveyDescGetOffMyLawn.isSelected()){
            mon.increaseDmgDice();
        }
        
        if(this.mSurveyDescTreeHugger.isSelected()){
            mon.worseDmgRoll();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mSurveyGroupHuntSize = new javax.swing.ButtonGroup();
        mSurveySize = new javax.swing.ButtonGroup();
        mSurveyDefense = new javax.swing.ButtonGroup();
        DeceitAndTrickeryWindow = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        DeceitAndTrickeryOkay = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DeceitAndTrickeryField = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        UsefulAdaptWindow = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        UsefulAdaptOkay = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        UsefulAdaptField = new javax.swing.JTextField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        FavorOfGodsWindow = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        FavorOfGodsOkay = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        FavorOfGodsPlusDamage = new javax.swing.JCheckBox();
        FavorOfGodsPlusHP = new javax.swing.JCheckBox();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        SpellsAndMagicWindow = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        SpellsAndMagicOkay = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SpellsAndMagicField = new javax.swing.JTextField();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        SliceOrPierceGroup = new javax.swing.ButtonGroup();
        SliceOrPierceWindow = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        SliceOrPierceOkay = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        SliceOrPiercePlusOne = new javax.swing.JRadioButton();
        SliceOrPiercePlusThree = new javax.swing.JRadioButton();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        AttacksAtRangeWindow = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        AttacksAtRangeOkay = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        AttacksAtRangeNear = new javax.swing.JCheckBox();
        AttacksAtRangeFar = new javax.swing.JCheckBox();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        DangerousReasonsWindow = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        DangerousReasonsOkay = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        DangerousReasonsField = new javax.swing.JTextField();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        OrganizeGroupsWindow = new javax.swing.JDialog();
        jPanel15 = new javax.swing.JPanel();
        OrganizeGroupsOkay = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        OrganizeGroupsField = new javax.swing.JTextField();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        OtherWorldWindow = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        OtherWorldOkay = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        OtherWorldField = new javax.swing.JTextField();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MadeWindow = new javax.swing.JDialog();
        jPanel19 = new javax.swing.JPanel();
        MadeOkay = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        MadeField = new javax.swing.JTextField();
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        AppearanceWindow = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        AppearanceOkay = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        AppearanceField = new javax.swing.JTextField();
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        filler32 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler33 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        MonsterSurvey_MainPane = new javax.swing.JPanel();
        mSurveyStep1 = new javax.swing.JPanel();
        mSurveyStep1Panel = new javax.swing.JPanel();
        mSurveyNameLabel = new javax.swing.JLabel();
        mSurveyName = new javax.swing.JTextField();
        mSurveyStep2 = new javax.swing.JPanel();
        mSurveyStep2Panel = new javax.swing.JPanel();
        mSurveyMoveLabel = new javax.swing.JLabel();
        mSurveyMove = new javax.swing.JTextField();
        mSurveyStep3 = new javax.swing.JPanel();
        mSurveyStep3Panel = new javax.swing.JPanel();
        mSurveyInstinctLabel = new javax.swing.JLabel();
        mSurveyInstinct = new javax.swing.JTextField();
        mSurveyStep4 = new javax.swing.JPanel();
        mSurveyStep4Panel = new javax.swing.JPanel();
        mSurveyHuntSizeLabel = new javax.swing.JLabel();
        mSurveyHorde = new javax.swing.JRadioButton();
        mSurveyGroup = new javax.swing.JRadioButton();
        mSurveySolitary = new javax.swing.JRadioButton();
        mSurveyStep5 = new javax.swing.JPanel();
        mSurveyStep5Panel = new javax.swing.JPanel();
        mSurveySizeLabel = new javax.swing.JLabel();
        mSurveyTiny = new javax.swing.JRadioButton();
        mSurveySmall = new javax.swing.JRadioButton();
        mSurveyNormal = new javax.swing.JRadioButton();
        mSurveyLarge = new javax.swing.JRadioButton();
        mSurveyHuge = new javax.swing.JRadioButton();
        mSurveyStep6 = new javax.swing.JPanel();
        mSurveyStep6Panel = new javax.swing.JPanel();
        mSurveyDefenseLabel = new javax.swing.JLabel();
        mSurveyDefenseNone = new javax.swing.JRadioButton();
        mSurveyDefenseBuffaloBill = new javax.swing.JRadioButton();
        mSurveyDefenseTisButAScratch = new javax.swing.JRadioButton();
        mSurveyDefenseCubone = new javax.swing.JRadioButton();
        mSurveyDefenseForceField = new javax.swing.JRadioButton();
        mSurveyStep7 = new javax.swing.JPanel();
        mSurveyStep7Panel = new javax.swing.JPanel();
        mSurveyInfamousLabel = new javax.swing.JLabel();
        mSurveyInfamousStrength = new javax.swing.JCheckBox();
        mSurveyInfamousOffense = new javax.swing.JCheckBox();
        mSurveyInfamousDefense = new javax.swing.JCheckBox();
        mSurveyInfamousDeft = new javax.swing.JCheckBox();
        mSurveyInfamousEndurance = new javax.swing.JCheckBox();
        mSurveyInfamousJoker = new javax.swing.JCheckBox();
        mSurveyInfamousAdapt = new javax.swing.JCheckBox();
        mSurveyInfamousGodsLoveMe = new javax.swing.JCheckBox();
        mSurveyInfamousMagicMissile = new javax.swing.JCheckBox();
        mSurveyStep8 = new javax.swing.JPanel();
        mSurveyStep8Panel = new javax.swing.JPanel();
        mSurveyAttackLabel = new javax.swing.JLabel();
        mSurveyAttackName = new javax.swing.JTextField();
        mSurveyAttackVicious = new javax.swing.JCheckBox();
        mSurveyAttackBay = new javax.swing.JCheckBox();
        mSurveyAttackWeak = new javax.swing.JCheckBox();
        mSurveyAttackMetal = new javax.swing.JCheckBox();
        mSurveyAttackWhereIsYourGodNow = new javax.swing.JCheckBox();
        mSurveyAttackRanged = new javax.swing.JCheckBox();
        mSurveyStep9 = new javax.swing.JPanel();
        mSurveyStep9Panel = new javax.swing.JPanel();
        mSurveyDescLabel = new javax.swing.JLabel();
        mSurveyDescTricksyDamage = new javax.swing.JCheckBox();
        mSurveyDescOrganized = new javax.swing.JCheckBox();
        mSurveyDescSmartass = new javax.swing.JCheckBox();
        mSurveyDescShield = new javax.swing.JCheckBox();
        mSurveyDescTrinkets = new javax.swing.JCheckBox();
        mSurveyDescBeyond = new javax.swing.JCheckBox();
        mSurveyDescProppedUp = new javax.swing.JCheckBox();
        mSurveyDescMade = new javax.swing.JCheckBox();
        mSurveyDescLooksWickedAwful = new javax.swing.JCheckBox();
        mSurveyDescProbablySlime = new javax.swing.JCheckBox();
        mSurveyDescGetOffMyLawn = new javax.swing.JCheckBox();
        mSurveyDescTreeHugger = new javax.swing.JCheckBox();
        MonsterSurvey_Controls = new javax.swing.JPanel();
        MonsterSurvey_BackNextPane = new javax.swing.JPanel();
        MonsterSurvey_Back = new javax.swing.JButton();
        MonsterSurvey_Next = new javax.swing.JButton();
        MonsterSurvey_jSeparator1 = new javax.swing.JSeparator();
        MonsterSurvey_CancelPane = new javax.swing.JPanel();
        MonsterSurvey_Cancel = new javax.swing.JButton();
        mSurveyFill1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        mSurveyFill2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        mSurveyFill3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        DeceitAndTrickeryWindow.setAlwaysOnTop(true);
        DeceitAndTrickeryWindow.setModal(true);
        DeceitAndTrickeryWindow.setSize(new java.awt.Dimension(250, 120));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        DeceitAndTrickeryOkay.setText("Okay");
        DeceitAndTrickeryOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeceitAndTrickeryOkayActionPerformed(evt);
            }
        });
        jPanel1.add(DeceitAndTrickeryOkay);

        DeceitAndTrickeryWindow.getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setText("Write a move about its dirty tricks:");
        jPanel2.add(jLabel1);
        jPanel2.add(DeceitAndTrickeryField);

        DeceitAndTrickeryWindow.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        DeceitAndTrickeryWindow.getContentPane().add(filler1, java.awt.BorderLayout.PAGE_START);
        DeceitAndTrickeryWindow.getContentPane().add(filler2, java.awt.BorderLayout.LINE_END);
        DeceitAndTrickeryWindow.getContentPane().add(filler3, java.awt.BorderLayout.LINE_START);

        UsefulAdaptWindow.setModal(true);
        UsefulAdaptWindow.setSize(new java.awt.Dimension(320, 120));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        UsefulAdaptOkay.setText("Okay");
        UsefulAdaptOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsefulAdaptOkayActionPerformed(evt);
            }
        });
        jPanel3.add(UsefulAdaptOkay);

        UsefulAdaptWindow.getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel4.setLayout(new java.awt.GridLayout(0, 1));

        jLabel2.setText("Write a special quality about its adaptation:");
        jPanel4.add(jLabel2);
        jPanel4.add(UsefulAdaptField);

        UsefulAdaptWindow.getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);
        UsefulAdaptWindow.getContentPane().add(filler4, java.awt.BorderLayout.PAGE_START);
        UsefulAdaptWindow.getContentPane().add(filler5, java.awt.BorderLayout.LINE_END);
        UsefulAdaptWindow.getContentPane().add(filler6, java.awt.BorderLayout.LINE_START);

        FavorOfGodsWindow.setModal(true);
        FavorOfGodsWindow.setSize(new java.awt.Dimension(150, 120));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        FavorOfGodsOkay.setText("Okay");
        FavorOfGodsOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavorOfGodsOkayActionPerformed(evt);
            }
        });
        jPanel5.add(FavorOfGodsOkay);

        FavorOfGodsWindow.getContentPane().add(jPanel5, java.awt.BorderLayout.SOUTH);

        jPanel6.setLayout(new java.awt.GridLayout(0, 1));

        FavorOfGodsPlusDamage.setText("+2 Damage");
        jPanel6.add(FavorOfGodsPlusDamage);

        FavorOfGodsPlusHP.setText("+2 HP");
        jPanel6.add(FavorOfGodsPlusHP);

        FavorOfGodsWindow.getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);
        FavorOfGodsWindow.getContentPane().add(filler7, java.awt.BorderLayout.PAGE_START);
        FavorOfGodsWindow.getContentPane().add(filler8, java.awt.BorderLayout.LINE_END);
        FavorOfGodsWindow.getContentPane().add(filler9, java.awt.BorderLayout.LINE_START);

        SpellsAndMagicWindow.setModal(true);
        SpellsAndMagicWindow.setSize(new java.awt.Dimension(230, 120));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        SpellsAndMagicOkay.setText("Okay");
        SpellsAndMagicOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpellsAndMagicOkayActionPerformed(evt);
            }
        });
        jPanel7.add(SpellsAndMagicOkay);

        SpellsAndMagicWindow.getContentPane().add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel8.setLayout(new java.awt.GridLayout(0, 1));

        jLabel3.setText("Write a move about its spells:");
        jPanel8.add(jLabel3);
        jPanel8.add(SpellsAndMagicField);

        SpellsAndMagicWindow.getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);
        SpellsAndMagicWindow.getContentPane().add(filler10, java.awt.BorderLayout.PAGE_START);
        SpellsAndMagicWindow.getContentPane().add(filler11, java.awt.BorderLayout.LINE_END);
        SpellsAndMagicWindow.getContentPane().add(filler12, java.awt.BorderLayout.LINE_START);

        SliceOrPierceWindow.setModal(true);
        SliceOrPierceWindow.setSize(new java.awt.Dimension(330, 120));

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        SliceOrPierceOkay.setText("Okay");
        SliceOrPierceOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SliceOrPierceOkayActionPerformed(evt);
            }
        });
        jPanel9.add(SliceOrPierceOkay);

        SliceOrPierceWindow.getContentPane().add(jPanel9, java.awt.BorderLayout.SOUTH);

        jPanel10.setLayout(new java.awt.GridLayout(0, 1));

        SliceOrPierceGroup.add(SliceOrPiercePlusOne);
        SliceOrPiercePlusOne.setSelected(true);
        SliceOrPiercePlusOne.setText("+1 Piercing");
        jPanel10.add(SliceOrPiercePlusOne);

        SliceOrPierceGroup.add(SliceOrPiercePlusThree);
        SliceOrPiercePlusThree.setText("+3 Piercing (if it can just tear metal apart)");
        SliceOrPiercePlusThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SliceOrPiercePlusThreeActionPerformed(evt);
            }
        });
        jPanel10.add(SliceOrPiercePlusThree);

        SliceOrPierceWindow.getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);
        SliceOrPierceWindow.getContentPane().add(filler13, java.awt.BorderLayout.PAGE_START);
        SliceOrPierceWindow.getContentPane().add(filler14, java.awt.BorderLayout.LINE_END);
        SliceOrPierceWindow.getContentPane().add(filler15, java.awt.BorderLayout.LINE_START);

        AttacksAtRangeWindow.setModal(true);
        AttacksAtRangeWindow.setSize(new java.awt.Dimension(110, 120));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        AttacksAtRangeOkay.setText("Okay");
        AttacksAtRangeOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttacksAtRangeOkayActionPerformed(evt);
            }
        });
        jPanel11.add(AttacksAtRangeOkay);

        AttacksAtRangeWindow.getContentPane().add(jPanel11, java.awt.BorderLayout.SOUTH);

        jPanel12.setLayout(new java.awt.GridLayout(0, 1));

        AttacksAtRangeNear.setText("Near");
        jPanel12.add(AttacksAtRangeNear);

        AttacksAtRangeFar.setText("Far");
        jPanel12.add(AttacksAtRangeFar);

        AttacksAtRangeWindow.getContentPane().add(jPanel12, java.awt.BorderLayout.CENTER);
        AttacksAtRangeWindow.getContentPane().add(filler16, java.awt.BorderLayout.PAGE_START);
        AttacksAtRangeWindow.getContentPane().add(filler17, java.awt.BorderLayout.LINE_END);
        AttacksAtRangeWindow.getContentPane().add(filler18, java.awt.BorderLayout.LINE_START);

        DangerousReasonsWindow.setModal(true);
        DangerousReasonsWindow.setSize(new java.awt.Dimension(290, 120));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        DangerousReasonsOkay.setText("Okay");
        DangerousReasonsOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangerousReasonsOkayActionPerformed(evt);
            }
        });
        jPanel13.add(DangerousReasonsOkay);

        DangerousReasonsWindow.getContentPane().add(jPanel13, java.awt.BorderLayout.SOUTH);

        jPanel14.setLayout(new java.awt.GridLayout(0, 1));

        jLabel4.setText("Write a move about why it's dangerous:");
        jPanel14.add(jLabel4);

        DangerousReasonsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangerousReasonsFieldActionPerformed(evt);
            }
        });
        jPanel14.add(DangerousReasonsField);

        DangerousReasonsWindow.getContentPane().add(jPanel14, java.awt.BorderLayout.CENTER);
        DangerousReasonsWindow.getContentPane().add(filler19, java.awt.BorderLayout.PAGE_START);
        DangerousReasonsWindow.getContentPane().add(filler20, java.awt.BorderLayout.LINE_END);
        DangerousReasonsWindow.getContentPane().add(filler21, java.awt.BorderLayout.LINE_START);

        OrganizeGroupsWindow.setModal(true);
        OrganizeGroupsWindow.setSize(new java.awt.Dimension(290, 120));

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        OrganizeGroupsOkay.setText("Okay");
        OrganizeGroupsOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizeGroupsOkayActionPerformed(evt);
            }
        });
        jPanel15.add(OrganizeGroupsOkay);

        OrganizeGroupsWindow.getContentPane().add(jPanel15, java.awt.BorderLayout.SOUTH);

        jPanel16.setLayout(new java.awt.GridLayout(0, 1));

        jLabel5.setText("Write a move about it calling for help:");
        jPanel16.add(jLabel5);
        jPanel16.add(OrganizeGroupsField);

        OrganizeGroupsWindow.getContentPane().add(jPanel16, java.awt.BorderLayout.CENTER);
        OrganizeGroupsWindow.getContentPane().add(filler22, java.awt.BorderLayout.PAGE_START);
        OrganizeGroupsWindow.getContentPane().add(filler23, java.awt.BorderLayout.LINE_END);
        OrganizeGroupsWindow.getContentPane().add(filler24, java.awt.BorderLayout.LINE_START);

        OtherWorldWindow.setModal(true);
        OtherWorldWindow.setSize(new java.awt.Dimension(450, 120));

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        OtherWorldOkay.setText("Okay");
        OtherWorldOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherWorldOkayActionPerformed(evt);
            }
        });
        jPanel17.add(OtherWorldOkay);

        OtherWorldWindow.getContentPane().add(jPanel17, java.awt.BorderLayout.SOUTH);

        jPanel18.setLayout(new java.awt.GridLayout(0, 1));

        jLabel6.setText("Write a move about using its otherwordly knowledge and power:");
        jPanel18.add(jLabel6);
        jPanel18.add(OtherWorldField);

        OtherWorldWindow.getContentPane().add(jPanel18, java.awt.BorderLayout.CENTER);
        OtherWorldWindow.getContentPane().add(filler25, java.awt.BorderLayout.PAGE_START);
        OtherWorldWindow.getContentPane().add(filler26, java.awt.BorderLayout.LINE_END);
        OtherWorldWindow.getContentPane().add(filler27, java.awt.BorderLayout.LINE_START);

        MadeWindow.setModal(true);
        MadeWindow.setSize(new java.awt.Dimension(410, 120));

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        MadeOkay.setText("Okay");
        MadeOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MadeOkayActionPerformed(evt);
            }
        });
        jPanel19.add(MadeOkay);

        MadeWindow.getContentPane().add(jPanel19, java.awt.BorderLayout.SOUTH);

        jPanel20.setLayout(new java.awt.GridLayout(0, 1));

        jLabel7.setText("Give it a special quality about its construction or purpose:");
        jPanel20.add(jLabel7);
        jPanel20.add(MadeField);

        MadeWindow.getContentPane().add(jPanel20, java.awt.BorderLayout.CENTER);
        MadeWindow.getContentPane().add(filler28, java.awt.BorderLayout.PAGE_START);
        MadeWindow.getContentPane().add(filler29, java.awt.BorderLayout.LINE_END);
        MadeWindow.getContentPane().add(filler30, java.awt.BorderLayout.LINE_START);

        AppearanceWindow.setModal(true);
        AppearanceWindow.setSize(new java.awt.Dimension(380, 120));

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        AppearanceOkay.setText("Okay");
        AppearanceOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppearanceOkayActionPerformed(evt);
            }
        });
        jPanel21.add(AppearanceOkay);

        AppearanceWindow.getContentPane().add(jPanel21, java.awt.BorderLayout.SOUTH);

        jPanel22.setLayout(new java.awt.GridLayout(0, 1));

        jLabel8.setText("Write a special quality about why it's so horrendous:");
        jPanel22.add(jLabel8);

        AppearanceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppearanceFieldActionPerformed(evt);
            }
        });
        jPanel22.add(AppearanceField);

        AppearanceWindow.getContentPane().add(jPanel22, java.awt.BorderLayout.CENTER);
        AppearanceWindow.getContentPane().add(filler31, java.awt.BorderLayout.PAGE_START);
        AppearanceWindow.getContentPane().add(filler32, java.awt.BorderLayout.LINE_END);
        AppearanceWindow.getContentPane().add(filler33, java.awt.BorderLayout.LINE_START);

        setPreferredSize(new java.awt.Dimension(550, 400));
        setSize(new java.awt.Dimension(550, 400));
        setLayout(new java.awt.BorderLayout());

        MonsterSurvey_MainPane.setLayout(new java.awt.CardLayout());

        mSurveyStep1.setLayout(new java.awt.BorderLayout());

        mSurveyStep1Panel.setLayout(new java.awt.GridLayout(2, 0));

        mSurveyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mSurveyNameLabel.setText("What is your monster's name?");
        mSurveyStep1Panel.add(mSurveyNameLabel);

        mSurveyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyNameActionPerformed(evt);
            }
        });
        mSurveyStep1Panel.add(mSurveyName);

        mSurveyStep1.add(mSurveyStep1Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep1, "card1");

        mSurveyStep2.setLayout(new java.awt.BorderLayout());

        mSurveyStep2Panel.setLayout(new java.awt.GridLayout(2, 0));

        mSurveyMoveLabel.setText("What is it known to do?");
        mSurveyStep2Panel.add(mSurveyMoveLabel);
        mSurveyStep2Panel.add(mSurveyMove);

        mSurveyStep2.add(mSurveyStep2Panel, java.awt.BorderLayout.NORTH);

        MonsterSurvey_MainPane.add(mSurveyStep2, "card2");

        mSurveyStep3.setLayout(new java.awt.BorderLayout());

        mSurveyStep3Panel.setLayout(new java.awt.GridLayout(2, 0));

        mSurveyInstinctLabel.setText("What does it want that causes problems for others?");
        mSurveyStep3Panel.add(mSurveyInstinctLabel);
        mSurveyStep3Panel.add(mSurveyInstinct);

        mSurveyStep3.add(mSurveyStep3Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep3, "card3");

        mSurveyStep4.setLayout(new java.awt.BorderLayout());

        mSurveyStep4Panel.setLayout(new java.awt.GridLayout(4, 0));

        mSurveyHuntSizeLabel.setText("How does it usually hunt or fight?");
        mSurveyStep4Panel.add(mSurveyHuntSizeLabel);

        mSurveyGroupHuntSize.add(mSurveyHorde);
        mSurveyHorde.setText("In large groups");
        mSurveyHorde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyHordeActionPerformed(evt);
            }
        });
        mSurveyStep4Panel.add(mSurveyHorde);

        mSurveyGroupHuntSize.add(mSurveyGroup);
        mSurveyGroup.setText("In small groups");
        mSurveyStep4Panel.add(mSurveyGroup);

        mSurveyGroupHuntSize.add(mSurveySolitary);
        mSurveySolitary.setSelected(true);
        mSurveySolitary.setText("All by its lonesome");
        mSurveyStep4Panel.add(mSurveySolitary);

        mSurveyStep4.add(mSurveyStep4Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep4, "card4");

        mSurveyStep5.setLayout(new java.awt.BorderLayout());

        mSurveyStep5Panel.setLayout(new java.awt.GridLayout(6, 0));

        mSurveySizeLabel.setText("How big is it?");
        mSurveyStep5Panel.add(mSurveySizeLabel);

        mSurveySize.add(mSurveyTiny);
        mSurveyTiny.setText("Smaller than a house cat");
        mSurveyTiny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyTinyActionPerformed(evt);
            }
        });
        mSurveyStep5Panel.add(mSurveyTiny);

        mSurveySize.add(mSurveySmall);
        mSurveySmall.setText("Hafling-esque");
        mSurveyStep5Panel.add(mSurveySmall);

        mSurveySize.add(mSurveyNormal);
        mSurveyNormal.setSelected(true);
        mSurveyNormal.setText("About human size");
        mSurveyStep5Panel.add(mSurveyNormal);

        mSurveySize.add(mSurveyLarge);
        mSurveyLarge.setText("As big as a cart");
        mSurveyStep5Panel.add(mSurveyLarge);

        mSurveySize.add(mSurveyHuge);
        mSurveyHuge.setText("Much larger than a cart");
        mSurveyStep5Panel.add(mSurveyHuge);

        mSurveyStep5.add(mSurveyStep5Panel, java.awt.BorderLayout.NORTH);

        MonsterSurvey_MainPane.add(mSurveyStep5, "card5");

        mSurveyStep6.setLayout(new java.awt.BorderLayout());

        mSurveyStep6Panel.setLayout(new java.awt.GridLayout(6, 0));

        mSurveyDefenseLabel.setText("What is its most important defense?");
        mSurveyStep6Panel.add(mSurveyDefenseLabel);

        mSurveyDefense.add(mSurveyDefenseNone);
        mSurveyDefenseNone.setSelected(true);
        mSurveyDefenseNone.setText("Cloth or flesh");
        mSurveyStep6Panel.add(mSurveyDefenseNone);

        mSurveyDefense.add(mSurveyDefenseBuffaloBill);
        mSurveyDefenseBuffaloBill.setText("Leathers or thick hide");
        mSurveyStep6Panel.add(mSurveyDefenseBuffaloBill);

        mSurveyDefense.add(mSurveyDefenseTisButAScratch);
        mSurveyDefenseTisButAScratch.setText("Mail or scales");
        mSurveyStep6Panel.add(mSurveyDefenseTisButAScratch);

        mSurveyDefense.add(mSurveyDefenseCubone);
        mSurveyDefenseCubone.setText("Plate or bone");
        mSurveyStep6Panel.add(mSurveyDefenseCubone);

        mSurveyDefense.add(mSurveyDefenseForceField);
        mSurveyDefenseForceField.setText("Permanent magical protection");
        mSurveyStep6Panel.add(mSurveyDefenseForceField);

        mSurveyStep6.add(mSurveyStep6Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep6, "card6");

        mSurveyStep7.setLayout(new java.awt.BorderLayout());

        mSurveyStep7Panel.setLayout(new java.awt.GridLayout(10, 0));

        mSurveyInfamousLabel.setText("What is it known for? (choose all that apply)");
        mSurveyStep7Panel.add(mSurveyInfamousLabel);

        mSurveyInfamousStrength.setText("Unrelenting strength");
        mSurveyStep7Panel.add(mSurveyInfamousStrength);

        mSurveyInfamousOffense.setText("Skill in offense");
        mSurveyInfamousOffense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyInfamousOffenseActionPerformed(evt);
            }
        });
        mSurveyStep7Panel.add(mSurveyInfamousOffense);

        mSurveyInfamousDefense.setText("Skill in defense");
        mSurveyStep7Panel.add(mSurveyInfamousDefense);

        mSurveyInfamousDeft.setText("Deft strikes");
        mSurveyStep7Panel.add(mSurveyInfamousDeft);

        mSurveyInfamousEndurance.setText("Uncanny endurance");
        mSurveyStep7Panel.add(mSurveyInfamousEndurance);

        mSurveyInfamousJoker.setText("Deceit and trickery");
        mSurveyInfamousJoker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyInfamousJokerActionPerformed(evt);
            }
        });
        mSurveyStep7Panel.add(mSurveyInfamousJoker);

        mSurveyInfamousAdapt.setText("A useful adaptation");
        mSurveyInfamousAdapt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyInfamousAdaptActionPerformed(evt);
            }
        });
        mSurveyStep7Panel.add(mSurveyInfamousAdapt);

        mSurveyInfamousGodsLoveMe.setText("The favour of the gods");
        mSurveyInfamousGodsLoveMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyInfamousGodsLoveMeActionPerformed(evt);
            }
        });
        mSurveyStep7Panel.add(mSurveyInfamousGodsLoveMe);

        mSurveyInfamousMagicMissile.setText("Spells and magic");
        mSurveyInfamousMagicMissile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyInfamousMagicMissileActionPerformed(evt);
            }
        });
        mSurveyStep7Panel.add(mSurveyInfamousMagicMissile);

        mSurveyStep7.add(mSurveyStep7Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep7, "card7");

        mSurveyStep8.setLayout(new java.awt.BorderLayout());

        mSurveyStep8Panel.setLayout(new java.awt.GridLayout(8, 0));

        mSurveyAttackLabel.setText("What is its most common form of attack?");
        mSurveyStep8Panel.add(mSurveyAttackLabel);
        mSurveyStep8Panel.add(mSurveyAttackName);

        mSurveyAttackVicious.setText("Its armaments are vicious and obvious");
        mSurveyStep8Panel.add(mSurveyAttackVicious);

        mSurveyAttackBay.setText("It lets the monster keep others at bay");
        mSurveyStep8Panel.add(mSurveyAttackBay);

        mSurveyAttackWeak.setText("Its armaments are small and weak");
        mSurveyStep8Panel.add(mSurveyAttackWeak);

        mSurveyAttackMetal.setText("Its armaments can slice or pierce metal");
        mSurveyAttackMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyAttackMetalActionPerformed(evt);
            }
        });
        mSurveyStep8Panel.add(mSurveyAttackMetal);

        mSurveyAttackWhereIsYourGodNow.setText("Armor doesn't help with the damage it deals");
        mSurveyStep8Panel.add(mSurveyAttackWhereIsYourGodNow);

        mSurveyAttackRanged.setText("It usually attacks at range");
        mSurveyAttackRanged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyAttackRangedActionPerformed(evt);
            }
        });
        mSurveyStep8Panel.add(mSurveyAttackRanged);

        mSurveyStep8.add(mSurveyStep8Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep8, "card8");

        mSurveyStep9.setLayout(new java.awt.BorderLayout());

        mSurveyStep9Panel.setLayout(new java.awt.GridLayout(13, 0));

        mSurveyDescLabel.setText("What of these describes it?");
        mSurveyStep9Panel.add(mSurveyDescLabel);

        mSurveyDescTricksyDamage.setText("It isn't dangerious because of the wounds it inflicts, but for other reasons");
        mSurveyDescTricksyDamage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescTricksyDamageActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescTricksyDamage);

        mSurveyDescOrganized.setText("It organises into larger groups that it can call for support");
        mSurveyDescOrganized.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescOrganizedActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescOrganized);

        mSurveyDescSmartass.setText("It's as smart as a human (or thereabouts)");
        mSurveyStep9Panel.add(mSurveyDescSmartass);

        mSurveyDescShield.setText("It actively defends itself with a shield or similar");
        mSurveyDescShield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescShieldActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescShield);

        mSurveyDescTrinkets.setText("It collects trinkets that humans would consider valuable");
        mSurveyStep9Panel.add(mSurveyDescTrinkets);

        mSurveyDescBeyond.setText("It is from beyond this world");
        mSurveyDescBeyond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescBeyondActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescBeyond);

        mSurveyDescProppedUp.setText("It's kept alive by something more than simple biology");
        mSurveyStep9Panel.add(mSurveyDescProppedUp);

        mSurveyDescMade.setText("It was made by someone");
        mSurveyDescMade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescMadeActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescMade);

        mSurveyDescLooksWickedAwful.setText("It's apperance is disturbing, terrible, or horrifying");
        mSurveyDescLooksWickedAwful.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSurveyDescLooksWickedAwfulActionPerformed(evt);
            }
        });
        mSurveyStep9Panel.add(mSurveyDescLooksWickedAwful);

        mSurveyDescProbablySlime.setText("It doesn't have organs or discernable anatomy");
        mSurveyStep9Panel.add(mSurveyDescProbablySlime);

        mSurveyDescGetOffMyLawn.setText("It, or its species, is ancient — older than man, dwarves, elves, etc.");
        mSurveyStep9Panel.add(mSurveyDescGetOffMyLawn);

        mSurveyDescTreeHugger.setText("It abhors violence");
        mSurveyStep9Panel.add(mSurveyDescTreeHugger);

        mSurveyStep9.add(mSurveyStep9Panel, java.awt.BorderLayout.PAGE_START);

        MonsterSurvey_MainPane.add(mSurveyStep9, "card9");

        add(MonsterSurvey_MainPane, java.awt.BorderLayout.CENTER);

        MonsterSurvey_Controls.setLayout(new java.awt.BorderLayout());

        MonsterSurvey_Back.setText("Back");
        MonsterSurvey_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterSurvey_BackActionPerformed(evt);
            }
        });
        MonsterSurvey_BackNextPane.add(MonsterSurvey_Back);

        MonsterSurvey_Next.setText("Next");
        MonsterSurvey_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterSurvey_NextActionPerformed(evt);
            }
        });
        MonsterSurvey_BackNextPane.add(MonsterSurvey_Next);

        MonsterSurvey_Controls.add(MonsterSurvey_BackNextPane, java.awt.BorderLayout.EAST);
        MonsterSurvey_Controls.add(MonsterSurvey_jSeparator1, java.awt.BorderLayout.NORTH);

        MonsterSurvey_Cancel.setText("Cancel");
        MonsterSurvey_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonsterSurvey_CancelActionPerformed(evt);
            }
        });
        MonsterSurvey_CancelPane.add(MonsterSurvey_Cancel);

        MonsterSurvey_Controls.add(MonsterSurvey_CancelPane, java.awt.BorderLayout.WEST);

        add(MonsterSurvey_Controls, java.awt.BorderLayout.SOUTH);
        add(mSurveyFill1, java.awt.BorderLayout.PAGE_START);
        add(mSurveyFill2, java.awt.BorderLayout.EAST);
        add(mSurveyFill3, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void MonsterSurvey_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterSurvey_BackActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout)(this.MonsterSurvey_MainPane.getLayout());
        if (this.MonsterSurvey_MainPane.getComponent(0).isVisible()){
            // the current card is the first card
        }else{
            cl.previous(this.MonsterSurvey_MainPane);
        }
    }//GEN-LAST:event_MonsterSurvey_BackActionPerformed

    private void MonsterSurvey_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterSurvey_NextActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout)(this.MonsterSurvey_MainPane.getLayout());
        if (this.MonsterSurvey_MainPane.getComponent(this.MonsterSurvey_MainPane.getComponentCount() - 1).isVisible()){
            int n = javax.swing.JOptionPane.showConfirmDialog(this,
                "Are you sure you want to continue?", "",
                javax.swing.JOptionPane.YES_NO_OPTION);
            if(n == javax.swing.JOptionPane.YES_OPTION){
                this.completeMonsterSurvey();
            }
        }else if(this.MonsterSurvey_MainPane.getComponent(0).isVisible()){
            if(!this.validName(this.mSurveyName.getText())){
                javax.swing.JOptionPane.showMessageDialog(this,
                    "The name of this monster must be unique and nonempty.");
            }else{
                cl.next(this.MonsterSurvey_MainPane);
            }
        }else{
            cl.next(this.MonsterSurvey_MainPane);
        }
    }//GEN-LAST:event_MonsterSurvey_NextActionPerformed

    private void MonsterSurvey_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonsterSurvey_CancelActionPerformed
        owner.dispose();
    }//GEN-LAST:event_MonsterSurvey_CancelActionPerformed

    private void mSurveyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSurveyNameActionPerformed

    private void mSurveyHordeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyHordeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSurveyHordeActionPerformed

    private void mSurveyTinyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyTinyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSurveyTinyActionPerformed

    private void mSurveyInfamousOffenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyInfamousOffenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSurveyInfamousOffenseActionPerformed

    private void SliceOrPiercePlusThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SliceOrPiercePlusThreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SliceOrPiercePlusThreeActionPerformed

    private void DangerousReasonsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangerousReasonsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DangerousReasonsFieldActionPerformed

    private void AppearanceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppearanceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppearanceFieldActionPerformed

    private void AppearanceOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppearanceOkayActionPerformed
        this.AppearanceWindow.setVisible(false);
    }//GEN-LAST:event_AppearanceOkayActionPerformed

    private void DeceitAndTrickeryOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeceitAndTrickeryOkayActionPerformed
        this.DeceitAndTrickeryWindow.setVisible(false);
    }//GEN-LAST:event_DeceitAndTrickeryOkayActionPerformed

    private void UsefulAdaptOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsefulAdaptOkayActionPerformed
        this.UsefulAdaptWindow.setVisible(false);
    }//GEN-LAST:event_UsefulAdaptOkayActionPerformed

    private void FavorOfGodsOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavorOfGodsOkayActionPerformed
        this.FavorOfGodsWindow.setVisible(false);
    }//GEN-LAST:event_FavorOfGodsOkayActionPerformed

    private void SpellsAndMagicOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpellsAndMagicOkayActionPerformed
        this.SpellsAndMagicWindow.setVisible(false);
    }//GEN-LAST:event_SpellsAndMagicOkayActionPerformed

    private void SliceOrPierceOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SliceOrPierceOkayActionPerformed
        this.SliceOrPierceWindow.setVisible(false);
    }//GEN-LAST:event_SliceOrPierceOkayActionPerformed

    private void AttacksAtRangeOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttacksAtRangeOkayActionPerformed
        this.AttacksAtRangeWindow.setVisible(false);
    }//GEN-LAST:event_AttacksAtRangeOkayActionPerformed

    private void DangerousReasonsOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangerousReasonsOkayActionPerformed
        this.DangerousReasonsWindow.setVisible(false);
    }//GEN-LAST:event_DangerousReasonsOkayActionPerformed

    private void OrganizeGroupsOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizeGroupsOkayActionPerformed
        this.OrganizeGroupsWindow.setVisible(false);
    }//GEN-LAST:event_OrganizeGroupsOkayActionPerformed

    private void OtherWorldOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherWorldOkayActionPerformed
        this.OtherWorldWindow.setVisible(false);
    }//GEN-LAST:event_OtherWorldOkayActionPerformed

    private void MadeOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MadeOkayActionPerformed
        this.MadeWindow.setVisible(false);
    }//GEN-LAST:event_MadeOkayActionPerformed

    private void mSurveyDescShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescShieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSurveyDescShieldActionPerformed

    private void mSurveyInfamousJokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyInfamousJokerActionPerformed
        this.DeceitAndTrickeryWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyInfamousJokerActionPerformed

    private void mSurveyInfamousAdaptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyInfamousAdaptActionPerformed
        this.UsefulAdaptWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyInfamousAdaptActionPerformed

    private void mSurveyInfamousGodsLoveMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyInfamousGodsLoveMeActionPerformed
        this.FavorOfGodsWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyInfamousGodsLoveMeActionPerformed

    private void mSurveyInfamousMagicMissileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyInfamousMagicMissileActionPerformed
        this.SpellsAndMagicWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyInfamousMagicMissileActionPerformed

    private void mSurveyAttackMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyAttackMetalActionPerformed
        this.SliceOrPierceWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyAttackMetalActionPerformed

    private void mSurveyAttackRangedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyAttackRangedActionPerformed
        this.AttacksAtRangeWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyAttackRangedActionPerformed

    private void mSurveyDescTricksyDamageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescTricksyDamageActionPerformed
        this.DangerousReasonsWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyDescTricksyDamageActionPerformed

    private void mSurveyDescOrganizedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescOrganizedActionPerformed
        this.OrganizeGroupsWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyDescOrganizedActionPerformed

    private void mSurveyDescBeyondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescBeyondActionPerformed
        this.OtherWorldWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyDescBeyondActionPerformed

    private void mSurveyDescMadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescMadeActionPerformed
        this.MadeWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyDescMadeActionPerformed

    private void mSurveyDescLooksWickedAwfulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSurveyDescLooksWickedAwfulActionPerformed
        this.AppearanceWindow.setVisible(true);
    }//GEN-LAST:event_mSurveyDescLooksWickedAwfulActionPerformed

    private Monster mon;
    private MonsterList listy;
    private boolean working;
    private javax.swing.JDialog owner;
    BestiaryGUI mainWin;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppearanceField;
    private javax.swing.JButton AppearanceOkay;
    private javax.swing.JDialog AppearanceWindow;
    private javax.swing.JCheckBox AttacksAtRangeFar;
    private javax.swing.JCheckBox AttacksAtRangeNear;
    private javax.swing.JButton AttacksAtRangeOkay;
    private javax.swing.JDialog AttacksAtRangeWindow;
    private javax.swing.JTextField DangerousReasonsField;
    private javax.swing.JButton DangerousReasonsOkay;
    private javax.swing.JDialog DangerousReasonsWindow;
    private javax.swing.JTextField DeceitAndTrickeryField;
    private javax.swing.JButton DeceitAndTrickeryOkay;
    private javax.swing.JDialog DeceitAndTrickeryWindow;
    private javax.swing.JButton FavorOfGodsOkay;
    private javax.swing.JCheckBox FavorOfGodsPlusDamage;
    private javax.swing.JCheckBox FavorOfGodsPlusHP;
    private javax.swing.JDialog FavorOfGodsWindow;
    private javax.swing.JTextField MadeField;
    private javax.swing.JButton MadeOkay;
    private javax.swing.JDialog MadeWindow;
    private javax.swing.JButton MonsterSurvey_Back;
    private javax.swing.JPanel MonsterSurvey_BackNextPane;
    private javax.swing.JButton MonsterSurvey_Cancel;
    private javax.swing.JPanel MonsterSurvey_CancelPane;
    private javax.swing.JPanel MonsterSurvey_Controls;
    private javax.swing.JPanel MonsterSurvey_MainPane;
    private javax.swing.JButton MonsterSurvey_Next;
    private javax.swing.JSeparator MonsterSurvey_jSeparator1;
    private javax.swing.JTextField OrganizeGroupsField;
    private javax.swing.JButton OrganizeGroupsOkay;
    private javax.swing.JDialog OrganizeGroupsWindow;
    private javax.swing.JTextField OtherWorldField;
    private javax.swing.JButton OtherWorldOkay;
    private javax.swing.JDialog OtherWorldWindow;
    private javax.swing.ButtonGroup SliceOrPierceGroup;
    private javax.swing.JButton SliceOrPierceOkay;
    private javax.swing.JRadioButton SliceOrPiercePlusOne;
    private javax.swing.JRadioButton SliceOrPiercePlusThree;
    private javax.swing.JDialog SliceOrPierceWindow;
    private javax.swing.JTextField SpellsAndMagicField;
    private javax.swing.JButton SpellsAndMagicOkay;
    private javax.swing.JDialog SpellsAndMagicWindow;
    private javax.swing.JTextField UsefulAdaptField;
    private javax.swing.JButton UsefulAdaptOkay;
    private javax.swing.JDialog UsefulAdaptWindow;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler27;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler31;
    private javax.swing.Box.Filler filler32;
    private javax.swing.Box.Filler filler33;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JCheckBox mSurveyAttackBay;
    private javax.swing.JLabel mSurveyAttackLabel;
    private javax.swing.JCheckBox mSurveyAttackMetal;
    private javax.swing.JTextField mSurveyAttackName;
    private javax.swing.JCheckBox mSurveyAttackRanged;
    private javax.swing.JCheckBox mSurveyAttackVicious;
    private javax.swing.JCheckBox mSurveyAttackWeak;
    private javax.swing.JCheckBox mSurveyAttackWhereIsYourGodNow;
    private javax.swing.ButtonGroup mSurveyDefense;
    private javax.swing.JRadioButton mSurveyDefenseBuffaloBill;
    private javax.swing.JRadioButton mSurveyDefenseCubone;
    private javax.swing.JRadioButton mSurveyDefenseForceField;
    private javax.swing.JLabel mSurveyDefenseLabel;
    private javax.swing.JRadioButton mSurveyDefenseNone;
    private javax.swing.JRadioButton mSurveyDefenseTisButAScratch;
    private javax.swing.JCheckBox mSurveyDescBeyond;
    private javax.swing.JCheckBox mSurveyDescGetOffMyLawn;
    private javax.swing.JLabel mSurveyDescLabel;
    private javax.swing.JCheckBox mSurveyDescLooksWickedAwful;
    private javax.swing.JCheckBox mSurveyDescMade;
    private javax.swing.JCheckBox mSurveyDescOrganized;
    private javax.swing.JCheckBox mSurveyDescProbablySlime;
    private javax.swing.JCheckBox mSurveyDescProppedUp;
    private javax.swing.JCheckBox mSurveyDescShield;
    private javax.swing.JCheckBox mSurveyDescSmartass;
    private javax.swing.JCheckBox mSurveyDescTreeHugger;
    private javax.swing.JCheckBox mSurveyDescTricksyDamage;
    private javax.swing.JCheckBox mSurveyDescTrinkets;
    private javax.swing.Box.Filler mSurveyFill1;
    private javax.swing.Box.Filler mSurveyFill2;
    private javax.swing.Box.Filler mSurveyFill3;
    private javax.swing.JRadioButton mSurveyGroup;
    private javax.swing.ButtonGroup mSurveyGroupHuntSize;
    private javax.swing.JRadioButton mSurveyHorde;
    private javax.swing.JRadioButton mSurveyHuge;
    private javax.swing.JLabel mSurveyHuntSizeLabel;
    private javax.swing.JCheckBox mSurveyInfamousAdapt;
    private javax.swing.JCheckBox mSurveyInfamousDefense;
    private javax.swing.JCheckBox mSurveyInfamousDeft;
    private javax.swing.JCheckBox mSurveyInfamousEndurance;
    private javax.swing.JCheckBox mSurveyInfamousGodsLoveMe;
    private javax.swing.JCheckBox mSurveyInfamousJoker;
    private javax.swing.JLabel mSurveyInfamousLabel;
    private javax.swing.JCheckBox mSurveyInfamousMagicMissile;
    private javax.swing.JCheckBox mSurveyInfamousOffense;
    private javax.swing.JCheckBox mSurveyInfamousStrength;
    private javax.swing.JTextField mSurveyInstinct;
    private javax.swing.JLabel mSurveyInstinctLabel;
    private javax.swing.JRadioButton mSurveyLarge;
    private javax.swing.JTextField mSurveyMove;
    private javax.swing.JLabel mSurveyMoveLabel;
    private javax.swing.JTextField mSurveyName;
    private javax.swing.JLabel mSurveyNameLabel;
    private javax.swing.JRadioButton mSurveyNormal;
    private javax.swing.ButtonGroup mSurveySize;
    private javax.swing.JLabel mSurveySizeLabel;
    private javax.swing.JRadioButton mSurveySmall;
    private javax.swing.JRadioButton mSurveySolitary;
    private javax.swing.JPanel mSurveyStep1;
    private javax.swing.JPanel mSurveyStep1Panel;
    private javax.swing.JPanel mSurveyStep2;
    private javax.swing.JPanel mSurveyStep2Panel;
    private javax.swing.JPanel mSurveyStep3;
    private javax.swing.JPanel mSurveyStep3Panel;
    private javax.swing.JPanel mSurveyStep4;
    private javax.swing.JPanel mSurveyStep4Panel;
    private javax.swing.JPanel mSurveyStep5;
    private javax.swing.JPanel mSurveyStep5Panel;
    private javax.swing.JPanel mSurveyStep6;
    private javax.swing.JPanel mSurveyStep6Panel;
    private javax.swing.JPanel mSurveyStep7;
    private javax.swing.JPanel mSurveyStep7Panel;
    private javax.swing.JPanel mSurveyStep8;
    private javax.swing.JPanel mSurveyStep8Panel;
    private javax.swing.JPanel mSurveyStep9;
    private javax.swing.JPanel mSurveyStep9Panel;
    private javax.swing.JRadioButton mSurveyTiny;
    // End of variables declaration//GEN-END:variables
}
