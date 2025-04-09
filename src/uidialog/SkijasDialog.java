/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package uidialog;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.NivoSkijanja;
import model.Skijas;
import communication.Communication;
import formController.SkijasFormController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import uiform.SkijasForm;

/**
 *
 * @author milan
 */
public class SkijasDialog extends javax.swing.JDialog {

    /**
     * Creates new form SkijasDialog
     */
    private Skijas s;
    private SkijasForm parent;
    private SkijasFormController controller;
    public SkijasDialog(java.awt.Frame parent, boolean modal, Skijas s, SkijasFormController controller) {
        super(parent, modal);
        initComponents();
        this.s=s;
        this.parent=(SkijasForm) parent;   
        this.controller = controller;
        //fillComboBox();
        //fillFields();
        //setLocationRelativeTo(null);
    }

    public SkijasFormController getController() {
        return controller;
    }

    public void setController(SkijasFormController controller) {
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldPhoneNum = new javax.swing.JTextField();
        jTextFieldSurname = new javax.swing.JTextField();
        jComboBoxNivo = new javax.swing.JComboBox<>();
        jLabelSurname = new javax.swing.JLabel();
        jLabelNum = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelNivo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonChange = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podešavanja skijaša");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ime:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 29, 109, 26));

        jLabel2.setText("Prezime:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 73, 109, 26));

        jLabel3.setText("Broj telefona:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 117, 109, 26));

        jLabel5.setText("Nivo skijanja:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 161, 109, 26));
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 29, 137, -1));

        jTextFieldPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneNumActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 117, 137, -1));
        jPanel1.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 73, 137, -1));

        jPanel1.add(jComboBoxNivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 161, 137, -1));

        jLabelSurname.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelSurname.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 98, 140, 20));

        jLabelNum.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelNum.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 142, 140, 20));

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 54, 140, 20));

        jLabelNivo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelNivo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelNivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 186, 140, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jButtonAdd.setText("Dodaj");
        jButtonAdd.setFocusPainted(false);
        jButtonAdd.setFocusable(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd);
        jButtonAdd.setBounds(20, 25, 80, 25);

        jButtonChange.setText("Izmeni");
        jButtonChange.setFocusPainted(false);
        jButtonChange.setFocusable(false);
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonChange);
        jButtonChange.setBounds(20, 25, 80, 25);

        jButtonSave.setText("Sačuvaj");
        jButtonSave.setFocusPainted(false);
        jButtonSave.setFocusable(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSave);
        jButtonSave.setBounds(20, 25, 80, 25);

        jButtonBack.setText("Nazad");
        jButtonBack.setFocusPainted(false);
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBack);
        jButtonBack.setBounds(110, 25, 80, 25);

        jButtonDelete.setText("Obriši");
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setFocusable(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete);
        jButtonDelete.setBounds(220, 25, 110, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Skijas getS() {
        return s;
    }

    public void setS(Skijas s) {
        this.s = s;
    }

    public SkijasForm getParent() {
        return parent;
    }

    public void setParent(SkijasForm parent) {
        this.parent = parent;
    }

    public JButton getjButtonAdd() {
        return jButtonAdd;
    }

    public void setjButtonAdd(JButton jButtonAdd) {
        this.jButtonAdd = jButtonAdd;
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JButton getjButtonChange() {
        return jButtonChange;
    }

    public void setjButtonChange(JButton jButtonChange) {
        this.jButtonChange = jButtonChange;
    }

    public JButton getjButtonDelete() {
        return jButtonDelete;
    }

    public void setjButtonDelete(JButton jButtonDelete) {
        this.jButtonDelete = jButtonDelete;
    }

    public JButton getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(JButton jButtonSave) {
        this.jButtonSave = jButtonSave;
    }

    public JComboBox<NivoSkijanja> getjComboBoxNivo() {
        return jComboBoxNivo;
    }

    public void setjComboBoxNivo(JComboBox<NivoSkijanja> jComboBoxNivo) {
        this.jComboBoxNivo = jComboBoxNivo;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabelName() {
        return jLabelName;
    }

    public void setjLabelName(JLabel jLabelName) {
        this.jLabelName = jLabelName;
    }

    public JLabel getjLabelNivo() {
        return jLabelNivo;
    }

    public void setjLabelNivo(JLabel jLabelNivo) {
        this.jLabelNivo = jLabelNivo;
    }

    public JLabel getjLabelNum() {
        return jLabelNum;
    }

    public void setjLabelNum(JLabel jLabelNum) {
        this.jLabelNum = jLabelNum;
    }

    public JLabel getjLabelSurname() {
        return jLabelSurname;
    }

    public void setjLabelSurname(JLabel jLabelSurname) {
        this.jLabelSurname = jLabelSurname;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JTextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(JTextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public JTextField getjTextFieldPhoneNum() {
        return jTextFieldPhoneNum;
    }

    public void setjTextFieldPhoneNum(JTextField jTextFieldPhoneNum) {
        this.jTextFieldPhoneNum = jTextFieldPhoneNum;
    }

    public JTextField getjTextFieldSurname() {
        return jTextFieldSurname;
    }

    public void setjTextFieldSurname(JTextField jTextFieldSurname) {
        this.jTextFieldSurname = jTextFieldSurname;
    }

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        /*try {
            
            String name = jTextFieldName.getText();
            String surname = jTextFieldSurname.getText();
            String num = jTextFieldPhoneNum.getText();
            NivoSkijanja ns = (NivoSkijanja) jComboBoxNivo.getSelectedItem();
            
            boolean validate = true;
            jLabelName.setText("");
            jLabelSurname.setText("");
            jLabelNum.setText("");
            jLabelNivo.setText("");
            
            if(name.isEmpty()){
                validate=false;
                jLabelName.setText("Unesite ime");
            }else if(!name.matches("^[a-zA-Z ]+$")){
                validate=false;
                jLabelName.setText("Ime mora sadržati slova");
            }
            if(surname.isEmpty()){
                validate=false;
                jLabelSurname.setText("Unesite prezime");
            }else if(!surname.matches("^[a-zA-Z ]+$")){
                validate=false;
                jLabelSurname.setText("Prezime mora sadržati slova");
            }
            if(num.isEmpty()){
                validate=false;
                jLabelNum.setText("Unesite broj");
            }else if (!num.matches("\\+?[0-9]{9,15}")) {
                jLabelNum.setText("Broj mora sadržati 9-15 cifara");
                validate = false;
            }
            if(ns==null){
                validate=false;
                jLabelNivo.setText("Unesite nivo skijanja");
            }
            
            if(!validate){
                return;
            }
            
            
            
            Skijas s = new Skijas(0, name, surname, num, ns);
            boolean b = Communication.getInstance().kreirajSkijas(s);
            if(b){
                JOptionPane.showMessageDialog(rootPane, "Uspešno kreiranje Skijaš.\n","Kreiranje skijaša",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                parent.fillTable(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom kreiranja skijaša.\n"+ex.getMessage(),"Kreiranje skijaša",JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        /*jButtonChange.setVisible(false);
        jButtonSave.setVisible(true);
        jButtonDelete.setVisible(false);
        jTextFieldName.setEnabled(true);
        jTextFieldPhoneNum.setEnabled(true);
        jTextFieldSurname.setEnabled(true);
        jComboBoxNivo.setEnabled(true);*/
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        /*try {
            String name = jTextFieldName.getText();
            String surname = jTextFieldSurname.getText();
            String num = jTextFieldPhoneNum.getText();
            NivoSkijanja ns = (NivoSkijanja) jComboBoxNivo.getSelectedItem();
            Skijas sk = new Skijas(s.getIdSkijas(), name, surname, num, ns);
            
             boolean validate = true;
            jLabelName.setText("");
            jLabelSurname.setText("");
            jLabelNum.setText("");
            jLabelNivo.setText("");
            
            if(name.isEmpty()){
                validate=false;
                jLabelName.setText("Unesite ime");
            }else if(!name.matches("^[a-zA-Z ]+$")){
                validate=false;
                jLabelName.setText("Ime mora sadržati slova");
            }
            if(surname.isEmpty()){
                validate=false;
                jLabelSurname.setText("Unesite prezime");
            }else if(!surname.matches("^[a-zA-Z ]+$")){
                validate=false;
                jLabelSurname.setText("Prezime mora sadržati slova");
            }
            if(num.isEmpty()){
                validate=false;
                jLabelNum.setText("Unesite broj");
            }else if (!num.matches("\\+?[0-9]{9,15}")) {
                jLabelNum.setText("Broj mora sadržati 9-15 cifara");
                validate = false;
            }
            if(ns==null){
                validate=false;
                jLabelNivo.setText("Unesite nivo skijanja");
            }
            
            if(!validate){
                return;
            }
            
            
            if(name.equals(s.getIme()) && surname.equals(s.getPrezime()) && num.equals(s.getBrojTelefona()) && ns.getIdNivoSkijanja()==s.getNivoSkijanja().getIdNivoSkijanja()){
                JOptionPane.showMessageDialog(rootPane, "Niste izmenili podatke.\n","Ažuriranje skijaša.",JOptionPane.WARNING_MESSAGE);
                return;
            }
            boolean b = Communication.getInstance().promeniSkijas(sk);
            if(b){
                JOptionPane.showMessageDialog(rootPane, "Uspešno ažuriran skijaš.\n","Ažuriranje skijaša",JOptionPane.INFORMATION_MESSAGE);
                parent.fillTable(null);
                this.dispose();
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom ažuriranja skijaša.\n"+ex.getMessage(),"Ažuriranje skijaša",JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        /*int i =JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da obrišete skijaša?","Brisanje skijaša",JOptionPane.YES_NO_OPTION);
        
        if(i == JOptionPane.YES_OPTION){
            try {

                boolean b = Communication.getInstance().obrisiSkijas(s);
                if(b){
                    JOptionPane.showMessageDialog(rootPane, "Uspešno obrisan skijaš.","Brisanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                    parent.fillTable(null);
                    this.dispose();
                    }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom brisanja skijaša.","Brisanje skijaša",JOptionPane.ERROR_MESSAGE);
            }
        }*/
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        //this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhoneNumActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<NivoSkijanja> jComboBoxNivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNivo;
    private javax.swing.JLabel jLabelNum;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhoneNum;
    private javax.swing.JTextField jTextFieldSurname;
    // End of variables declaration//GEN-END:variables
/*
    private void fillComboBox() {
        List<NivoSkijanja> list;
        try {
            list = Communication.getInstance().vratiListuSviNivoSkijanja();
            for(NivoSkijanja ns : list){
                jComboBoxNivo.addItem(ns);
                if(s==null)
                    jComboBoxNivo.setSelectedItem(null);
                else if(ns.getIdNivoSkijanja()==s.getNivoSkijanja().getIdNivoSkijanja())
                    jComboBoxNivo.setSelectedItem(ns);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom ucitavanja podatakaaa.\n"+ex.getMessage(),"Ucitavanje podataka",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void fillFields() {
        if(s == null){
            jButtonDelete.setVisible(false);
            jButtonChange.setVisible(false);
            jButtonSave.setVisible(false);
        }
        else{
            jTextFieldName.setText(s.getIme());
            jTextFieldPhoneNum.setText(s.getBrojTelefona());
            jTextFieldSurname.setText(s.getPrezime());
            jButtonAdd.setVisible(false);
            jButtonSave.setVisible(false);
            jComboBoxNivo.setSelectedItem(s.getNivoSkijanja());
            jTextFieldName.setEnabled(false);
            jTextFieldPhoneNum.setEnabled(false);
            jTextFieldSurname.setEnabled(false);
            jComboBoxNivo.setEnabled(false);
        }
    }*/

    public void addActionListener(ActionListener actionListener) {
        jButtonAdd.addActionListener(actionListener);
    }

    public void backActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }

    public void deleteActionListener(ActionListener actionListener) {
        jButtonDelete.addActionListener(actionListener);
    }

    public void saveActionListener(ActionListener actionListener) {
        jButtonSave.addActionListener(actionListener);
    }

    public void changeActionListener(ActionListener actionListener) {
        jButtonChange.addActionListener(actionListener);
    }

}
