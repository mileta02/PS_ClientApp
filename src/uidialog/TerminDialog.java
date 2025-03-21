/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uidialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.sql.Time;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import model.Instruktor;
import model.Skijas;
import model.Termin;
import model.TipTermina;
import uicontroller.Controller;
import uiform.TerminForm;

/**
 *
 * @author milan
 */
public class TerminDialog extends javax.swing.JDialog {

    /**
     * Creates new form KreirajTerminForm
     */
    private Instruktor ulogovan;
    private TerminForm parent;
    public TerminDialog(java.awt.Frame parent, boolean modal, Instruktor ulogovan) {
        initComponents();
        fillComboBox();
        this.parent=(TerminForm) parent;
        this.ulogovan=ulogovan;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jSpinnerVremeOd = new javax.swing.JSpinner();
        jSpinnerVremeDo = new javax.swing.JSpinner();
        jSpinnerBrojSkijasa = new javax.swing.JSpinner();
        jComboBoxTipTermina = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj termin");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Kreiraj termin");

        jLabel2.setText("Datum:");

        jLabel3.setText("Vreme od:");

        jLabel4.setText("Vreme do:");

        jLabel5.setText("Broj skijaša:");

        jLabel7.setText("Tip termina:");

        SpinnerDateModel modelOd = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        jSpinnerVremeOd.setModel(modelOd);
        JSpinner.DateEditor editorOd = new JSpinner.DateEditor(jSpinnerVremeOd, "HH:mm");
        jSpinnerVremeOd.setEditor(editorOd);

        SpinnerDateModel modelDo = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        jSpinnerVremeDo.setModel(modelDo);
        JSpinner.DateEditor editorDo = new JSpinner.DateEditor(jSpinnerVremeDo, "HH:mm");
        jSpinnerVremeDo.setEditor(editorDo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerVremeOd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerVremeDo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinnerBrojSkijasa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxTipTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerVremeOd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerVremeDo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerBrojSkijasa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAdd.setText("Dodaj");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonBack.setText("Nazad");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonBack))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
            
            Date utilDate = jDateChooser.getDate();
            LocalDate date = (utilDate == null) ? null : utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if (date == null) {
                JOptionPane.showMessageDialog(this, "Molimo izaberite datum!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }   
            if (date.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(this, "Ne možete zakazati termin u prošlosti!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Date vremeOdDate = (Date) jSpinnerVremeOd.getValue();
            LocalTime vremeOd = vremeOdDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

            Date vremeDoDate = (Date) jSpinnerVremeDo.getValue();
            LocalTime vremeDo = vremeDoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            
            if (vremeDo.isBefore(vremeOd)) {
                JOptionPane.showMessageDialog(this, "Vreme završetka ne može biti pre početka!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            System.out.println("Vreme od: " + vremeOd);
            System.out.println("Vreme do: " + vremeDo);
                        
            int brojSati = (int) Duration.between(vremeOd, vremeDo).toHours();
            System.out.println("Broj sati: " + brojSati);

            int maxBrojSkijasa = (int) jSpinnerBrojSkijasa.getValue();
            
            if (maxBrojSkijasa<=0) {
                JOptionPane.showMessageDialog(this, "Broj skijaša mora biti veći od 0!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            TipTermina tip = (TipTermina) jComboBoxTipTermina.getSelectedItem();
            if(tip==null){
                JOptionPane.showMessageDialog(this, "Izaberite tip termina!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
          
            
            Termin t = new Termin();
            t.setBrojSati(brojSati);
            t.setDatum(date);
            t.setVremeOd(vremeOd);
            t.setVremeDo(vremeDo);
            t.setMaxBrojSkijasa(maxBrojSkijasa);
            t.setTipTermina(tip);
            t.setInstruktor(ulogovan);
            
            boolean b = Controller.getInstance().kreirajTermin(t);
            if(b){
                JOptionPane.showMessageDialog(this, "Termin uspešno kreiran!","Kreiranje termina",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                parent.fillTable(null);
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Termin nije kreiran!"+ex.getMessage(),"Kreiranje termina",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JComboBox<TipTermina> jComboBoxTipTermina;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerBrojSkijasa;
    private javax.swing.JSpinner jSpinnerVremeDo;
    private javax.swing.JSpinner jSpinnerVremeOd;
    // End of variables declaration//GEN-END:variables

    private void fillComboBox() {
         List<TipTermina> listTip;
        try {
            listTip = Controller.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                jComboBoxTipTermina.addItem(t);
            }
            jComboBoxTipTermina.setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom punjenja CB."+ex.getMessage(),"Punjenje CB",JOptionPane.ERROR_MESSAGE);
        }
            
    }

    
}
