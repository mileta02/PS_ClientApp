/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Instruktor;
import uicontroller.Controller;

/**
 *
 * @author milan
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        setTitle("Login"); 
        setSize(450, 300); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldKorisnickoIme = new javax.swing.JTextField();
        jPasswordFieldSifra = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonExitRegister = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 500));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Šifra:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(75, 80, 100, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Korisničko ime:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(75, 40, 100, 20);

        jTextFieldKorisnickoIme.setText("admin");
        jTextFieldKorisnickoIme.setBorder(null);
        jTextFieldKorisnickoIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKorisnickoImeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldKorisnickoIme);
        jTextFieldKorisnickoIme.setBounds(225, 40, 150, 20);

        jPasswordFieldSifra.setText("admin02");
        jPasswordFieldSifra.setBorder(null);
        jPasswordFieldSifra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSifraActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSifra);
        jPasswordFieldSifra.setBounds(225, 80, 150, 20);

        jButtonLogin.setText("Uloguj se");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin);
        jButtonLogin.setBounds(150, 120, 150, 25);

        jButtonExit.setText("Izađi");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit);
        jButtonExit.setBounds(150, 150, 150, 25);

        jButtonExitRegister.setText("Registruj se");
        jButtonExitRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExitRegister);
        jButtonExitRegister.setBounds(225, 215, 115, 25);

        jLabel3.setText("Nemaš nalog?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(115, 215, 100, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(225, 100, 200, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(225, 60, 200, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String username = jTextFieldKorisnickoIme.getText();
        String pass = String.valueOf(jPasswordFieldSifra.getText());
        
        jLabel5.setText("");
        jLabel4.setText("");
        
        boolean valid = true;
        
        if (username.isEmpty()) {
            jLabel5.setText("Unesite korisničko ime!");
            valid = false;
        } else if (username.length() < 5) {
            jLabel5.setText("Korisničko ime mora imati bar 5 karaktera!");
            valid = false;
        }
        if (pass.isEmpty()) {
            jLabel4.setText("Unesite šifru!");
            valid = false;
        } else if (pass.length() < 5) {
            jLabel4.setText("Šifra mora imati bar 5 karaktera!");
            valid = false;
        } else if (!pass.matches(".*\\d.*")) { 
            jLabel4.setText("Šifra mora sadržati bar jedan broj!");
            valid = false;
        }
        
        if(!valid)
            return;
        
        Instruktor i = new Instruktor(username,pass);
        try {
            Instruktor ins = Controller.getInstance().login(i);
            JOptionPane.showMessageDialog(this, ins.getKorisnickoIme()+" se ulogovao/la!", "Login", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            GlavnaForm mf = new GlavnaForm(ins);
            mf.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspesno prijavljivanje!\n"+ex.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonExitRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitRegisterActionPerformed
        this.dispose();
        RegisterForm rf = new RegisterForm();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButtonExitRegisterActionPerformed

    private void jPasswordFieldSifraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldSifraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldSifraActionPerformed

    private void jTextFieldKorisnickoImeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldKorisnickoImeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldKorisnickoImeActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonExitRegister;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordFieldSifra;
    private javax.swing.JTextField jTextFieldKorisnickoIme;
    // End of variables declaration//GEN-END:variables
}
