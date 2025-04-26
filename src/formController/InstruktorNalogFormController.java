/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import communication.Communication;
import cordinator.Cordinator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Instruktor;
import model.InstruktorLicenca;
import model.Licenca;
import table_model.InstructorLicenceTableModel;
import uiform.InstruktorNalogForm;
import uiform.LoginForm;

/**
 *
 * @author milan
 */
public class InstruktorNalogFormController {
    private InstruktorNalogForm inf;

    public InstruktorNalogFormController(InstruktorNalogForm inf) {
        this.inf = inf;
        addActionListener();
    }
    public void openForm(){
        if(!inf.getLogged().equals(Cordinator.getInstance().getLogged())){
            configureVisibilityViewOnly();
        } else{
            configureVisibility(false);
        }
        fillLabels();
        fillComboBox();
        fillTextFields();
        fillTable();
        fillZvanje();
        fillStatus();
        inf.setVisible(true);
    }
    
    private void fillTextFields() {
        inf.getjTextFieldName().setText(inf.getLogged().getIme());
        inf.getjTextFieldSurname().setText(inf.getLogged().getPrezime());
        inf.getjTextFieldUsername().setText(inf.getLogged().getKorisnickoIme());
        inf.getjTextFieldContact().setText(inf.getLogged().getKontakt());
    }
    
    private void fillTable() {
        try {
            fillStatus();
            fillZvanje();
            List<InstruktorLicenca> list = Communication.getInstance().vratiListuInstruktorLicenca(inf.getLogged());
            InstructorLicenceTableModel iltm = new InstructorLicenceTableModel(list);
            inf.getjTableInstruktorLicence().setModel(iltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void fillComboBox() {
        try {
            List<Licenca> list = Communication.getInstance().vratiListuSviLicenca();
            for(Licenca l : list){
                inf.getjComboBoxLicence().addItem(l);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void configureVisibility(boolean b) {
        inf.getjTextFieldName().setEnabled(b);
        inf.getjTextFieldSurname().setEnabled(b);
        inf.getjTextFieldContact().setEnabled(b);
        inf.getjTextFieldUsername().setEnabled(b);
        inf.getjButtonSave().setVisible(b);
        inf.getjLabel5().setVisible(b);
        inf.getjLabel11().setVisible(b);
        inf.getjPasswordFieldPass().setVisible(b);
        inf.getjPasswordFieldRepeatPass().setVisible(b);
    }
    
    private void configureVisibilityViewOnly() {
        configureVisibility(false);
        inf.getjButtonEdit().setEnabled(false);
        inf.getjButtonDelete().setEnabled(false);
        inf.getjButtonDeleteLicence().setEnabled(false);
        inf.getjButtonAdd().setEnabled(false);
        inf.getjTableInstruktorLicence().setEnabled(false);
        inf.getjDateChooser1().setEnabled(false);
        inf.getjComboBoxLicence().setEnabled(false);
    }
    
    private void fillLabels() {
        inf.getjLabel6().setText("Unesite ime!"); 
        inf.getjLabel7().setText("Unesite prezime!"); 
        inf.getjLabel8().setText("Unesite kontakt telefon!"); 
        inf.getjLabel9().setText("Unesite korisničko ime!"); 
        inf.getjLabel10().setText("Unesite šifru!");
        inf.getjLabel12().setText("Ponovite šifru!"); 
        inf.getjLabel9().setVisible(false);
        inf.getjLabel10().setVisible(false);
        inf.getjLabel7().setVisible(false);
        inf.getjLabel8().setVisible(false);
        inf.getjLabel6().setVisible(false);
        inf.getjLabel12().setVisible(false);
    }
    private void addActionListener() {
        inf.addLicenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        if(!validation())
                            return;
                        
                        Date utilDate = inf.getjDateChooser1().getDate();
                        LocalDate date = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                       
                        InstruktorLicenca il = new InstruktorLicenca();
                        il.setGodinaSticanja(date.getYear());
                        il.setLicenca((Licenca) inf.getjComboBoxLicence().getSelectedItem());
                        il.setInstruktor(inf.getLogged());

                        boolean b = Communication.getInstance().kreirajInstruktorLicenca(il);
                        if(b){
                            JOptionPane.showMessageDialog(inf, "Sistem je dodao licencu za instruktora","Dodavanje licence",JOptionPane.INFORMATION_MESSAGE);
                            fillTable();
                        }
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(inf,ex.getMessage(),"Dodavanje licence",JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                }

            private boolean validation() {
                boolean valid = true;
                inf.getjLabelDate().setText("");
                Date utilDate = inf.getjDateChooser1().getDate();                       
                if(utilDate==null){
                    inf.getjLabelDate().setText("Izaberite datum");
                    return false;
                }
                LocalDate date = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if(date.isAfter(LocalDate.now())){
                    inf.getjLabelDate().setText("Datum se mora odnositi na prošlost");
                    valid = false;
                }
                return valid;
            }
            });
        
        inf.deleteLicenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = inf.getjTableInstruktorLicence().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(inf, "Izaberite licencu iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int i =JOptionPane.showConfirmDialog(inf, "Da li ste sigurni da želite da obrišete licencu?","Brisanje licence",JOptionPane.YES_NO_OPTION);

                if(i == JOptionPane.YES_OPTION){
                    InstructorLicenceTableModel iltm = (InstructorLicenceTableModel) inf.getjTableInstruktorLicence().getModel();
                    InstruktorLicenca il = iltm.getList().get(row);
                    boolean b;
                    try {
                        b = Communication.getInstance().obrisiInstruktorLicenca(il);
                        if(b){
                            JOptionPane.showMessageDialog(inf, "Sistem je obrisao licencu.","Uspešno brisanje",JOptionPane.INFORMATION_MESSAGE);
                            fillTable();
                        }
                        else
                            return;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(inf, ex.getMessage(),"Neuspešno brisanje",JOptionPane.ERROR_MESSAGE);
                    }

                }
                else
                    return;
            }
        });
        
        inf.deleteAccountActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int odgovor = JOptionPane.showConfirmDialog(inf, "Da li ste sigurni da želite da obrišete nalog?", "Potvrda brisanja",JOptionPane.YES_NO_OPTION);
                try{
                if (odgovor == JOptionPane.YES_OPTION) {
                    if(Communication.getInstance().obrisiInstruktor(inf.getLogged()))
                        JOptionPane.showMessageDialog(inf, "Sistem je obrisao instruktora.");
                        inf.dispose();
                        inf.getParent().dispose();
                        new LoginForm().setVisible(true);
                }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(inf, ex.getMessage(),"Brisanje instruktora",JOptionPane.ERROR_MESSAGE);
                }
                    }
        });
        
        inf.editAccoutActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configureVisibility(true);
                inf.getjButtonEdit().setVisible(false);
                inf.getjButtonDelete().setVisible(false);
            }
        });
        
        inf.saveChangesActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String pass = String.valueOf(inf.getjPasswordFieldPass().getPassword());
                    String repeatPass = String.valueOf(inf.getjPasswordFieldRepeatPass().getPassword());
                    String user = inf.getjTextFieldUsername().getText().trim();
                    String name = inf.getjTextFieldName().getText().trim();
                    String contact = inf.getjTextFieldContact().getText().trim();
                    String surname = inf.getjTextFieldSurname().getText().trim();

                    if(!validation())
                        return;

                    if(name.equals(inf.getLogged().getIme()) && pass.equals(inf.getLogged().getSifra()) && surname.equals(inf.getLogged().getPrezime()) && 
                            contact.equals(inf.getLogged().getKontakt()) && user.equals(inf.getLogged().getKorisnickoIme())){
                        JOptionPane.showMessageDialog(inf, "Niste izmenili podatke. \n","Izmena podataka",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    int odgovor = JOptionPane.showConfirmDialog(inf, "Da li ste sigurni da želite da izmenite podatke?", "Potvrda izmene podataka",JOptionPane.YES_NO_OPTION);

                    if(odgovor==JOptionPane.YES_OPTION){
                        inf.getLogged().setIdInstruktor(inf.getLogged().getIdInstruktor());
                        inf.getLogged().setIme(name);
                        inf.getLogged().setPrezime(surname);
                        inf.getLogged().setKontakt(contact);
                        inf.getLogged().setKorisnickoIme(user);
                        inf.getLogged().setSifra(pass);
                        boolean b = Communication.getInstance().promeniInstruktor(inf.getLogged());
                        JOptionPane.showMessageDialog(inf, "Uspesno ste izmenili podatke.");
                        inf.dispose();
                    }
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(inf, "Greska kod azuriranja podataka. \n"+ex.getMessage(),"Izmena podataka",JOptionPane.ERROR_MESSAGE);

                }
            }

            private boolean validation() {
                String pass = String.valueOf(inf.getjPasswordFieldPass().getPassword());
                String repeatPass = String.valueOf(inf.getjPasswordFieldRepeatPass().getPassword());
                String user = inf.getjTextFieldUsername().getText();
                String name = inf.getjTextFieldName().getText();
                String contact = inf.getjTextFieldContact().getText();
                String surname = inf.getjTextFieldSurname().getText();

                fillLabels();
                boolean valid = true;

                if (name.isBlank()) {
                    inf.getjLabel6().setVisible(true);
                    valid=false;
                }   
                if (surname.isBlank()) {
                    inf.getjLabel7().setVisible(true);
                    valid=false;
                }
                if (contact.isBlank()) {
                    inf.getjLabel8().setVisible(true);
                    valid=false;
                }else if (!contact.matches("\\+?[0-9]{9,15}")) {
                    inf.getjLabel8().setText("Kontakt mora imati 9-15 cifara!");
                    inf.getjLabel8().setVisible(true);
                    valid = false;
                }
                if (user.isBlank()) {
                    inf.getjLabel9().setVisible(true);
                    valid=false;
                }else if (user.length() < 5) {
                    inf.getjLabel9().setText("Korisničko ime mora imati bar 5 karaktera!");
                    inf.getjLabel9().setVisible(true);
                    valid = false;
                }
                if (pass.isBlank()) {
                    inf.getjLabel10().setVisible(true);
                    valid=false;
                }else if (pass.length() < 5) {
                inf.getjLabel10().setText("Šifra mora imati bar 8 karaktera!");
                inf.getjLabel10().setVisible(true);
                valid = false;
                } else if (!pass.matches(".*\\d.*")) { 
                    inf.getjLabel10().setText("Šifra mora sadržati bar jedan broj!");
                    inf.getjLabel10().setVisible(true);
                    valid = false;
                }
                 if (repeatPass.isBlank()) {
                    inf.getjLabel12().setVisible(true);
                    valid=false;
                }else if (!pass.equals(repeatPass)) {
                    inf.getjLabel10().setText("Šifre se ne poklapaju!");
                    inf.getjLabel12().setText("Šifre se ne poklapaju!");
                    inf.getjLabel10().setVisible(true);
                    inf.getjLabel12().setVisible(true);
                    valid = false;
                }
                 return valid;
            }
        });
        
        inf.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inf.dispose();
            }
        });
}

    private void fillZvanje() {
        try {
            List<InstruktorLicenca> list = Communication.getInstance().vratiListuInstruktorLicenca(inf.getLogged());
            int maxStepen = 0;
            for(InstruktorLicenca il : list){
                int stepen = vratiStepen(il.getLicenca());
                if(stepen>maxStepen)
                    maxStepen=stepen;
            }
            if(maxStepen==0){
                inf.getjLabelZvanje().setForeground(Color.RED);
                inf.getjLabelZvanje().setText("Instruktor nema zvanje.");
                return;
            }
            inf.getjLabelZvanje().setForeground(new Color(0,204,0));
            inf.getjLabelZvanje().setText("Instruktor skijanja "+maxStepen+". stepena.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
        }
    }

    private int vratiStepen(Licenca licenca) {
        if(licenca.getNazivLicence().contains("IV"))
            return 4;
        if(licenca.getNazivLicence().contains("III"))
            return 3;
        if(licenca.getNazivLicence().contains("II"))
            return 2;
        if(licenca.getNazivLicence().contains("I"))
            return 1;
        return 0;
    }

    private void fillStatus() {
        try {
            List<InstruktorLicenca> list = Communication.getInstance().vratiListuInstruktorLicenca(inf.getLogged());
            int god = LocalDate.now().getYear();
            for(InstruktorLicenca il : list){
                if(god==il.getGodinaSticanja()){
                    inf.getjLabelStatus().setText("Licenciran");
                    inf.getjLabelStatus().setForeground(new Color(0,204,0));
                    return;
                }
            }
            inf.getjLabelStatus().setForeground(Color.RED);
            inf.getjLabelStatus().setText("Nije licenciran");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, "Greška prilikom učitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
        }
    }
}