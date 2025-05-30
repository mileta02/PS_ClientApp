/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package uidialog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Licenca;
import communication.Communication;
import formController.LicencaFormController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import uiform.LicencaForm;

/**
 *
 * @author milan
 */
public class LicencaDialog extends javax.swing.JDialog {

    /**
     * Creates new form LicenceDialog
     */
    private Licenca l;
    private LicencaForm parent;
    private LicencaFormController controller;
    public LicencaDialog(java.awt.Frame parent, boolean modal, Licenca l, LicencaFormController controller) {
        super(parent, modal);
        initComponents();
        this.parent=(LicencaForm) parent;
        this.l=l;
        this.controller=controller;
        //fillFields();
        //setLocationRelativeTo(null);
        //setVisible(true);
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
        jTextFieldNaziv = new javax.swing.JTextField();
        jTextFieldZvanje = new javax.swing.JTextField();
        jLabelNaziv = new javax.swing.JLabel();
        jLabelZvanje = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonChange = new javax.swing.JButton();
        jButtonSaveChanges = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Podešavanja licence");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Naziv licence");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, 20));

        jLabel2.setText("Zvanje instruktora");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 105, 20));
        jPanel1.add(jTextFieldNaziv, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 20));
        jPanel1.add(jTextFieldZvanje, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, 20));

        jLabelNaziv.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelNaziv.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelNaziv, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 15));

        jLabelZvanje.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelZvanje.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelZvanje, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 150, 15));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonChange.setText("Izmeni");
        jButtonChange.setFocusPainted(false);
        jButtonChange.setFocusable(false);
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, 20));

        jButtonSaveChanges.setText("Sačuvaj izmene");
        jButtonSaveChanges.setFocusPainted(false);
        jButtonSaveChanges.setFocusable(false);
        jButtonSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChangesActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, 20));

        jButtonAdd.setText("Dodaj");
        jButtonAdd.setFocusPainted(false);
        jButtonAdd.setFocusable(false);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, 20));

        jButtonDelete.setText("Obriši");
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setFocusable(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 20));

        jButtonBack.setText("Nazad");
        jButtonBack.setFocusPainted(false);
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 140, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Licenca getL() {
        return l;
    }

    public void setL(Licenca l) {
        this.l = l;
    }

    public LicencaForm getParent() {
        return parent;
    }

    public void setParent(LicencaForm parent) {
        this.parent = parent;
    }

    public LicencaFormController getController() {
        return controller;
    }

    public void setController(LicencaFormController controller) {
        this.controller = controller;
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

    public JButton getjButtonSaveChanges() {
        return jButtonSaveChanges;
    }

    public void setjButtonSaveChanges(JButton jButtonSaveChanges) {
        this.jButtonSaveChanges = jButtonSaveChanges;
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

    public JLabel getjLabelNaziv() {
        return jLabelNaziv;
    }

    public void setjLabelNaziv(JLabel jLabelNaziv) {
        this.jLabelNaziv = jLabelNaziv;
    }

    public JLabel getjLabelZvanje() {
        return jLabelZvanje;
    }

    public void setjLabelZvanje(JLabel jLabelZvanje) {
        this.jLabelZvanje = jLabelZvanje;
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

    public JTextField getjTextFieldNaziv() {
        return jTextFieldNaziv;
    }

    public void setjTextFieldNaziv(JTextField jTextFieldNaziv) {
        this.jTextFieldNaziv = jTextFieldNaziv;
    }

    public JTextField getjTextFieldZvanje() {
        return jTextFieldZvanje;
    }

    public void setjTextFieldZvanje(JTextField jTextFieldZvanje) {
        this.jTextFieldZvanje = jTextFieldZvanje;
    }

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        //this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        /*jButtonChange.setVisible(false);
        jButtonDelete.setVisible(false);
        jButtonSaveChanges.setVisible(true);
        jTextFieldNaziv.setEnabled(true);
        jTextFieldZvanje.setEnabled(true);*/
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChangesActionPerformed
        /*if(!validation() || !isEdited())
            return;
        
        l.setNazivLicence(jTextFieldNaziv.getText());
        l.setZvanjeInstruktora(jTextFieldZvanje.getText());
        try {
            if(Communication.getInstance().promeniLicenca(l))
                JOptionPane.showMessageDialog(parent, "Uspešno ažurirana licenca.","Ažuriranje licence",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Greška prilikom ažuriranja licence. \n"+ex.getMessage(),"Ažuriranje licence",JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButtonSaveChangesActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        /*int i =JOptionPane.showConfirmDialog(parent, "Da li ste sigurni da želite da obrišete licencu?","Brisanje licence",JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
            try{
            boolean b = Communication.getInstance().obrisiLicenca(l);
            if(b)
                JOptionPane.showMessageDialog(parent, "Uspešno obrisana licenca.","Brisanje licence",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Greška prilikom brisanja licence. \n"+ex.getMessage(),"Brisanje licence",JOptionPane.ERROR_MESSAGE);
            }
            }else{
            return;
        }*/
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        /*if(!validation())
            return;
        String naziv = jTextFieldNaziv.getText();
        String zvanje = jTextFieldZvanje.getText();
        
        Licenca l = new Licenca();
        l.setNazivLicence(naziv);
        l.setZvanjeInstruktora(zvanje);
        
        try {
            if(Communication.getInstance().kreirajLicenca(l))
                JOptionPane.showMessageDialog(parent, "Uspešno kreirana licenca.","Kreiranje licence",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Greška prilikom kreiranja licence. \n"+ex.getMessage(),"Kreiranje licence",JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSaveChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNaziv;
    private javax.swing.JLabel jLabelZvanje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldNaziv;
    private javax.swing.JTextField jTextFieldZvanje;
    // End of variables declaration//GEN-END:variables

    private void fillFields() {
        if(l==null){
            jButtonChange.setVisible(false);
            jButtonSaveChanges.setVisible(false);
            jButtonDelete.setVisible(false);
            return;
        }
        jTextFieldNaziv.setEnabled(false);
        jTextFieldZvanje.setEnabled(false);
        jTextFieldNaziv.setText(l.getNazivLicence());
        jTextFieldZvanje.setText(l.getZvanjeInstruktora());
    }
    
    private boolean validation(){
        String naziv = jTextFieldNaziv.getText();
        String zvanje = jTextFieldZvanje.getText();
        boolean valid = true;
        jLabelNaziv.setText("");
        jLabelZvanje.setText("");
        if(naziv.isEmpty()){
            jLabelNaziv.setText("Unesite naziv");
            valid=false;
        } else if(!naziv.matches("^[a-zA-Z ]+$")){
            jLabelNaziv.setText("Naziv mora sadržati slova");
            valid=false;
        }
        if(zvanje.isEmpty()){
            jLabelZvanje.setText("Unesite zvanje");
            valid=false;
        }else if(!zvanje.matches("^[a-zA-Z ]+$")){
            jLabelZvanje.setText("Zvanje mora sadržati slova");
            valid=false;
        }
        return valid;
    }
    
    private boolean isEdited(){
        String naziv = jTextFieldNaziv.getText();
        String zvanje = jTextFieldZvanje.getText();
        if(naziv.equals(l.getNazivLicence()) && zvanje.equals(l.getZvanjeInstruktora())){
            jLabelNaziv.setText("Niste izvršili izmenu");
            jLabelZvanje.setText("Niste izvršili izmenu");
            return false;
        }
        return true;
    }

    public void backActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }

    public void addActionListener(ActionListener actionListener) {
        jButtonAdd.addActionListener(actionListener);
    }

    public void changeActionListener(ActionListener actionListener) {
        jButtonChange.addActionListener(actionListener);
    }

    public void saveActionListener(ActionListener actionListener) {
        jButtonSaveChanges.addActionListener(actionListener);
    }

    public void deleteActionListener(ActionListener actionListener) {
        jButtonDelete.addActionListener(actionListener);
    }
}
