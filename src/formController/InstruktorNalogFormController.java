/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import Language.LanguageSupport;
import communication.Communication;
import cordinator.Cordinator;
import exception.CustomException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
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
            inf.setTitle(LanguageSupport.getText("instructor_data"));
        } else{
            configureVisibility(false);
            inf.setTitle(LanguageSupport.getText("my_account"));
        }
        fillLabels();
        fillComboBox();
        fillTextFields();
        fillTable();
        fillZvanje();
        fillStatus();
        setLanguage();
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
            JOptionPane.showMessageDialog(inf, LanguageSupport.getText("error_loading_licences"),LanguageSupport.getText("loading_licences"),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void fillComboBox() {
        try {
            List<Licenca> list = Communication.getInstance().vratiListuSviLicenca();
            for(Licenca l : list){
                inf.getjComboBoxLicence().addItem(l);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, LanguageSupport.getText("error_loading_licences"),LanguageSupport.getText("loading_licences"),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void configureVisibility(boolean b) {
        inf.getjTextFieldName().setEnabled(b);
        inf.getjTextFieldSurname().setEnabled(b);
        inf.getjTextFieldContact().setEnabled(b);
        inf.getjTextFieldUsername().setEnabled(b);
        inf.getjButtonSave().setVisible(b);
        inf.getjLabelPassword().setVisible(b);
        inf.getjLabelRepeatPassword().setVisible(b);
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
        inf.getjLabelNameValidation().setText(LanguageSupport.getText("name_validation_empty")); 
        inf.getjLabelSurnameValidation().setText(LanguageSupport.getText("surname_validation_empty")); 
        inf.getjLabelContactValidation().setText(LanguageSupport.getText("contact_validation_empty")); 
        inf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_empty")); 
        inf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_empty"));
        inf.getjLabelRepeatPasswordValidation().setText(LanguageSupport.getText("repeat_password_validation_empty")); 
        inf.getjLabelNameValidation().setVisible(false);
        inf.getjLabelSurnameValidation().setVisible(false);
        inf.getjLabelContactValidation().setVisible(false);
        inf.getjLabelUsernameValidation().setVisible(false);
        inf.getjLabelPasswordValidation().setVisible(false);
        inf.getjLabelRepeatPasswordValidation().setVisible(false);
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
                        JOptionPane.showMessageDialog(inf, LanguageSupport.getText("adding_licence_valid"),LanguageSupport.getText("adding_licences"),JOptionPane.INFORMATION_MESSAGE);
                        fillTable();
                    }
                }catch (CustomException ex) {
                    JOptionPane.showMessageDialog(inf,LanguageSupport.getText(ex.getErrorCode()),LanguageSupport.getText("adding_licences"),JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(inf,LanguageSupport.getText("error.unknown"),LanguageSupport.getText("adding_licences"),JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            private boolean validation() {
                boolean valid = true;
                inf.getjLabelDate().setText("");
                Date utilDate = inf.getjDateChooser1().getDate();                       
                if(utilDate==null){
                    inf.getjLabelDate().setText(LanguageSupport.getText("choose_date"));
                    return false;
                }
                LocalDate date = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if(date.isAfter(LocalDate.now())){
                    inf.getjLabelDate().setText(LanguageSupport.getText("choose_date_invalid"));
                    valid = false;
                }
                return valid;
            }
        });
        
        inf.deleteLicenceActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = inf.getjTableInstruktorLicence().getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(
                        inf,
                        LanguageSupport.getText("select_licence_validation"),
                        LanguageSupport.getText("select_licence_validation_title"),
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }

                int i = JOptionPane.showConfirmDialog(
                    inf,
                    LanguageSupport.getText("delete_licence_confirm"),
                    LanguageSupport.getText("delete_licence_confirm_title"),
                    JOptionPane.YES_NO_OPTION
                );

                if (i == JOptionPane.YES_OPTION) {
                    InstructorLicenceTableModel iltm = (InstructorLicenceTableModel) inf.getjTableInstruktorLicence().getModel();
                    InstruktorLicenca il = iltm.getList().get(row);

                    try {
                        boolean b = Communication.getInstance().obrisiInstruktorLicenca(il);
                        if (b) {
                            JOptionPane.showMessageDialog(
                                inf,
                                LanguageSupport.getText("delete_licence_success"),
                                LanguageSupport.getText("delete_licence_success_title"),
                                JOptionPane.INFORMATION_MESSAGE
                            );
                            fillTable();
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(
                            inf,
                            LanguageSupport.getText("error.licenca.delete"),
                            LanguageSupport.getText("delete_licence_error_title"),
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        });

        inf.deleteAccountActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int odgovor = JOptionPane.showConfirmDialog(
                    inf,
                    LanguageSupport.getText("delete_account_confirm"),
                    LanguageSupport.getText("delete_account_confirm_title"),
                    JOptionPane.YES_NO_OPTION
                );
                try {
                    if (odgovor == JOptionPane.YES_OPTION) {
                        if (Communication.getInstance().obrisiInstruktor(inf.getLogged())) {
                            JOptionPane.showMessageDialog(
                                inf,
                                LanguageSupport.getText("delete_account_success")
                            );
                            inf.dispose();
                            inf.getParent().dispose();
                            Cordinator.getInstance().openLoginForm();
                        }
                    }
                } catch (CustomException ex) {
                    JOptionPane.showMessageDialog(
                        inf,
                        LanguageSupport.getText(ex.getErrorCode()),
                        LanguageSupport.getText("delete_account_error_title"),
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        inf,
                        LanguageSupport.getText("unknown_error"),
                        LanguageSupport.getText("delete_account_error_title"),
                        JOptionPane.ERROR_MESSAGE
                    );
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

                    if (!validation())
                        return;int odgovor = JOptionPane.showConfirmDialog(
                        inf,
                        LanguageSupport.getText("confirm_data_update"),
                        LanguageSupport.getText("update_data_title"),
                        JOptionPane.YES_NO_OPTION
                    );

                    if (odgovor == JOptionPane.YES_OPTION) {
                        if (name.equals(inf.getLogged().getIme()) &&
                            pass.equals(inf.getLogged().getSifra()) &&
                            surname.equals(inf.getLogged().getPrezime()) &&
                            contact.equals(inf.getLogged().getKontakt()) &&
                            user.equals(inf.getLogged().getKorisnickoIme())) {
                            JOptionPane.showMessageDialog(inf,LanguageSupport.getText("instructor_no_changes"),LanguageSupport.getText("update_data_title"),JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        inf.getLogged().setIdInstruktor(inf.getLogged().getIdInstruktor());
                        inf.getLogged().setIme(name);
                        inf.getLogged().setPrezime(surname);
                        inf.getLogged().setKontakt(contact);
                        inf.getLogged().setKorisnickoIme(user);
                        inf.getLogged().setSifra(pass);

                        boolean b = Communication.getInstance().promeniInstruktor(inf.getLogged());

                        JOptionPane.showMessageDialog(
                            inf,
                            LanguageSupport.getText("update_successful"),
                            LanguageSupport.getText("update_data_title"),
                        JOptionPane.INFORMATION_MESSAGE
                        );
                        prepareFields();
                    }

                } catch (CustomException ex) {
                    JOptionPane.showMessageDialog(
                        inf,
                        LanguageSupport.getText(ex.getErrorCode()),
                        LanguageSupport.getText("update_data_title"),
                        JOptionPane.ERROR_MESSAGE
                    );
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                        inf,
                        LanguageSupport.getText("unknown_error"),
                        LanguageSupport.getText("update_data_title"),
                        JOptionPane.ERROR_MESSAGE
                    );
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
                    inf.getjLabelNameValidation().setVisible(true);
                    valid=false;
                }   
                if (surname.isBlank()) {
                    inf.getjLabelSurnameValidation().setVisible(true);
                    valid=false;
                }
                if (contact.isBlank()) {
                    inf.getjLabelContactValidation().setVisible(true);
                    valid=false;
                }else if (!contact.matches("\\+?[0-9]{9,15}")) {
                    inf.getjLabelContactValidation().setText(LanguageSupport.getText("contact_validation"));
                    inf.getjLabelContactValidation().setVisible(true);
                    valid = false;
                }
                if (user.isBlank()) {
                    inf.getjLabelUsernameValidation().setVisible(true);
                    valid=false;
                }else if (user.length() < 5) {
                    inf.getjLabelUsernameValidation().setText(LanguageSupport.getText("username_validation_short"));
                    inf.getjLabelUsernameValidation().setVisible(true);
                    valid = false;
                }
                if (pass.isBlank()) {
                    inf.getjLabelPasswordValidation().setVisible(true);
                    valid=false;
                }else if (pass.length() < 8) {
                inf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_short"));
                inf.getjLabelPasswordValidation().setVisible(true);
                valid = false;
                } else if (!pass.matches(".*\\d.*")) { 
                    inf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_number"));
                    inf.getjLabelPasswordValidation().setVisible(true);
                    valid = false;
                }
                 if (repeatPass.isBlank()) {
                    inf.getjLabelRepeatPasswordValidation().setVisible(true);
                    valid=false;
                }else if (!pass.equals(repeatPass)) {
                    inf.getjLabelRepeatPasswordValidation().setText(LanguageSupport.getText("password_validation_repeat"));
                    inf.getjLabelPasswordValidation().setText(LanguageSupport.getText("password_validation_repeat"));
                    inf.getjLabelRepeatPasswordValidation().setVisible(true);
                    inf.getjLabelPasswordValidation().setVisible(true);
                    valid = false;
                }
                 return valid;
            }

            private void prepareFields() {
                 configureVisibility(false);
                 inf.getjButtonEdit().setVisible(true);
                 inf.getjPasswordFieldPass().setText("");
                 inf.getjPasswordFieldRepeatPass().setText("");
                 inf.getjButtonDelete().setVisible(true);
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
                inf.getjLabelZvanje().setText(LanguageSupport.getText("no_title_instructor"));
                return;
            }
            inf.getjLabelZvanje().setForeground(new Color(0,204,0));
            inf.getjLabelZvanje().setText(LanguageSupport.getText("ski_instructor")+" - "+maxStepen+". "+LanguageSupport.getText("level"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf,
                    LanguageSupport.getText("error_loading_licence")+" "+ex.getMessage(),
                    LanguageSupport.getText("loading_licence"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private int vratiStepen(Licenca licenca) {
        if(licenca.getZvanjeInstruktora().contains("IV"))
            return 4;
        if(licenca.getZvanjeInstruktora().contains("III"))
            return 3;
        if(licenca.getZvanjeInstruktora().contains("II"))
            return 2;
        if(licenca.getZvanjeInstruktora().contains("I"))
            return 1;
        return 0;
    }

    private void fillStatus() {
        try {
            List<InstruktorLicenca> list = Communication.getInstance().vratiListuInstruktorLicenca(inf.getLogged());
            int god = LocalDate.now().getYear();
            for(InstruktorLicenca il : list){
                if(god==il.getGodinaSticanja()){
                    inf.getjLabelStatus().setText(LanguageSupport.getText("licensed"));
                    inf.getjLabelStatus().setForeground(new Color(0,204,0));
                    return;
                }
            }
            inf.getjLabelStatus().setForeground(Color.RED);
            inf.getjLabelStatus().setText(LanguageSupport.getText("not_licensed"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, 
                    LanguageSupport.getText("error_loading_licence")+" "+ex.getMessage(),
                    LanguageSupport.getText("loading_licence"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setLanguage() {
        inf.getjLabelName().setText(LanguageSupport.getText("name"));
        inf.getjLabelSurname().setText(LanguageSupport.getText("surname"));
        inf.getjLabelUsername().setText(LanguageSupport.getText("username"));
        inf.getjLabelContact().setText(LanguageSupport.getText("contact"));
        inf.getjLabelPassword().setText(LanguageSupport.getText("password"));
        inf.getjLabelRepeatPassword().setText(LanguageSupport.getText("repeat_password"));
        inf.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        inf.getjButtonEdit().setText(LanguageSupport.getText("change_btn"));
        inf.getjButtonDelete().setText(LanguageSupport.getText("delete_account_btn"));
        inf.getjButtonDeleteLicence().setText(LanguageSupport.getText("delete_btn"));
        inf.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        inf.getjButtonSave().setText(LanguageSupport.getText("save_btn"));
        
        inf.getjLabelLicenceName().setText(LanguageSupport.getText("licence_name"));
        inf.getjLabelLicenceDate().setText(LanguageSupport.getText("licence_date"));
        inf.getjLabelLicenceStatus().setText(LanguageSupport.getText("licence_status"));
        inf.getjLabelLicenceZvanje().setText(LanguageSupport.getText("licence_title"));
        inf.getjLabelLicence().setText(LanguageSupport.getText("licence"));
    }
}