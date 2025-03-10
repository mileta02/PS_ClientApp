/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Licenca;
import table_model.LicenceTableModel;
import uicontroller.Controller;
import uidialog.LicenceDialog;

/**
 *
 * @author milan
 */
public class LicenceForm extends javax.swing.JFrame {

    /**
     * Creates new form LicenceForm
     */
    private List<Licenca> list;
    public LicenceForm() {
        initComponents();
        fillTable();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLicence = new javax.swing.JTable();
        jButtonBack = new javax.swing.JButton();
        jButtonDetails = new javax.swing.JButton();
        jButtonAddLicence = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableLicence.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableLicence);

        jButtonBack.setText("Nazad");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Detalji");
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });

        jButtonAddLicence.setText("Dodaj");
        jButtonAddLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLicenceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonAddLicence, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonBack, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButtonDetails))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddLicence)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
        
        int row = jTableLicence.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(rootPane, "Izaberite licencu iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
        }
        LicenceTableModel ltm = (LicenceTableModel) jTableLicence.getModel();
        Licenca l = ltm.getList().get(row);
        
        LicenceDialog ld = new LicenceDialog(this, rootPaneCheckingEnabled, l);
        fillTable();
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLicenceActionPerformed
        LicenceDialog ld = new LicenceDialog(this, rootPaneCheckingEnabled, null);
        fillTable();
    }//GEN-LAST:event_jButtonAddLicenceActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddLicence;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLicence;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        try {
            list = Controller.getInstance().vratiListuSviLicenca();
            LicenceTableModel ltm = new LicenceTableModel(list);
            jTableLicence.setModel(ltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom ucitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR);
            
        }
    }
}
