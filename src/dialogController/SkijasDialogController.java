/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import Language.LanguageSupport;
import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.NivoSkijanja;
import model.Skijas;
import uidialog.SkijasDialog;

/**
 *
 * @author milan
 */
public class SkijasDialogController {
    private SkijasDialog sd;

    public SkijasDialogController(SkijasDialog sd) {
        this.sd = sd;
        addActionListener();
    }
    public void openForm(){
        sd.setLocationRelativeTo(null);
        setLanguage();
        fillComboBox();
        fillFields();
        sd.setVisible(true);
        
    }

    private void addActionListener() {
        sd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
            
                    String name = sd.getjTextFieldName().getText();
                    String surname = sd.getjTextFieldSurname().getText();
                    String num = sd.getjTextFieldPhoneNum().getText();
                    NivoSkijanja ns = (NivoSkijanja) sd.getjComboBoxNivo().getSelectedItem();
                    Skijas s = new Skijas(0, name, surname, num, ns);
                    
                    if(!validation(s)){
                        return;
                    }
                    boolean b = Communication.getInstance().kreirajSkijas(s);
                    if(b){
                        JOptionPane.showMessageDialog(sd, LanguageSupport.getText("create_skier_success"),LanguageSupport.getText("create_skier_title"),JOptionPane.INFORMATION_MESSAGE);
                        sd.dispose();
                        sd.getController().fillTable(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sd, ex.getMessage(),LanguageSupport.getText("create_skier_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.getjButtonChange().setVisible(false);
                sd.getjButtonSave().setVisible(true);
                sd.getjButtonDelete().setVisible(false);
                sd.getjTextFieldName().setEnabled(true);
                sd.getjTextFieldPhoneNum().setEnabled(true);
                sd.getjTextFieldSurname().setEnabled(true);
                sd.getjComboBoxNivo().setEnabled(true);
            }
        });
        
        sd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = sd.getjTextFieldName().getText();
                    String surname = sd.getjTextFieldSurname().getText();
                    String num = sd.getjTextFieldPhoneNum().getText();
                    NivoSkijanja ns = (NivoSkijanja) sd.getjComboBoxNivo().getSelectedItem();
                    Skijas sk = new Skijas(sd.getS().getIdSkijas(), name, surname, num, ns);

                    if(!validation(sk)){
                        return;
                    }


                    if(name.equals(sd.getS().getIme()) && surname.equals(sd.getS().getPrezime()) && num.equals(sd.getS().getBrojTelefona()) && ns.getIdNivoSkijanja()==sd.getS().getNivoSkijanja().getIdNivoSkijanja()){
                        JOptionPane.showMessageDialog(sd, LanguageSupport.getText("skier_no_changes"),LanguageSupport.getText("update_skier_title"),JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    int i =JOptionPane.showConfirmDialog(sd, LanguageSupport.getText("update_skier_confirm"),LanguageSupport.getText("update_skier_title"),JOptionPane.YES_NO_OPTION);
                    if(i == JOptionPane.YES_OPTION){
                        boolean b = Communication.getInstance().promeniSkijas(sk);
                        if(b){
                            JOptionPane.showMessageDialog(sd, LanguageSupport.getText("update_skier_success"),LanguageSupport.getText("update_skier_title"),JOptionPane.INFORMATION_MESSAGE);
                            sd.getController().fillTable(null);
                            sd.dispose();
                            return;
                        }
                    }
                    else
                        return;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sd, ex.getMessage(),LanguageSupport.getText("update_skier_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(sd, LanguageSupport.getText("delete_skier_confirm"),LanguageSupport.getText("delete_skier_title"),JOptionPane.YES_NO_OPTION);
        
                if(i == JOptionPane.YES_OPTION){
                    try {

                        boolean b = Communication.getInstance().obrisiSkijas(sd.getS());
                        if(b){
                            JOptionPane.showMessageDialog(sd, LanguageSupport.getText("delete_skier_success"),LanguageSupport.getText("delete_skier_title"),JOptionPane.INFORMATION_MESSAGE);
                            sd.getController().fillTable(null);
                            sd.dispose();
                            }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(sd, ex.getMessage(),LanguageSupport.getText("delete_skier_title"),JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        sd.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.dispose();
            }
        });
    }
    private void fillComboBox() {
        List<NivoSkijanja> list;
        try {
            list = Communication.getInstance().vratiListuSviNivoSkijanja();
            for(NivoSkijanja ns : list){
                sd.getjComboBoxNivo().addItem(ns);
                if(sd.getS()==null)
                    sd.getjComboBoxNivo().setSelectedItem(null);
                else if(ns.getIdNivoSkijanja()==sd.getS().getNivoSkijanja().getIdNivoSkijanja())
                    sd.getjComboBoxNivo().setSelectedItem(ns);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(sd, LanguageSupport.getText("loading_skier")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_skier"),JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void fillFields() {
        if(sd.getS() == null){
            sd.getjButtonDelete().setVisible(false);
            sd.getjButtonChange().setVisible(false);
            sd.getjButtonSave().setVisible(false);
        }
        else{
            sd.getjTextFieldName().setText(sd.getS().getIme());
            sd.getjTextFieldPhoneNum().setText(sd.getS().getBrojTelefona());
            sd.getjTextFieldSurname().setText(sd.getS().getPrezime());
            sd.getjButtonAdd().setVisible(false);
            sd.getjButtonSave().setVisible(false);
            sd.getjComboBoxNivo().setSelectedItem(sd.getS().getNivoSkijanja());
            sd.getjTextFieldName().setEnabled(false);
            sd.getjTextFieldPhoneNum().setEnabled(false);
            sd.getjTextFieldSurname().setEnabled(false);
            sd.getjComboBoxNivo().setEnabled(false);
        }
    }
    
    private boolean validation(Skijas sk) {
        boolean validate = true;
        sd.getjLabelName().setText("");
        sd.getjLabelSurname().setText("");
        sd.getjLabelNum().setText("");
        sd.getjLabelNivo().setText("");

        if(sk.getIme().isEmpty()){
            validate=false;
            sd.getjLabelName().setText(LanguageSupport.getText("skier_name_validation_empty"));
        }else if(!sk.getIme().matches("^[a-zA-Z ]+$")){
            validate=false;
            sd.getjLabelName().setText(LanguageSupport.getText("skier_name_validation_invalid"));
        }
        if(sk.getPrezime().isEmpty()){
            validate=false;
            sd.getjLabelSurname().setText(LanguageSupport.getText("skier_surname_validation_empty"));
        }else if(!sk.getPrezime().matches("^[a-zA-Z ]+$")){
            validate=false;
            sd.getjLabelSurname().setText(LanguageSupport.getText("skier_surname_validation_invalid"));
        }
        if(sk.getBrojTelefona().isEmpty()){
            validate=false;
            sd.getjLabelNum().setText(LanguageSupport.getText("skier_phone_validation_empty"));
        }else if (!sk.getBrojTelefona().matches("\\+?[0-9]{9,15}")) {
            sd.getjLabelNum().setText(LanguageSupport.getText("skier_phone_validation_invalid"));
            validate = false;
        }
        if(sk.getNivoSkijanja()==null){
            validate=false;
            sd.getjLabelNivo().setText(LanguageSupport.getText("skier_level_validation_empty"));
        }
        return validate;
    }

    private void setLanguage() {
        sd.getjLabel1().setText(LanguageSupport.getText("name"));
        sd.getjLabel2().setText(LanguageSupport.getText("surname"));
        sd.getjLabel3().setText(LanguageSupport.getText("contact"));
        sd.getjLabel5().setText(LanguageSupport.getText("ski_level"));
        sd.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        sd.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        sd.getjButtonDelete().setText(LanguageSupport.getText("delete_btn"));
        sd.getjButtonChange().setText(LanguageSupport.getText("change_btn"));
        sd.getjButtonSave().setText(LanguageSupport.getText("save_btn"));
        sd.setTitle(LanguageSupport.getText("skier_dialog_title"));
    }
}
