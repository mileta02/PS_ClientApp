/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;
import model.InstruktorLicenca;
import model.Licenca;
import table_model.InstructorLicenceTableModel;
import table_model.LicenceTableModel;
import uicontroller.Controller;
import uidialog.LicenceDialog;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author milan
 */
public class InstructorLicenceForm extends javax.swing.JFrame {

    /**
     * Creates new form LicenceForm
     */
    private List<InstruktorLicenca> list;
    private Instruktor ulogovan;
    public InstructorLicenceForm(Instruktor ulogovan) {
        this.ulogovan=ulogovan;
        initComponents();
        fillTable();
        fillComboBox();
        setSize(500,300);
        jTableInstruktorLicence.setBounds(20, 20, 400, 100);
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
        jTableInstruktorLicence = new javax.swing.JTable();
        jButtonDelete = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jComboBoxLicence = new javax.swing.JComboBox<>();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moje licence");
        setResizable(false);

        jTableInstruktorLicence.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableInstruktorLicence.setBounds(20, 40, 460, 200);
        jScrollPane1.setViewportView(jTableInstruktorLicence);

        jButtonDelete.setText("Obriši");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonBack.setText("Nazad");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Dodaj");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTextFieldDate.setText("gggg-MM-dd");

        jLabel1.setText("Datum:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButtonAdd)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDelete)
                        .addComponent(jButtonBack)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        
        int row = jTableInstruktorLicence.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(rootPane, "Izaberite licencu iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int i =JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da obrišete licencu?","Brisanje licence",JOptionPane.YES_NO_OPTION);
        
        if(i == JOptionPane.YES_OPTION){
        InstructorLicenceTableModel iltm = (InstructorLicenceTableModel) jTableInstruktorLicence.getModel();
        InstruktorLicenca il = iltm.getList().get(row);
        boolean b;
        try {
            b = Controller.getInstance().obrisiInstruktorLicenca(il);
             if(b){
            JOptionPane.showMessageDialog(rootPane, "Uspešno obrisana licenca.","Uspešno brisanje",JOptionPane.INFORMATION_MESSAGE);
            fillTable();
             }
             else
                 return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom brisanja licence.","Neuspešno brisanje",JOptionPane.ERROR_MESSAGE);
        }
        
        }
        else
            return;
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
       
        Licenca l = (Licenca) jComboBoxLicence.getSelectedItem();
        String datumSticanja = jTextFieldDate.getText();
        try{
            
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(datumSticanja, formater);
        Date sqlDate = Date.valueOf(localDate);
        
        InstruktorLicenca il = new InstruktorLicenca(sqlDate, ulogovan, l);
        
        InstructorLicenceTableModel iltm = (InstructorLicenceTableModel) jTableInstruktorLicence.getModel();
        List<InstruktorLicenca> list = iltm.getList();
        for(InstruktorLicenca ilm : list){
            if(ilm.getInstruktor().getIdInstruktor()==il.getInstruktor().getIdInstruktor() &&
                    ilm.getLicenca().getIdLicenca()==il.getLicenca().getIdLicenca()){
                JOptionPane.showMessageDialog(rootPane, "Greška prilikom unošenja licence, već postoji.","Pogrešan unos licence",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        boolean b = Controller.getInstance().kreirajInstruktorLicenca(il);
        if(b){
            JOptionPane.showMessageDialog(rootPane, "Uspešno uneta licenca.","Uspešno unošenje",JOptionPane.INFORMATION_MESSAGE);
            fillTable();
        }
        }catch(ParseException pe){
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom unošenja datuma.","Pogrešan format datuma",JOptionPane.ERROR_MESSAGE);
            return;
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom dodavanja licence.\n"+ex.getMessage(),"Neuspešno dodavanje",JOptionPane.ERROR_MESSAGE);
                        
        }
          
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JComboBox<Licenca> jComboBoxLicence;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInstruktorLicence;
    private javax.swing.JTextField jTextFieldDate;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
        try {
            list = Controller.getInstance().vratiListuInstruktorLicenca(ulogovan);
            InstructorLicenceTableModel iltm = new InstructorLicenceTableModel(list);
            jTableInstruktorLicence.setModel(iltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom ucitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private void fillComboBox() {
        try {
            List<Licenca> list = Controller.getInstance().vratiListuSviLicenca();
            for(Licenca l : list){
                jComboBoxLicence.addItem(l);
            }
        } catch (Exception ex) {
            Logger.getLogger(InstructorLicenceForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
