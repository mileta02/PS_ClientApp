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
                String pass = String.valueOf(rf.getjPasswordFieldPass().getPassword()).trim();
                String repeatPass = String.valueOf(rf.getjPasswordFieldRepeatPass().getPassword()).trim();
                String user = rf.getjTextFieldUser().getText().trim();
                String name = rf.getjTextFieldName().getText().trim();
                String contact = rf.getjTextFieldContact().getText().trim();
                String surname = rf.getjTextFieldSurname().getText().trim();
                Instruktor i = new Instruktor(0, name, surname, contact, user, pass);
                
                if(!validation(i))
                    return;
                
                try{
                    boolean b = Communication.getInstance().kreirajInstruktor(i);
                    JOptionPane.showMessageDialog(rf, i.getKorisnickoIme()+" se registrovao/la!", "Registracija", JOptionPane.INFORMATION_MESSAGE);
                    rf.dispose();
                    Cordinator.getInstance().openLoginForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rf,ex.getMessage(), "Registracija", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(Instruktor i) {
                fillLabels();
                boolean valid = true;
                String repeatPass = String.valueOf(rf.getjPasswordFieldRepeatPass().getPassword());
                if (i.getIme().isBlank()) {
                    rf.getjLabelName().setVisible(true);
                    valid=false;
                }   
                if (i.getPrezime().isBlank()) {
                    rf.getjLabelSurname().setVisible(true);
                    valid=false;
                }
                if (i.getKontakt().isBlank()) {
                    rf.getjLabelContact().setVisible(true);
                    valid=false;
                }else if (!i.getKontakt().matches("\\+?[0-9]{9,15}")) {
                    rf.getjLabelContact().setText("Kontakt mora imati 9-15 cifara!");
                    rf.getjLabelContact().setVisible(true);
                    valid = false;
                }
                if (i.getKorisnickoIme().isBlank()) {
                    rf.getjLabelUsername().setVisible(true);
                    valid=false;
                }else if (i.getKorisnickoIme().length() < 5) {
                    rf.getjLabelUsername().setText("Korisničko ime mora imati bar 5 karaktera!");
                    rf.getjLabelUsername().setVisible(true);
                    valid = false;
                }
                if (i.getSifra().isBlank()) {
                    rf.getjLabelPass().setVisible(true);
                    valid=false;
                }else if (i.getSifra().length() < 8) {
                    rf.getjLabelPass().setText("Šifra mora imati bar 8 karaktera!");
                    rf.getjLabelPass().setVisible(true);
                    valid = false;
                } else if (!i.getSifra().matches(".*\\d.*")) { 
                    rf.getjLabelPass().setText("Šifra mora sadržati bar jedan broj!");
                    rf.getjLabelPass().setVisible(true);
                    valid = false;
                }
                if (repeatPass.isBlank()) {
                    rf.getjLabelRepeatPass().setVisible(true);
                    valid=false;
                }else if (!i.getSifra().equals(repeatPass)) {
                    rf.getjLabelPass().setText("Šifre se ne poklapaju!");
                    rf.getjLabelRepeatPass().setText("Šifre se ne poklapaju!");
                    rf.getjLabelPass().setVisible(true);
                    rf.getjLabelRepeatPass().setVisible(true);
                    valid = false;
                }   

                return valid;
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
    private void fillLabels() {
        rf.getjLabelName().setText("Unesite ime!"); 
        rf.getjLabelSurname().setText("Unesite prezime!"); 
        rf.getjLabelContact().setText("Unesite kontakt telefon!"); 
        rf.getjLabelUsername().setText("Unesite korisničko ime!"); 
        rf.getjLabelPass().setText("Unesite šifru!"); 
        rf.getjLabelRepeatPass().setText("Ponovite šifru!"); 
        rf.getjLabelContact().setVisible(false);
        rf.getjLabelUsername().setVisible(false);
        rf.getjLabelName().setVisible(false);
        rf.getjLabelSurname().setVisible(false);
        rf.getjLabelPass().setVisible(false);
        rf.getjLabelRepeatPass().setVisible(false);
    }

    public void openForm() {
        rf.setVisible(true);
    }
    
}
