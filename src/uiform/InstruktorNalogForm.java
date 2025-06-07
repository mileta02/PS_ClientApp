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

    public JLabel getjLabelLicenceStatus() {
        return jLabelLicenceStatus;
    }

    public void setjLabelLicenceStatus(JLabel jLabel16) {
        this.jLabelLicenceStatus = jLabel16;
    }

    public JLabel getjLabelLicenceZvanje() {
        return jLabelLicenceZvanje;
    }

    public void setjLabelLicenceZvanje(JLabel jLabel17) {
        this.jLabelLicenceZvanje = jLabel17;
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

    public JLabel getjLabelLicence() {
        return jLabelLicence;
    }

    public void setjLabelLicence(JLabel jLabelLicence) {
        this.jLabelLicence = jLabelLicence;
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

    public JLabel getjLabelName() {
        return jLabelName;
    }

    public void setjLabelName(JLabel jLabel1) {
        this.jLabelName = jLabel1;
    }

    public JLabel getjLabelPasswordValidation() {
        return jLabelPasswordValidation;
    }

    public void setjLabelPasswordValidation(JLabel jLabel10) {
        this.jLabelPasswordValidation = jLabel10;
    }

    public JLabel getjLabelPassword() {
        return jLabelPassword;
    }

    public void setjLabelPassword(JLabel jLabel11) {
        this.jLabelPassword = jLabel11;
    }

    public JLabel getjLabelRepeatPasswordValidation() {
        return jLabelRepeatPasswordValidation;
    }

    public void setjLabelRepeatPasswordValidation(JLabel jLabel12) {
        this.jLabelRepeatPasswordValidation = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabelLicence;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabelLicence = jLabel13;
    }

    public JLabel getjLabelLicenceName() {
        return jLabelLicenceName;
    }

    public void setjLabelLicenceName(JLabel jLabel14) {
        this.jLabelLicenceName = jLabel14;
    }

    public JLabel getjLabelLicenceDate() {
        return jLabelLicenceDate;
    }

    public void setjLabelLicenceDate(JLabel jLabel15) {
        this.jLabelLicenceDate = jLabel15;
    }

    public JLabel getjLabelSurname() {
        return jLabelSurname;
    }

    public void setjLabeSurname(JLabel jLabel2) {
        this.jLabelSurname = jLabel2;
    }

    public JLabel getjLabelContact() {
        return jLabelContact;
    }

    public void setjLabeContact(JLabel jLabel3) {
        this.jLabelContact = jLabel3;
    }

    public JLabel getjLabelUsername() {
        return jLabelUsername;
    }

    public void setjLabelUsername(JLabel jLabel4) {
        this.jLabelUsername = jLabel4;
    }

    public JLabel getjLabelRepeatPassword() {
        return jLabelRepeatPassword;
    }

    public void setjLabelRepeatPassword(JLabel jLabel5) {
        this.jLabelRepeatPassword = jLabel5;
    }

    public JLabel getjLabelNameValidation() {
        return jLabelNameValidation;
    }

    public void setjLabelNameValidation(JLabel jLabel6) {
        this.jLabelNameValidation = jLabel6;
    }

    public JLabel getjLabelSurnameValidation() {
        return jLabelSurnameValidation;
    }

    public void setjLabelSurnameValidation(JLabel jLabel7) {
        this.jLabelSurnameValidation = jLabel7;
    }

    public JLabel getjLabelContactValidation() {
        return jLabelContactValidation;
    }

    public void setjLabelContactValidation(JLabel jLabel8) {
        this.jLabelContactValidation = jLabel8;
    }

    public JLabel getjLabelUsernameValidation() {
        return jLabelUsernameValidation;
    }

    public void setjLabelUsernameValidation(JLabel jLabel9) {
        this.jLabelUsernameValidation = jLabel9;
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
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelSurname = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabelContact = new javax.swing.JLabel();
        jTextFieldContact = new javax.swing.JTextField();
        jLabelUsername = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabelRepeatPassword = new javax.swing.JLabel();
        jPasswordFieldRepeatPass = new javax.swing.JPasswordField();
        jLabelNameValidation = new javax.swing.JLabel();
        jLabelSurnameValidation = new javax.swing.JLabel();
        jLabelContactValidation = new javax.swing.JLabel();
        jLabelUsernameValidation = new javax.swing.JLabel();
        jLabelPasswordValidation = new javax.swing.JLabel();
        jLabelRepeatPasswordValidation = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonEdit = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelLicence = new javax.swing.JLabel();
        jLabelLicenceName = new javax.swing.JLabel();
        jLabelLicenceDate = new javax.swing.JLabel();
        jComboBoxLicence = new javax.swing.JComboBox<>();
        jButtonAdd = new javax.swing.JButton();
        jButtonDeleteLicence = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelDate = new javax.swing.JLabel();
        jLabelLicenceStatus = new javax.swing.JLabel();
        jLabelLicenceZvanje = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelZvanje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInstruktorLicence = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moj nalog");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelName.setText("Ime:");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 20));
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, 20));

        jLabelSurname.setText("Prezime:");
        jPanel1.add(jLabelSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 20));

        jTextFieldSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSurnameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, 20));

        jLabelContact.setText("Kontakt:");
        jPanel1.add(jLabelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));
        jPanel1.add(jTextFieldContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 150, 20));

        jLabelUsername.setText("Korisnicko ime:");
        jPanel1.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 20));
        jPanel1.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 150, 20));

        jLabelPassword.setText("Šifra");
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 20));

        jPasswordFieldPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 150, 20));

        jLabelRepeatPassword.setText("Ponovi šifru");
        jPanel1.add(jLabelRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, 20));

        jPasswordFieldRepeatPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldRepeatPassActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFieldRepeatPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 150, 20));

        jLabelNameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelNameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelNameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 150, 20));

        jLabelSurnameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelSurnameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelSurnameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 150, 20));

        jLabelContactValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelContactValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelContactValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 190, 20));

        jLabelUsernameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelUsernameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelUsernameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, 20));

        jLabelPasswordValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelPasswordValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelPasswordValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 200, 20));

        jLabelRepeatPasswordValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelRepeatPasswordValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelRepeatPasswordValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 200, 20));

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

        jLabelLicence.setText("Licenca");

        jLabelLicenceName.setText("Naziv:");

        jLabelLicenceDate.setText("Datum:");

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

        jLabelLicenceStatus.setText("Status:");

        jLabelLicenceZvanje.setText("Zvanje:");

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
                    .addComponent(jLabelLicenceName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLicence, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabelLicenceDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLicenceStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLicenceZvanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabelLicence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLicenceName)
                            .addComponent(jComboBoxLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLicenceDate))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabelDate)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLicenceStatus)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLicenceZvanje)
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
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JLabel jLabelContactValidation;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelLicence;
    private javax.swing.JLabel jLabelLicenceDate;
    private javax.swing.JLabel jLabelLicenceName;
    private javax.swing.JLabel jLabelLicenceStatus;
    private javax.swing.JLabel jLabelLicenceZvanje;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNameValidation;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPasswordValidation;
    private javax.swing.JLabel jLabelRepeatPassword;
    private javax.swing.JLabel jLabelRepeatPasswordValidation;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JLabel jLabelSurnameValidation;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelUsernameValidation;
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
        
        jLabelRepeatPassword.setVisible(b);
        jLabelPassword.setVisible(b);
        
        jPasswordFieldPass.setVisible(b);
        jPasswordFieldRepeatPass.setVisible(b);
    }

    private void fillLabels() {
        jLabelNameValidation.setText("Unesite ime!"); 
        jLabelSurnameValidation.setText("Unesite prezime!"); 
        jLabelContactValidation.setText("Unesite kontakt telefon!"); 
        jLabelUsernameValidation.setText("Unesite korisničko ime!"); 
        jLabelPasswordValidation.setText("Unesite šifru!");
        jLabelRepeatPasswordValidation.setText("Ponovite šifru!"); 
        jLabelUsernameValidation.setVisible(false);
        jLabelPasswordValidation.setVisible(false);
        jLabelSurnameValidation.setVisible(false);
        jLabelContactValidation.setVisible(false);
        jLabelNameValidation.setVisible(false);
        jLabelRepeatPasswordValidation.setVisible(false);
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
