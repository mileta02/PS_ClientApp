/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import Language.LanguageSupport;
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
                    JOptionPane.showMessageDialog(rf,LanguageSupport.getText("instructor") + " " + i.getKorisnickoIme() + " " + LanguageSupport.getText("register_valid"), 
                            LanguageSupport.getText("register_title"), JOptionPane.INFORMATION_MESSAGE);
                    rf.dispose();
                    Cordinator.getInstance().openLoginForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rf,LanguageSupport.getText("register_invalid"), LanguageSupport.getText("register_title"), JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(Instruktor i) {
                fillLabels();
                boolean valid = true;
                String repeatPass = String.valueOf(rf.getjPasswordFieldRepeatPass().getPassword());
                if (i.getIme().isBlank()) {
                    rf.getjLabelNameValidation().setVisible(true);
                    valid=false;
                }   
                if (i.getPrezime().isBlank()) {
                    rf.getjLabelSurnameValidation().setVisible(true);
                    valid=false;
                }
                if (i.getKontakt().isBlank()) {
                    rf.getjLabelContactValidation().setVisible(true);
                    valid=false;
                }else if (!i.getKontakt().matches("\\+?[0-9]{9,15}")) {
                    rf.getjLabelContactValidation().setText(LanguageSupport.getText("contact_validation"));
                    rf.getjLabelContactValidation().setVisible(true);
                    valid = false;
                }
                if (i.getKorisnickoIme().isBlank()) {
                    rf.getjLabelUsernameValidation().setVisible(true);
                    valid=false;
                }else if (i.getKorisnickoIme().length() < 5) {
                    rf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_short"));
                    rf.getjLabelUsernameValidation().setVisible(true);
                    valid = false;
                }
                if (i.getSifra().isBlank()) {
                    rf.getjLabelPasswordValidation().setVisible(true);
                    valid=false;
                }else if (i.getSifra().length() < 8) {
                    rf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_short"));
                    rf.getjLabelPasswordValidation().setVisible(true);
                    valid = false;
                } else if (!i.getSifra().matches(".*\\d.*")) { 
                    rf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_number"));
                    rf.getjLabelPasswordValidation().setVisible(true);
                    valid = false;
                }
                if (repeatPass.isBlank()) {
                    rf.getjLabelRepeatPasswordValidation().setVisible(true);
                    valid=false;
                }else if (!i.getSifra().equals(repeatPass)) {
                    rf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_repeat"));
                    rf.getjLabelRepeatPasswordValidation().setText(LanguageSupport.getText("password_validation_repeat"));
                    rf.getjLabelPasswordValidation().setVisible(true);
                    rf.getjLabelRepeatPasswordValidation().setVisible(true);
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
        rf.getjLabelNameValidation().setText(LanguageSupport.getText("name_validation_empty")); 
        rf.getjLabelSurnameValidation().setText(LanguageSupport.getText("surname_validation_empty")); 
        rf.getjLabelContactValidation().setText(LanguageSupport.getText("contact_validation_empty")); 
        rf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_empty")); 
        rf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_empty")); 
        rf.getjLabelRepeatPasswordValidation().setText(LanguageSupport.getText("repeat_password_validation_empty")); 
        rf.getjLabelContactValidation().setVisible(false);
        rf.getjLabelUsernameValidation().setVisible(false);
        rf.getjLabelNameValidation().setVisible(false);
        rf.getjLabelSurnameValidation().setVisible(false);
        rf.getjLabelPasswordValidation().setVisible(false);
        rf.getjLabelRepeatPasswordValidation().setVisible(false);
    }

    public void openForm() {
        rf.setVisible(true);
        setLanguage();
    }

    private void setLanguage() {
        rf.getjLabelName().setText(LanguageSupport.getText("name"));
        rf.getjLabelSurname().setText(LanguageSupport.getText("surname"));
        rf.getjLabelContact().setText(LanguageSupport.getText("contact"));
        rf.getjLabelUsername().setText(LanguageSupport.getText("username"));
        rf.getjLabelPassword().setText(LanguageSupport.getText("password"));
        rf.getjLabelRepeatPassword().setText(LanguageSupport.getText("repeat_password"));
        rf.getjButtonBack().setText(LanguageSupport.getText("back_to_login_btn"));
        rf.getjButtonRegister().setText(LanguageSupport.getText("register_btn"));
        rf.setTitle(LanguageSupport.getText("register_title"));
    }
    
}
