/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

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
                    JOptionPane.showMessageDialog(lf, "Korisničko ime i šifra su ispravni", "Login", JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstance().setLogged(ins);
                    lf.dispose();
                    Cordinator.getInstance().openGlavnaForm();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, ex.getMessage(), "Login", JOptionPane.ERROR_MESSAGE);
                } 
            }

            private boolean validation(Instruktor i) {
                lf.getjLabelUsername().setText("");
                lf.getjLabePassword().setText("");
                boolean valid = true;

                if (i.getKorisnickoIme().isBlank()) {
                    lf.getjLabelUsername().setText("Unesite korisničko ime!");
                    valid = false;
                } else if (i.getKorisnickoIme().length() < 5) {
                    lf.getjLabelUsername().setText("Korisničko ime mora imati bar 5 karaktera!");
                    valid = false;
                }
                if (i.getSifra().isBlank()) {
                    lf.getjLabePassword().setText("Unesite šifru!");
                    valid = false;
                } else if (i.getSifra().length() < 8) {
                    lf.getjLabePassword().setText("Šifra mora imati bar 8 karaktera!");
                    valid = false;
                } else if (!i.getSifra().matches(".*\\d.*")) { 
                    lf.getjLabePassword().setText("Šifra mora sadržati bar jedan broj!");
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
    }

    public void openForm() {
        lf.setVisible(true);
    }
    
}
