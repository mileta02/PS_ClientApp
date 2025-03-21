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
import uicontroller.Controller;
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
    public SkijasDialog(java.awt.Frame parent, boolean modal, Skijas s) {
        super(parent, modal);
        initComponents();
        fillComboBox();
        this.s=s;
        this.parent=(SkijasForm) parent;
        fillFields();
        setLocationRelativeTo(null);
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
        setTitle("Skijas");
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

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            
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
                jLabelName.setText("Unesite ime.");
            }
            if(surname.isEmpty()){
                validate=false;
                jLabelSurname.setText("Unesite prezime.");
            }
            if(num.isEmpty()){
                validate=false;
                jLabelNum.setText("Unesite broj.");
            }
            else if (!num.matches("\\+?[0-9]{9,15}")) {
            jLabelNum.setText("Broj mora imati 9-15 cifara!");
                validate = false;
            }
            if(ns==null){
                validate=false;
                jLabelNivo.setText("Unesite nivo skijanja.");
            }
            
            if(!validate){
                return;
            }
            
            
            
            Skijas s = new Skijas(0, name, surname, num, ns);
            boolean b = Controller.getInstance().kreirajSkijas(s);
            if(b){
                JOptionPane.showMessageDialog(rootPane, "Skijaš uspešno kreiran.\n","Kreiranje skijaša",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                parent.fillTable(null);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom kreiranja skijaša.\n"+ex.getMessage(),"Kreiranje skijaša",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        jButtonChange.setVisible(false);
        jButtonSave.setVisible(true);
        jButtonDelete.setVisible(false);
        jTextFieldName.setEnabled(true);
        jTextFieldPhoneNum.setEnabled(true);
        jTextFieldSurname.setEnabled(true);
        jComboBoxNivo.setEnabled(true);
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {
            String name = jTextFieldName.getText();
            String surname = jTextFieldSurname.getText();
            String num = jTextFieldPhoneNum.getText();
            NivoSkijanja ns = (NivoSkijanja) jComboBoxNivo.getSelectedItem();
            Skijas sk = new Skijas(s.getIdSkijas(), name, surname, num, ns);
            
            if(name.equals(s.getIme()) && surname.equals(s.getPrezime()) && num.equals(s.getBrojTelefona()) && ns==null){
                JOptionPane.showMessageDialog(rootPane, "Niste izmenili podatke.\n","Izmena podataka.",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            System.out.println(sk);
            boolean b = Controller.getInstance().promeniSkijas(sk);
            if(b){
                JOptionPane.showMessageDialog(rootPane, "Skijaš uspešno izmenjen.\n","Izmena podataka.",JOptionPane.INFORMATION_MESSAGE);
                parent.fillTable(null);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom izmene skijaša.\n"+ex.getMessage(),"Izmena podataka",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int i =JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da obrišete skijaša?","Brisanje skijaša",JOptionPane.YES_NO_OPTION);
        
        if(i == JOptionPane.YES_OPTION){
            try {

                boolean b = Controller.getInstance().obrisiSkijas(s);
                if(b){
                    JOptionPane.showMessageDialog(rootPane, "Uspešno obrisan skijaša.","Uspešno brisanje",JOptionPane.INFORMATION_MESSAGE);
                    parent.fillTable(null);
                    this.dispose();
                    }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom brisanja skijaša.","Neuspešno brisanje",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
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

    private void fillComboBox() {
        List<NivoSkijanja> list;
        try {
            list = Controller.getInstance().vratiListuSviNivoSkijanja();
            for(NivoSkijanja ns : list)
                jComboBoxNivo.addItem(ns);
            jComboBoxNivo.setSelectedItem(null);
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
    }

}
