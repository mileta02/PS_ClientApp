/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Instruktor;
import communication.Communication;
import cordinator.Cordinator;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public JButton getjButtonExit() {
        return jButtonExit;
    }

    public void setjButtonExit(JButton jButtonExit) {
        this.jButtonExit = jButtonExit;
    }

    public JButton getjButtonExitRegister() {
        return jButtonRegister;
    }

    public void setjButtonExitRegister(JButton jButtonExitRegister) {
        this.jButtonRegister = jButtonExitRegister;
    }

    public JButton getjButtonLogin() {
        return jButtonLogin;
    }

    public void setjButtonLogin(JButton jButtonLogin) {
        this.jButtonLogin = jButtonLogin;
    }

    public JPasswordField getjPasswordFieldSifra() {
        return jPasswordFieldSifra;
    }

    public void setjPasswordFieldSifra(JPasswordField jPasswordFieldSifra) {
        this.jPasswordFieldSifra = jPasswordFieldSifra;
    }

    public JTextField getjTextFieldKorisnickoIme() {
        return jTextFieldKorisnickoIme;
    }

    public void setjTextFieldKorisnickoIme(JTextField jTextFieldKorisnickoIme) {
        this.jTextFieldKorisnickoIme = jTextFieldKorisnickoIme;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldKorisnickoIme = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldSifra = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(450, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Korisničko ime:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Šifra:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 100, 20));

        jTextFieldKorisnickoIme.setText("admin");
        jTextFieldKorisnickoIme.setBorder(null);
        jTextFieldKorisnickoIme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldKorisnickoImeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldKorisnickoIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 150, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 200, 20));

        jPasswordFieldSifra.setText("admin02");
        jPasswordFieldSifra.setBorder(null);
        jPasswordFieldSifra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldSifraActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordFieldSifra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 150, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 200, 20));

        jButtonLogin.setText("Uloguj se");
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.setFocusable(false);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 25));

        jButtonExit.setText("Izađi");
        jButtonExit.setFocusPainted(false);
        jButtonExit.setFocusable(false);
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, 25));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Nemaš nalog?");

        jButtonRegister.setText("Registruj se");
        jButtonRegister.setFocusPainted(false);
        jButtonRegister.setFocusable(false);
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
       // this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        //validacija
        /*
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
        */
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
       // this.dispose();
       // Cordinator.getInstance().openRegisterForm();
    }//GEN-LAST:event_jButtonRegisterActionPerformed

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
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldSifra;
    private javax.swing.JTextField jTextFieldKorisnickoIme;
    // End of variables declaration//GEN-END:variables

    public void loginActionListener(ActionListener actionListener) {
        jButtonLogin.addActionListener(actionListener);
    }

    public void registerActionListener(ActionListener actionListener) {
        jButtonRegister.addActionListener(actionListener);
    }

    public void exitActionListener(ActionListener actionListener) {
        jButtonExit.addActionListener(actionListener);
    }
}
