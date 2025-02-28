/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uiform;

import uidialog.EditProfileDialog;
import model.Instruktor;

/**
 *
 * @author milan
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    private Instruktor ulogovan;
    
    public MainForm(Instruktor ins) {
        initComponents();
        setLocationRelativeTo(null);
        ulogovan=ins;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemEditProfile = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu3.setText("Nalog");

        jMenuItemEditProfile.setText("Moj nalog");
        jMenuItemEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditProfileActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemEditProfile);

        jMenuItem1.setText("Instruktori");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Odjavi se");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditProfileActionPerformed
        EditProfileDialog epd = new EditProfileDialog(this, rootPaneCheckingEnabled,ulogovan);
        epd.setLocationRelativeTo(null);
        epd.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemEditProfileActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemEditProfile;
    // End of variables declaration//GEN-END:variables
}
