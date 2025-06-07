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
import javax.swing.Action;
import javax.swing.JOptionPane;
import model.Instruktor;
import uiform.GlavnaForm;
import uiform.LoginForm;

/**
 *
 * @author milan
 */
public class LoginController {
    private LoginForm lf;

    public LoginController(LoginForm lf) {
        this.lf=lf;
        addActionListener();
    }

    private void addActionListener() {
        lf.loginActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(e);
            }

            private void login(ActionEvent e) {

                String username = lf.getjTextFieldKorisnickoIme().getText().trim();
                String password = String.valueOf(lf.getjPasswordFieldSifra().getPassword()).trim();
                Instruktor i = new Instruktor(username,password);
                if(!validation(i))
                    return;
                try {
                    Instruktor ins = Communication.getInstance().login(i);
                    System.out.println("ins"+ins);
                    if(ins==null){
                        JOptionPane.showMessageDialog(lf, LanguageSupport.getText("login_invalid_credentials"), LanguageSupport.getText("login_title"), JOptionPane.ERROR_MESSAGE);
                        return;                    
                    }
                    JOptionPane.showMessageDialog(lf, LanguageSupport.getText("login_valid_credentials"), LanguageSupport.getText("login_title"), JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().setLogged(ins);
                    lf.dispose();
                    Cordinator.getInstance().openGlavnaForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, ex.getMessage(), LanguageSupport.getText("login_title"), JOptionPane.ERROR_MESSAGE);
                } 
            }

            private boolean validation(Instruktor i) {
                lf.getjLabelUsernameValidation().setText("");
                lf.getjLabelPasswordValidation().setText("");
                boolean valid = true;

                if (i.getKorisnickoIme().isBlank()) {
                    lf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_empty"));
                    valid = false;
                } else if (i.getKorisnickoIme().length() < 5) {
                    lf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_short"));
                    valid = false;
                }
                if (i.getSifra().isBlank()) {
                    lf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_empty"));
                    valid = false;
                } else if (i.getSifra().length() < 8) {
                    lf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_short"));
                    valid = false;
                } else if (!i.getSifra().matches(".*\\d.*")) { 
                    lf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_number"));
                    valid = false;
                }

                return valid;
            }
        });
        
        lf.registerActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lf.dispose();
                Cordinator.getInstance().openRegisterForm();
            }
        });
        
        lf.exitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lf.dispose();
            }
        });
        
        lf.languageActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lang = String.valueOf(lf.getjComboBoxLanguage().getSelectedItem());
                LanguageSupport.setLanguage(lang);
                setLanguage();
            }
        });
    }

    public void openForm() {
        setLanguage();
        lf.setVisible(true);
        
    }

    private void fillComboBox() {
        String currentLang = LanguageSupport.getCurrentLanguageCode();
        
        lf.getjComboBoxLanguage().removeAllItems();
        lf.getjComboBoxLanguage().addItem(LanguageSupport.getText("serbian_lang"));
        lf.getjComboBoxLanguage().addItem(LanguageSupport.getText("english_lang"));
        
        if(currentLang.equals("en"))
            lf.getjComboBoxLanguage().setSelectedItem(LanguageSupport.getText("english_lang"));
        else
            lf.getjComboBoxLanguage().setSelectedItem(LanguageSupport.getText("serbian_lang"));
    }

    private void setLanguage() {
        lf.getjLabelUsername().setText(LanguageSupport.getText("username"));
        lf.getjLabelPassword().setText(LanguageSupport.getText("password"));
        lf.getjLabelLanguage().setText(LanguageSupport.getText("select_language"));
        lf.getjLabelNoAccount().setText(LanguageSupport.getText("no_account"));
        lf.getjButtonExit().setText(LanguageSupport.getText("exit_btn"));
        lf.getjButtonLogin().setText(LanguageSupport.getText("login_btn"));
        lf.getjButtonRegister().setText(LanguageSupport.getText("register_btn"));
        lf.setTitle(LanguageSupport.getText("login_title"));
        
        fillComboBox();
    }
    
}
