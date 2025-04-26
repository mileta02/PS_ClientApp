/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package uiform;

import com.toedter.calendar.JDateChooser;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;
import model.InstruktorLicenca;
import model.Licenca;
import table_model.InstructorLicenceTableModel;
import communication.Communication;
import java.awt.event.ActionListener;
import uiform.LoginForm;
import uiform.GlavnaForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.format.DateTimeParseException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZoneId;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author milan
 */
public class InstruktorNalogForm extends javax.swing.JFrame {

    /**
     * Creates new form EditProfileDialog
     */
    private Instruktor logged;
    private GlavnaForm parent;
    public InstruktorNalogForm(GlavnaForm parent, Instruktor ulogovan) {
        initComponents();
        logged=ulogovan;
        this.parent=parent;
        //fillTextFields();
        //fillComboBox();
        //fillTable();
        //configureVisibility(false);
        setLocationRelativeTo(null);
        
    }

    public GlavnaForm getParent() {
        return parent;
    }

    public void setParent(GlavnaForm parent) {
        this.parent = parent;
    }

    public JLabel getjLabelStatus() {
        return jLabelStatus;
    }

    public void setjLabelStatus(JLabel jLabelStatus) {
        this.jLabelStatus = jLabelStatus;
    }

    public JLabel getjLabelZvanje() {
        return jLabelZvanje;
    }

    public void setjLabelZvanje(JLabel jLabelZvanje) {
        this.jLabelZvanje = jLabelZvanje;
    }

    public JLabel getjLabel16() {
        return jLabel16;
    }

    public void setjLabel16(JLabel jLabel16) {
        this.jLabel16 = jLabel16;
    }

    public JLabel getjLabel17() {
        return jLabel17;
    }

    public void setjLabel17(JLabel jLabel17) {
        this.jLabel17 = jLabel17;
    }

    
    
    public JLabel getjLabelDate() {
        return jLabelDate;
    }

    public void setjLabelDate(JLabel jLabelDate) {
        this.jLabelDate = jLabelDate;
    }

    public Instruktor getLogged() {
        return logged;
    }

    public void setLogged(Instruktor logged) {
        this.logged = logged;
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

    public JButton getjButtonDelete() {
        return jButtonDelete;
    }

    public void setjButtonDelete(JButton jButtonDelete) {
        this.jButtonDelete = jButtonDelete;
    }

    public JButton getjButtonEdit() {
        return jButtonEdit;
    }

    public JButton getjButtonDeleteLicence() {
        return jButtonDeleteLicence;
    }

    public void setjButtonDeleteLicence(JButton jButtonDeleteLicence) {
        this.jButtonDeleteLicence = jButtonDeleteLicence;
    }
    

    public void setjButtonEdit(JButton jButtonEdit) {
        this.jButtonEdit = jButtonEdit;
    }

    public JButton getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(JButton jButtonSave) {
        this.jButtonSave = jButtonSave;
    }

    public JComboBox<Licenca> getjComboBoxLicence() {
        return jComboBoxLicence;
    }

    public void setjComboBoxLicence(JComboBox<Licenca> jComboBoxLicence) {
        this.jComboBoxLicence = jComboBoxLicence;
    }

    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel15() {
        return jLabel15;
    }

    public void setjLabel15(JLabel jLabel15) {
        this.jLabel15 = jLabel15;
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

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
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

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPasswordField getjPasswordFieldPass() {
        return jPasswordFieldPass;
    }

    public void setjPasswordFieldPass(JPasswordField jPasswordFieldPass) {
        this.jPasswordFieldPass = jPasswordFieldPass;
    }

    public JPasswordField getjPasswordFieldRepeatPass() {
        return jPasswordFieldRepeatPass;
    }

    public void setjPasswordFieldRepeatPass(JPasswordField jPasswordFieldRepeatPass) {
        this.jPasswordFieldRepeatPass = jPasswordFieldRepeatPass;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTableInstruktorLicence() {
        return jTableInstruktorLicence;
    }

    public void setjTableInstruktorLicence(JTable jTableInstruktorLicence) {
        this.jTableInstruktorLicence = jTableInstruktorLicence;
    }

    public JTextField getjTextFieldContact() {
        return jTextFieldContact;
    }

    public void setjTextFieldContact(JTextField jTextFieldContact) {
        this.jTextFieldContact = jTextFieldContact;
    }

    public JTextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(JTextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public JTextField getjTextFieldSurname() {
        return jTextFieldSurname;
    }

    public void setjTextFieldSurname(JTextField jTextFieldSurname) {
        this.jTextFieldSurname = jTextFieldSurname;
    }

    public JTextField getjTextFieldUsername() {
        return jTextFieldUsername;
    }

    public void setjTextFieldUsername(JTextField jTextFieldUsername) {
        this.jTextFieldUsername = jTextFieldUsername;
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
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldContact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldRepeatPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonEdit = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxLicence = new javax.swing.JComboBox<>();
        jButtonAdd = new javax.swing.JButton();
        jButtonDeleteLicence = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelDate = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelZvanje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInstruktorLicence = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moj nalog");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ime:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 24, 100, 20));
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 24, 150, 20));

        jLabel2.setText("Prezime:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 76, 100, 20));

        jTextFieldSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSurnameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 76, 150, 20));

        jLabel3.setText("Kontakt:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 128, 100, 20));
        jPanel1.add(jTextFieldContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 128, 150, 20));

        jLabel4.setText("Korisnicko ime:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 180, 100, 20));
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 180, 150, 20));

        jLabel11.setText("Šifra");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 232, 100, 20));

        jPasswordFieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 232, 150, 20));

        jLabel5.setText("Ponovi šifru");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 284, 100, 20));

        jPasswordFieldRepeatPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldRepeatPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFieldRepeatPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 284, 150, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 50, 150, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 102, 150, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 154, 150, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 204, 150, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 258, 170, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 310, 170, 20));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jButtonEdit.setText("Izmeni ");
        jButtonEdit.setFocusPainted(false);
        jButtonEdit.setFocusable(false);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEdit);
        jButtonEdit.setBounds(10, 25, 80, 25);

        jButtonSave.setText("Sačuvaj");
        jButtonSave.setFocusPainted(false);
        jButtonSave.setFocusable(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSave);
        jButtonSave.setBounds(10, 25, 80, 25);

        jButtonBack.setText("Nazad");
        jButtonBack.setFocusPainted(false);
        jButtonBack.setFocusable(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBack);
        jButtonBack.setBounds(100, 25, 80, 25);

        jButtonDelete.setText("Obriši nalog");
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.setFocusable(false);
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonDelete);
        jButtonDelete.setBounds(210, 25, 130, 25);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Licenca");

        jLabel14.setText("Naziv:");

        jLabel15.setText("Datum:");

        jComboBoxLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLicenceActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Dodaj");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDeleteLicence.setText("Obriši");
        jButtonDeleteLicence.setFocusPainted(false);
        jButtonDeleteLicence.setFocusable(false);
        jButtonDeleteLicence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteLicenceActionPerformed(evt);
            }
        });

        jLabelDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 0, 0));

        jLabel16.setText("Status:");

        jLabel17.setText("Zvanje:");

        jLabelZvanje.setForeground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDeleteLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLicence, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZvanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jComboBoxLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabelDate)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabelZvanje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteLicence)
                .addGap(16, 16, 16))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
       /* try {
            String pass = String.valueOf(jPasswordFieldPass.getPassword());
            String repeatPass = String.valueOf(jPasswordFieldRepeatPass.getPassword());
            String user = jTextFieldUsername.getText();
            String name = jTextFieldName.getText();
            String contact = jTextFieldContact.getText();
            String surname = jTextFieldSurname.getText();
            
            fillLabels();
            boolean valid = true;
        
            if (name.isEmpty()) {
                jLabel6.setVisible(true);
                valid=false;
            }   
            if (surname.isEmpty()) {
                jLabel7.setVisible(true);
                valid=false;
            }
            if (contact.isEmpty()) {
                jLabel8.setVisible(true);
                valid=false;
            }else if (!contact.matches("\\+?[0-9]{9,15}")) {
                jLabel8.setText("Kontakt mora imati 9-15 cifara!");
                jLabel8.setVisible(true);
                valid = false;
            }
            if (user.isEmpty()) {
                jLabel9.setVisible(true);
                valid=false;
            }else if (user.length() < 5) {
                jLabel9.setText("Korisničko ime mora imati bar 5 karaktera!");
                jLabel9.setVisible(true);
                valid = false;
            }
            if (pass.isEmpty()) {
                jLabel10.setVisible(true);
                valid=false;
            }else if (pass.length() < 5) {
            jLabel10.setText("Šifra mora imati bar 5 karaktera!");
            jLabel10.setVisible(true);
            valid = false;
            } else if (!pass.matches(".*\\d.*")) { 
                jLabel10.setText("Šifra mora sadržati bar jedan broj!");
                jLabel10.setVisible(true);
                valid = false;
            }
             if (repeatPass.isEmpty()) {
                jLabel12.setVisible(true);
                valid=false;
            }else if (!pass.equals(repeatPass)) {
                jLabel10.setText("Šifre se ne poklapaju!");
                jLabel12.setText("Šifre se ne poklapaju!");
                jLabel10.setVisible(true);
                jLabel12.setVisible(true);
                valid = false;
            }
             if(!valid){
                 return;
             }   
           
            if(name.equals(logged.getIme()) && pass.equals(logged.getSifra()) && surname.equals(logged.getPrezime()) && 
                    contact.equals(logged.getKontakt()) && user.equals(logged.getKorisnickoIme())){
                JOptionPane.showMessageDialog(this, "Niste izmenili podatke. \n","Izmena podataka",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int odgovor = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da izmenite podatke?", "Potvrda izmene podataka",JOptionPane.YES_NO_OPTION);
            
            if(odgovor==JOptionPane.YES_OPTION){
                logged.setIdInstruktor(logged.getIdInstruktor());
                logged.setIme(name);
                logged.setPrezime(surname);
                logged.setKontakt(contact);
                logged.setKorisnickoIme(user);
                logged.setSifra(pass);
                boolean b = Communication.getInstance().promeniInstruktor(logged);
                JOptionPane.showMessageDialog(this, "Uspesno ste izmenili podatke.");
                this.dispose();
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greska kod azuriranja podataka. \n"+ex.getMessage(),"Izmena podataka",JOptionPane.ERROR_MESSAGE);
            
        }*/
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
      /*  configureVisibility(true);
        jButtonEdit.setVisible(false);
        jButtonDelete.setVisible(false);*/
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        /*int odgovor = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da obrišete nalog?", "Potvrda brisanja",JOptionPane.YES_NO_OPTION);
        try{
        if (odgovor == JOptionPane.YES_OPTION) {
            if(Communication.getInstance().obrisiInstruktor(logged))
                JOptionPane.showMessageDialog(this, "Uspesno ste obrisali nalog.");
                this.dispose();
                new LoginForm().setVisible(true);
        }
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Greska kod brisanja instruktora. \n"+ex.getMessage(),"Brisanje instruktora",JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
//        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jPasswordFieldRepeatPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldRepeatPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldRepeatPassActionPerformed

    private void jPasswordFieldPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPassActionPerformed

    private void jTextFieldSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSurnameActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
    /*        try{
            Date utilDate = jDateChooser1.getDate();
            if(utilDate==null){
                JOptionPane.showMessageDialog(rootPane, "Izaberite datum.","Dodavanje licence",JOptionPane.WARNING_MESSAGE);
                return;
            }
            LocalDate date = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if(date.isAfter(LocalDate.now())){
                JOptionPane.showMessageDialog(rootPane, "Datum se mora odnositi na prošlost.","Dodavanje licence",JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            InstruktorLicenca il = new InstruktorLicenca();
            il.setDatumSticanja(date);
            il.setLicenca((Licenca) jComboBoxLicence.getSelectedItem());
            il.setInstruktor(logged);

            boolean b = Communication.getInstance().kreirajInstruktorLicenca(il);
            if(b){
                JOptionPane.showMessageDialog(rootPane, "Uspešno uneta licenca.","Dodavanje licence",JOptionPane.INFORMATION_MESSAGE);
                fillTable();
            }
        }catch(DateTimeParseException pe){
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom unošenja datuma, loš format.","Pogrešan format datuma",JOptionPane.ERROR_MESSAGE);
            return;
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom dodavanja licence.\n Već postoji.","Neuspešno dodavanje",JOptionPane.ERROR_MESSAGE);
            return;
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom dodavanja licence.\n"+ex.getMessage(),"Neuspešno dodavanje",JOptionPane.ERROR_MESSAGE);
            return;
        }*/
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jComboBoxLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLicenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxLicenceActionPerformed

    private void jButtonDeleteLicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteLicenceActionPerformed
/*
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
                b = Communication.getInstance().obrisiInstruktorLicenca(il);
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
        return;*/
    }//GEN-LAST:event_jButtonDeleteLicenceActionPerformed

    /**
     * @param args the command line arguments
     */

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDeleteLicence;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<Licenca> jComboBoxLicence;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelZvanje;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JPasswordField jPasswordFieldRepeatPass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInstruktorLicence;
    private javax.swing.JTextField jTextFieldContact;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void fillTextFields() {
        jTextFieldName.setText(logged.getIme());
        jTextFieldSurname.setText(logged.getPrezime());
        jTextFieldUsername.setText(logged.getKorisnickoIme());
        jTextFieldContact.setText(logged.getKontakt());
    }

    private void configureVisibility(boolean b) {
        jTextFieldName.setEnabled(b);
        jTextFieldSurname.setEnabled(b);
        jTextFieldContact.setEnabled(b);
        jTextFieldUsername.setEnabled(b);
        
        jButtonSave.setVisible(b);
        
        jLabel5.setVisible(b);
        jLabel11.setVisible(b);
        
        jPasswordFieldPass.setVisible(b);
        jPasswordFieldRepeatPass.setVisible(b);
    }

    private void fillLabels() {
        jLabel6.setText("Unesite ime!"); 
        jLabel7.setText("Unesite prezime!"); 
        jLabel8.setText("Unesite kontakt telefon!"); 
        jLabel9.setText("Unesite korisničko ime!"); 
        jLabel10.setText("Unesite šifru!");
        jLabel12.setText("Ponovite šifru!"); 
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel6.setVisible(false);
        jLabel12.setVisible(false);
    }
    
    private void fillComboBox() {
        try {
            List<Licenca> list = Communication.getInstance().vratiListuSviLicenca();
            for(Licenca l : list){
                jComboBoxLicence.addItem(l);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void fillTable() {
        try {
            List<InstruktorLicenca> list = Communication.getInstance().vratiListuInstruktorLicenca(logged);
            InstructorLicenceTableModel iltm = new InstructorLicenceTableModel(list);
            jTableInstruktorLicence.setModel(iltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public void addLicenceActionListener(ActionListener actionListener) {
        jButtonAdd.addActionListener(actionListener);
    }

    public void deleteLicenceActionListener(ActionListener actionListener) {
        jButtonDeleteLicence.addActionListener(actionListener);
    }

    public void deleteAccountActionListener(ActionListener actionListener) {
        jButtonDelete.addActionListener(actionListener);
    }

    public void editAccoutActionListener(ActionListener actionListener) {
        jButtonEdit.addActionListener(actionListener);
    }

    public void saveChangesActionListener(ActionListener actionListener) {
        jButtonSave.addActionListener(actionListener);
    }

    public void backActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }
}
