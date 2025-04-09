/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import communication.Communication;
import cordinator.Cordinator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Instruktor;
import uiform.LoginForm;
import uiform.RegisterForm;

/**
 *
 * @author milan
 */
public class RegisterController {
    private RegisterForm rf;

    public RegisterController(RegisterForm rf) {
        this.rf=rf;
        addActionListener();
    }

    private void addActionListener() {
        rf.registerActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }

            private void register() {
                String pass = String.valueOf(rf.getjPasswordFieldPass().getPassword());
                String repeatPass = String.valueOf(rf.getjPasswordFieldRepeatPass().getPassword());
                String user = rf.getjTextFieldUser().getText();
                String name = rf.getjTextFieldName().getText();
                String contact = rf.getjTextFieldContact().getText();
                String surname = rf.getjTextFieldSurname().getText();
                Instruktor i = new Instruktor(0, name, surname, contact, user, pass);
                try{
                boolean b = Communication.getInstance().kreirajInstruktor(i);
                JOptionPane.showMessageDialog(rf, i.getKorisnickoIme()+" se registrovao/la!", "Registracija", JOptionPane.INFORMATION_MESSAGE);
                rf.dispose();
                Cordinator.getInstance().openLoginForm();
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rf, "Greška prilikom registrovanja. \n"+ex.getMessage(), "Registracija", JOptionPane.ERROR_MESSAGE);
                }
            }
        
        });
        
        rf.exitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rf.dispose();
                Cordinator.getInstance().openLoginForm();
            }
        });
    }

    public void openForm() {
        rf.setVisible(true);
    }
    
}
