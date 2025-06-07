/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import Language.LanguageSupport;
import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Licenca;
import uidialog.LicencaDialog;

/**
 *
 * @author milan
 */
public class LicencaDialogController {
    private LicencaDialog ld;

    public LicencaDialogController(LicencaDialog ld) {
        this.ld = ld;
        addActionListener();
    }
    
    public void openForm(){
        ld.setLocationRelativeTo(null);
        fillFields();
        setLanguage();
        ld.setVisible(true);
    }

    private void addActionListener() {
        ld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation())
                    return;
                String naziv = ld.getjTextFieldNaziv().getText();
                String zvanje = ld.getjTextFieldZvanje().getText();

                Licenca l = new Licenca();
                l.setNazivLicence(naziv);
                l.setZvanjeInstruktora(zvanje);

                try {
                    if(Communication.getInstance().kreirajLicenca(l)){
                        JOptionPane.showMessageDialog(ld, LanguageSupport.getText("create_licence_success"),LanguageSupport.getText("create_licence_title"),JOptionPane.INFORMATION_MESSAGE);
                        ld.getController().fillTable(null);
                        ld.dispose();
                    }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ld, ex.getMessage(),LanguageSupport.getText("create_licence_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ld.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ld.getjButtonChange().setVisible(false);
                ld.getjButtonDelete().setVisible(false);
                ld.getjButtonSaveChanges().setVisible(true);
                ld.getjTextFieldNaziv().setEnabled(true);
                ld.getjTextFieldZvanje().setEnabled(true);
            }
        });
        
        ld.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation() || !isEdited())
                    return;
                
                int i =JOptionPane.showConfirmDialog(ld, LanguageSupport.getText("update_licence_confirm"),LanguageSupport.getText("update_licence_title"),JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    try {
                        ld.getL().setNazivLicence(ld.getjTextFieldNaziv().getText());
                        ld.getL().setZvanjeInstruktora(ld.getjTextFieldZvanje().getText());
                        if(Communication.getInstance().promeniLicenca(ld.getL())){
                            JOptionPane.showMessageDialog(ld, LanguageSupport.getText("update_licence_success"),LanguageSupport.getText("update_licence_title"),JOptionPane.INFORMATION_MESSAGE);
                            ld.getController().fillTable(null);
                            ld.dispose();
                        }
                    } catch (Exception ex) {
                            JOptionPane.showMessageDialog(ld, ex.getMessage(),LanguageSupport.getText("update_licence_title"),JOptionPane.ERROR_MESSAGE);
                    }
                }else
                    return;
            }
        });
        
        ld.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(ld, LanguageSupport.getText("delete_licence_confirm"),LanguageSupport.getText("delete_licence_title"),JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    try{
                        boolean b = Communication.getInstance().obrisiLicenca(ld.getL());
                        if(b){
                            JOptionPane.showMessageDialog(ld, LanguageSupport.getText("delete_licence_success"),LanguageSupport.getText("delete_licence_title"),JOptionPane.INFORMATION_MESSAGE);
                            ld.getController().fillTable(null);
                            ld.dispose();
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(ld, ex.getMessage(),LanguageSupport.getText("delete_licence_title"),JOptionPane.ERROR_MESSAGE);
                    }
                    }else{
                        return;
                }
            }
        });
        
        ld.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ld.dispose();
            }
        });
    }
    
    private void fillFields() {
        if(ld.getL()==null){
            ld.getjButtonChange().setVisible(false);
            ld.getjButtonSaveChanges().setVisible(false);
            ld.getjButtonDelete().setVisible(false);
            return;
        }
        ld.getjTextFieldNaziv().setEnabled(false);
        ld.getjTextFieldZvanje().setEnabled(false);
        ld.getjTextFieldNaziv().setText(ld.getL().getNazivLicence());
        ld.getjTextFieldZvanje().setText(ld.getL().getZvanjeInstruktora());
    }
    
    private boolean validation(){
        String naziv = ld.getjTextFieldNaziv().getText();
        String zvanje = ld.getjTextFieldZvanje().getText();
        boolean valid = true;
        ld.getjLabelNaziv().setText("");
        ld.getjLabelZvanje().setText("");
        if(naziv.isEmpty()){
            ld.getjLabelNaziv().setText(LanguageSupport.getText("licence_name_validation_empty"));
            valid=false;
        } else if(!naziv.matches("^[a-zA-Z ]+$")){
            ld.getjLabelNaziv().setText(LanguageSupport.getText("licence_name_validation_invalid"));
            valid=false;
        }
        if(zvanje.isEmpty()){
            ld.getjLabelZvanje().setText(LanguageSupport.getText("licence_title_validation_empty"));
            valid=false;
        }else if(!zvanje.matches("^[a-zA-Z ]+$")){
            ld.getjLabelZvanje().setText(LanguageSupport.getText("licence_title_validation_invalid"));
            valid=false;
        }
        return valid;
    }
    
    private boolean isEdited(){
        String naziv = ld.getjTextFieldNaziv().getText();
        String zvanje = ld.getjTextFieldZvanje().getText();
        if(naziv.equals(ld.getL().getNazivLicence()) && zvanje.equals(ld.getL().getZvanjeInstruktora())){
            ld.getjLabelNaziv().setText(LanguageSupport.getText("no_changes"));
            ld.getjLabelZvanje().setText(LanguageSupport.getText("no_changes"));
            return false;
        }
        return true;
    }

    private void setLanguage() {
        ld.getjLabel1().setText(LanguageSupport.getText("licence_name"));
        ld.getjLabel2().setText(LanguageSupport.getText("licence_title"));
        ld.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        ld.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        ld.getjButtonDelete().setText(LanguageSupport.getText("delete_btn"));
        ld.getjButtonChange().setText(LanguageSupport.getText("change_btn"));
        ld.getjButtonSaveChanges().setText(LanguageSupport.getText("save_changes_btn"));
        ld.setTitle(LanguageSupport.getText("licence_dialog_title"));
    }
}
