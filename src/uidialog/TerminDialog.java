/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uidialog;

import com.toedter.calendar.JDateChooser;
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
import communication.Communication;
import formController.TerminFormController;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private TerminFormController controller;
    public TerminDialog(java.awt.Frame parent, boolean modal, Instruktor ulogovan, TerminFormController controller) {
        initComponents();
        this.parent=(TerminForm) parent;
        this.ulogovan=ulogovan;
        this.controller=controller;
        //fillComboBox();
        //setLocationRelativeTo(null);
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
        jLabelDate = new javax.swing.JLabel();
        jLabelVremeOd = new javax.swing.JLabel();
        jLabelVremeDo = new javax.swing.JLabel();
        jLabelBroj = new javax.swing.JLabel();
        jLabelTip = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kreiraj termin");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Kreiraj termin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 13, 100, 20));

        jLabel2.setText("Datum:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 51, 100, 20));

        jLabel3.setText("Vreme od:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 20));

        jLabel4.setText("Vreme do:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 20));

        jLabel5.setText("Broj skijaša:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 20));

        jLabel7.setText("Tip termina:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 20));
        jPanel1.add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 161, 20));

        SpinnerDateModel modelOd = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        jSpinnerVremeOd.setModel(modelOd);
        JSpinner.DateEditor editorOd = new JSpinner.DateEditor(jSpinnerVremeOd, "HH:mm");
        jSpinnerVremeOd.setEditor(editorOd);
        jPanel1.add(jSpinnerVremeOd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 161, 20));

        SpinnerDateModel modelDo = new SpinnerDateModel(new Date(), null, null, Calendar.MINUTE);
        jSpinnerVremeDo.setModel(modelDo);
        JSpinner.DateEditor editorDo = new JSpinner.DateEditor(jSpinnerVremeDo, "HH:mm");
        jSpinnerVremeDo.setEditor(editorDo);
        jPanel1.add(jSpinnerVremeDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 161, 20));
        jPanel1.add(jSpinnerBrojSkijasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 161, 20));

        jPanel1.add(jComboBoxTipTermina, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 161, 20));

        jLabelDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 20));

        jLabelVremeOd.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelVremeOd.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelVremeOd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 20));

        jLabelVremeDo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelVremeDo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelVremeDo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 140, -1));

        jLabelBroj.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelBroj.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelBroj, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 200, -1));

        jLabelTip.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelTip.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelTip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, -1));

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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getjLabelBroj() {
        return jLabelBroj;
    }

    public void setjLabelBroj(JLabel jLabelBroj) {
        this.jLabelBroj = jLabelBroj;
    }

    public JLabel getjLabelDate() {
        return jLabelDate;
    }

    public void setjLabelDate(JLabel jLabelDate) {
        this.jLabelDate = jLabelDate;
    }

    public JLabel getjLabelTip() {
        return jLabelTip;
    }

    public void setjLabelTip(JLabel jLabelTip) {
        this.jLabelTip = jLabelTip;
    }

    public JLabel getjLabelVremeDo() {
        return jLabelVremeDo;
    }

    public void setjLabelVremeDo(JLabel jLabelVremeDo) {
        this.jLabelVremeDo = jLabelVremeDo;
    }

    public JLabel getjLabelVremeOd() {
        return jLabelVremeOd;
    }

    public void setjLabelVremeOd(JLabel jLabelVremeOd) {
        this.jLabelVremeOd = jLabelVremeOd;
    }

    public Instruktor getUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(Instruktor ulogovan) {
        this.ulogovan = ulogovan;
    }

    public TerminForm getParent() {
        return parent;
    }

    public void setParent(TerminForm parent) {
        this.parent = parent;
    }

    public TerminFormController getController() {
        return controller;
    }

    public void setController(TerminFormController controller) {
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

    public JComboBox<TipTermina> getjComboBoxTipTermina() {
        return jComboBoxTipTermina;
    }

    public void setjComboBoxTipTermina(JComboBox<TipTermina> jComboBoxTipTermina) {
        this.jComboBoxTipTermina = jComboBoxTipTermina;
    }

    public JDateChooser getjDateChooser() {
        return jDateChooser;
    }

    public void setjDateChooser(JDateChooser jDateChooser) {
        this.jDateChooser = jDateChooser;
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

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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

    public JSpinner getjSpinnerBrojSkijasa() {
        return jSpinnerBrojSkijasa;
    }

    public void setjSpinnerBrojSkijasa(JSpinner jSpinnerBrojSkijasa) {
        this.jSpinnerBrojSkijasa = jSpinnerBrojSkijasa;
    }

    public JSpinner getjSpinnerVremeDo() {
        return jSpinnerVremeDo;
    }

    public void setjSpinnerVremeDo(JSpinner jSpinnerVremeDo) {
        this.jSpinnerVremeDo = jSpinnerVremeDo;
    }

    public JSpinner getjSpinnerVremeOd() {
        return jSpinnerVremeOd;
    }

    public void setjSpinnerVremeOd(JSpinner jSpinnerVremeOd) {
        this.jSpinnerVremeOd = jSpinnerVremeOd;
    }

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        //this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        /*try {
            
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
            
            boolean b = Communication.getInstance().kreirajTermin(t);
            if(b){
                JOptionPane.showMessageDialog(this, "Termin uspešno kreiran!","Kreiranje termina",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                parent.fillTable(null);
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Termin nije kreiran!"+ex.getMessage(),"Kreiranje termina",JOptionPane.ERROR_MESSAGE);
        }*/
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
    private javax.swing.JLabel jLabelBroj;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelTip;
    private javax.swing.JLabel jLabelVremeDo;
    private javax.swing.JLabel jLabelVremeOd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerBrojSkijasa;
    private javax.swing.JSpinner jSpinnerVremeDo;
    private javax.swing.JSpinner jSpinnerVremeOd;
    // End of variables declaration//GEN-END:variables


    /*private void fillComboBox() {
         List<TipTermina> listTip;
        try {
            listTip = Communication.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                jComboBoxTipTermina.addItem(t);
            }
            jComboBoxTipTermina.setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom punjenja CB."+ex.getMessage(),"Punjenje CB",JOptionPane.ERROR_MESSAGE);
        }
            
    }*/

    public void addActionListener(ActionListener actionListener) {
        jButtonAdd.addActionListener(actionListener);
    }
    public void backActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }
    
}
