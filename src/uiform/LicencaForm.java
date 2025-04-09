/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Instruktor;
import model.Licenca;
import table_model.LicenceTableModel;
import communication.Communication;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import uidialog.LicencaDialog;

/**
 *
 * @author milan
 */
public class LicencaForm extends javax.swing.JFrame {

    /**
     * Creates new form LicenceForm
     */
    private List<Licenca> list;
    private Instruktor ulogovan;
    
    public LicencaForm(Instruktor ulogovan) {
        this.ulogovan = ulogovan;
        initComponents();
        setLocationRelativeTo(null);
        
    }

    public List<Licenca> getList() {
        return list;
    }

    public void setList(List<Licenca> list) {
        this.list = list;
    }

    public Instruktor getUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(Instruktor ulogovan) {
        this.ulogovan = ulogovan;
    }

    public JButton getjButtonAddLicence() {
        return jButtonAddLicence;
    }

    public void setjButtonAddLicence(JButton jButtonAddLicence) {
        this.jButtonAddLicence = jButtonAddLicence;
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JButton getjButtonClearFilter() {
        return jButtonClearFilter;
    }

    public void setjButtonClearFilter(JButton jButtonClearFilter) {
        this.jButtonClearFilter = jButtonClearFilter;
    }

    public JButton getjButtonDetails() {
        return jButtonDetails;
    }

    public void setjButtonDetails(JButton jButtonDetails) {
        this.jButtonDetails = jButtonDetails;
    }

    public JButton getjButtonFilter() {
        return jButtonFilter;
    }

    public void setjButtonFilter(JButton jButtonFilter) {
        this.jButtonFilter = jButtonFilter;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTableLicence() {
        return jTableLicence;
    }

    public void setjTableLicence(JTable jTableLicence) {
        this.jTableLicence = jTableLicence;
    }

    public JTextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(JTextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public JTextField getjTextFieldZvanje() {
        return jTextFieldZvanje;
    }

    public void setjTextFieldZvanje(JTextField jTextFieldZvanje) {
        this.jTextFieldZvanje = jTextFieldZvanje;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLicence = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldZvanje = new javax.swing.JTextField();
        jButtonFilter = new javax.swing.JButton();
        jButtonClearFilter = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonAddLicence = new javax.swing.JButton();
        jButtonDetails = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Licenca");
        setResizable(false);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Kriterijum pretrage");

        jLabel4.setText("Naziv licence:");

        jLabel5.setText("Zvanje instruktora:");

        jTextFieldName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldZvanje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonFilter.setText("Pretraži");
        jButtonFilter.setFocusPainted(false);
        jButtonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilterActionPerformed(evt);
            }
        });

        jButtonClearFilter.setText("Očisti filtere");
        jButtonClearFilter.setFocusPainted(false);
        jButtonClearFilter.setFocusable(false);
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldZvanje, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                                .addComponent(jButtonClearFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldZvanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClearFilter))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonAddLicence.setText("Dodaj");
        jButtonAddLicence.setFocusPainted(false);
        jButtonAddLicence.setFocusable(false);
        jButtonAddLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLicenceActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Detalji");
        jButtonDetails.setFocusPainted(false);
        jButtonDetails.setFocusable(false);
        jButtonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetailsActionPerformed(evt);
            }
        });

        jButtonBack.setText("Nazad");
        jButtonBack.setFocusPainted(false);
        jButtonBack.setFocusable(false);
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddLicence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddLicence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBack)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetailsActionPerformed
        /*
        int row = jTableLicence.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(rootPane, "Izaberite licencu iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
        }
        LicenceTableModel ltm = (LicenceTableModel) jTableLicence.getModel();
        Licenca l = ltm.getList().get(row);
        
        LicencaDialog ld = new LicencaDialog(this, rootPaneCheckingEnabled, l);
        fillTable();*/
    }//GEN-LAST:event_jButtonDetailsActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
       // this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonAddLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLicenceActionPerformed
       // LicencaDialog ld = new LicencaDialog(this, rootPaneCheckingEnabled, null);
       // fillTable();
    }//GEN-LAST:event_jButtonAddLicenceActionPerformed

    private void jButtonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilterActionPerformed
        /*try {
            defaultBorders();
            if(!validation())
                return;
            
            String name = jTextFieldName.getText();
            String zvanje = jTextFieldZvanje.getText();
            Licenca l = new Licenca();
            l.setNazivLicence(name);
            l.setZvanjeInstruktora(zvanje);
            
            List<Licenca> list = Communication.getInstance().vratiListuLicenca(l);
            LicenceTableModel ltm = new LicenceTableModel(list);
            jTableLicence.setModel(ltm);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom filtriranja instruktora.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
        }
        */
    }//GEN-LAST:event_jButtonFilterActionPerformed

    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed
        /*jTextFieldName.setText("");
        jTextFieldZvanje.setText("");
        defaultBorders();
        fillTable();*/
    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddLicence;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLicence;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldZvanje;
    // End of variables declaration//GEN-END:variables
/*
    private void fillTable() {
        try {
            list = Communication.getInstance().vratiListuSviLicenca();
            LicenceTableModel ltm = new LicenceTableModel(list);
            jTableLicence.setModel(ltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greska prilikom ucitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
    public void defaultBorders() {
        jTextFieldName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        jTextFieldZvanje.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));    
    }

    private boolean validation() {
        boolean valid = true;
        String name = jTextFieldName.getText();
        String zvanje = jTextFieldZvanje.getText();
        if(name.isEmpty() && zvanje.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
            
        if(!name.isEmpty() && !name.matches("^[a-zA-Z ]+$")){
            jTextFieldName.setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!zvanje.isEmpty() && !zvanje.matches("^[a-zA-Z ]+$")){
            jTextFieldZvanje.setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!valid){
            JOptionPane.showMessageDialog(rootPane, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return valid;
    }
*/

    public void searchActionListener(ActionListener actionListener) {
        jButtonFilter.addActionListener(actionListener);
    }

    public void clearFilterActionListener(ActionListener actionListener) {
        jButtonClearFilter.addActionListener(actionListener);
    }

    public void detailsActionListener(ActionListener actionListener) {
        jButtonDetails.addActionListener(actionListener);
    }

    public void addActionListener(ActionListener actionListener) {
        jButtonAddLicence.addActionListener(actionListener);
    }

    public void backActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }
}
