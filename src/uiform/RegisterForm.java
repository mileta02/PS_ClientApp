/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;
import communication.Communication;
import cordinator.Cordinator;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author milan
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
        initComponents();
        //fillLabels();
        setLocationRelativeTo(null);
    }

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JButton getjButtonRegister() {
        return jButtonRegister;
    }

    public void setjButtonRegister(JButton jButtonRegister) {
        this.jButtonRegister = jButtonRegister;
    }
    
    public JLabel getjLabelContact() {
        return jLabelContact;
    }

    public void setjLabelContact(JLabel jLabelContact) {
        this.jLabelContact = jLabelContact;
    }

    public JLabel getjLabelName() {
        return jLabelName;
    }

    public void setjLabelName(JLabel jLabelName) {
        this.jLabelName = jLabelName;
    }

    public JLabel getjLabelPassword() {
        return jLabelPassword;
    }

    public void setjLabelPassword(JLabel jLabelPassword) {
        this.jLabelPassword = jLabelPassword;
    }

    public JLabel getjLabelRepeatPassword() {
        return jLabelRepeatPassword;
    }

    public void setjLabelRepeatPassword(JLabel jLabelRepeatPassword) {
        this.jLabelRepeatPassword = jLabelRepeatPassword;
    }

    public JLabel getjLabelSurname() {
        return jLabelSurname;
    }

    public void setjLabelSurname(JLabel jLabelSurname) {
        this.jLabelSurname = jLabelSurname;
    }

    public JLabel getjLabelUsername() {
        return jLabelUsername;
    }

    public void setjLabelUsername(JLabel jLabelUsername) {
        this.jLabelUsername = jLabelUsername;
    }
    
    public JLabel getjLabelContactValidation() {
        return jLabelContactValidation;
    }

    public void setjLabelContactValidation(JLabel jLabelContact) {
        this.jLabelContactValidation = jLabelContact;
    }

    public JLabel getjLabelNameValidation() {
        return jLabelNameValidation;
    }

    public void setjLabelNameValidation(JLabel jLabelName) {
        this.jLabelNameValidation = jLabelName;
    }

    public JLabel getjLabelPasswordValidation() {
        return jLabelPasswordValidation;
    }

    public void setjLabelPasswordValidation(JLabel jLabelPass) {
        this.jLabelPasswordValidation = jLabelPass;
    }

    public JLabel getjLabelRepeatPasswordValidation() {
        return jLabelRepeatPasswordValidation;
    }

    public void setjLabelRepeatPasswordValidation(JLabel jLabelRepeatPass) {
        this.jLabelRepeatPasswordValidation = jLabelRepeatPass;
    }

    public JLabel getjLabelSurnameValidation() {
        return jLabelSurnameValidation;
    }

    public void setjLabelSurnameValidation(JLabel jLabelSurname) {
        this.jLabelSurnameValidation = jLabelSurname;
    }

    public JLabel getjLabelUsernameValidation() {
        return jLabelUsernameValidation;
    }

    public void setjLabelUsernameValidation(JLabel jLabelUsername) {
        this.jLabelUsernameValidation = jLabelUsername;
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

    public JTextField getjTextFieldUser() {
        return jTextFieldUser;
    }

    public void setjTextFieldUser(JTextField jTextFieldUser) {
        this.jTextFieldUser = jTextFieldUser;
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
        jLabelSurname = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelNameValidation = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabelSurnameValidation = new javax.swing.JLabel();
        jLabelContact = new javax.swing.JLabel();
        jTextFieldContact = new javax.swing.JTextField();
        jLabelContactValidation = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabelUsername = new javax.swing.JLabel();
        jLabelUsernameValidation = new javax.swing.JLabel();
        jPasswordFieldPass = new javax.swing.JPasswordField();
        jLabelPassword = new javax.swing.JLabel();
        jLabelPasswordValidation = new javax.swing.JLabel();
        jPasswordFieldRepeatPass = new javax.swing.JPasswordField();
        jLabelRepeatPassword = new javax.swing.JLabel();
        jLabelRepeatPasswordValidation = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonRegister = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelName.setText("Ime:");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 23, 110, 20));

        jLabelSurname.setText("Prezime:");
        jPanel1.add(jLabelSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 70, 110, 20));
        jPanel1.add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 23, 200, 20));

        jLabelNameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelNameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelNameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 49, 150, 15));

        jTextFieldSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSurnameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 70, 200, 20));

        jLabelSurnameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelSurnameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelSurnameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 96, 150, 15));

        jLabelContact.setText("Kontakt telefon:");
        jPanel1.add(jLabelContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 117, 110, 20));
        jPanel1.add(jTextFieldContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 117, 200, 20));

        jLabelContactValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelContactValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelContactValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 143, 200, 15));
        jPanel1.add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 164, 200, 20));

        jLabelUsername.setText("Korisničko ime:");
        jPanel1.add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 164, 110, 20));

        jLabelUsernameValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelUsernameValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelUsernameValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 190, 200, 15));
        jPanel1.add(jPasswordFieldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 211, 200, 20));

        jLabelPassword.setText("Šifra:");
        jPanel1.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 211, 110, 20));

        jLabelPasswordValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelPasswordValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelPasswordValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 237, 200, 15));
        jPanel1.add(jPasswordFieldRepeatPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 258, 200, 20));

        jLabelRepeatPassword.setText("Povtrdi šifru:");
        jPanel1.add(jLabelRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 258, 110, 20));

        jLabelRepeatPasswordValidation.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabelRepeatPasswordValidation.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabelRepeatPasswordValidation, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 284, 200, 15));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonRegister.setText("Registruj se");
        jButtonRegister.setHideActionText(true);
        jButtonRegister.setPreferredSize(new java.awt.Dimension(100, 25));
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        jButtonBack.setText("Nazad na login");
        jButtonBack.setHideActionText(true);
        jButtonBack.setPreferredSize(new java.awt.Dimension(100, 25));
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
                .addGap(18, 18, 18)
                .addComponent(jButtonRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        //validacija
        /*
        fillLabels();
        boolean valid = true;
        
        if (name.isEmpty()) {
            jLabelName.setVisible(true);
            valid=false;
        }   
        if (surname.isEmpty()) {
            jLabelSurname.setVisible(true);
            valid=false;
        }
        if (contact.isEmpty()) {
            jLabelContact.setVisible(true);
            valid=false;
        }else if (!contact.matches("\\+?[0-9]{9,15}")) {
            jLabelContact.setText("Kontakt mora imati 9-15 cifara!");
            jLabelContact.setVisible(true);
            valid = false;
        }
        if (user.isEmpty()) {
            jLabelUsername.setVisible(true);
            valid=false;
        }else if (user.length() < 5) {
            jLabelUsername.setText("Korisničko ime mora imati bar 5 karaktera!");
            jLabelUsername.setVisible(true);
            valid = false;
        }
        if (pass.isEmpty()) {
            jLabelPass.setVisible(true);
            valid=false;
        }else if (pass.length() < 5) {
            jLabelPass.setText("Šifra mora imati bar 5 karaktera!");
            jLabelPass.setVisible(true);
            valid = false;
        } else if (!pass.matches(".*\\d.*")) { 
            jLabelPass.setText("Šifra mora sadržati bar jedan broj!");
            jLabelPass.setVisible(true);
            valid = false;
        }
        if (repeatPass.isEmpty()) {
            jLabelRepeatPass.setVisible(true);
            valid=false;
        }else if (!pass.equals(repeatPass)) {
            jLabelPass.setText("Šifre se ne poklapaju!");
            jLabelRepeatPass.setText("Šifre se ne poklapaju!");
            jLabelPass.setVisible(true);
            jLabelRepeatPass.setVisible(true);
            valid = false;
        }   
    
        
        if(!valid){
            
            return;
        }
        */
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    private void jTextFieldSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSurnameActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
       // this.dispose();
       // Cordinator.getInstance().openLoginForm();
    }//GEN-LAST:event_jButtonBackActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JLabel jLabelContactValidation;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNameValidation;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPasswordValidation;
    private javax.swing.JLabel jLabelRepeatPassword;
    private javax.swing.JLabel jLabelRepeatPasswordValidation;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JLabel jLabelSurnameValidation;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelUsernameValidation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldPass;
    private javax.swing.JPasswordField jPasswordFieldRepeatPass;
    private javax.swing.JTextField jTextFieldContact;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    /*private void fillLabels() {
        jLabelName.setText("Unesite ime!"); 
        jLabelSurname.setText("Unesite prezime!"); 
        jLabelContact.setText("Unesite kontakt telefon!"); 
        jLabelUsername.setText("Unesite korisničko ime!"); 
        jLabelPass.setText("Unesite šifru!"); 
        jLabelRepeatPass.setText("Ponovite šifru!"); 
        jLabelContact.setVisible(false);
        jLabelUsername.setVisible(false);
        jLabelName.setVisible(false);
        jLabelSurname.setVisible(false);
        jLabelPass.setVisible(false);
        jLabelRepeatPass.setVisible(false);
    }*/

    public void registerActionListener(ActionListener actionListener) {
        jButtonRegister.addActionListener(actionListener);
    }

    public void exitActionListener(ActionListener actionListener) {
        jButtonBack.addActionListener(actionListener);
    }
}
