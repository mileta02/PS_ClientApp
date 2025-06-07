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
import model.NivoSkijanja;
import uidialog.NivoSkijanjaDialog;

/**
 *
 * @author milan
 */
public class NivoSkijanjaDialogController {
    private NivoSkijanjaDialog nsd;

    public NivoSkijanjaDialogController(NivoSkijanjaDialog nsd) {
        this.nsd = nsd;
        addActionListener();
    }
    
    public void openForm(){
        fillFields();
        setLanguage();
        nsd.setLocationRelativeTo(null);
        nsd.setVisible(true);
    }

    private void addActionListener() {
        nsd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!validation())
                        return;
                    NivoSkijanja ns = new NivoSkijanja();
                    ns.setNazivNivoa(nsd.getjTextFieldName().getText());
                    boolean b = Communication.getInstance().kreirajNivoSkijanja(ns);
                    if(b){
                        JOptionPane.showMessageDialog(nsd, LanguageSupport.getText("create_ski_level_success"),LanguageSupport.getText("create_ski_level_title"),JOptionPane.INFORMATION_MESSAGE);
                        nsd.getController().fillTable(null);
                        nsd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),LanguageSupport.getText("create_ski_level_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        nsd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nsd.getjButtonSave().setVisible(true);
                nsd.getjButtonChange().setVisible(false);
                nsd.getjButtonDelete().setVisible(false);
                nsd.getjTextFieldName().setEnabled(true);
            }
        });
        
        nsd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {        
                    if(!validation() || !isEdited())
                        return;
                   
                    int i =JOptionPane.showConfirmDialog(nsd, LanguageSupport.getText("update_ski_level_confirm"),LanguageSupport.getText("update_ski_level_title"),JOptionPane.YES_NO_OPTION);
                    if(i == JOptionPane.YES_OPTION){
                        nsd.getNs().setNazivNivoa(nsd.getjTextFieldName().getText());
                        if(Communication.getInstance().promeniNivoSkijanja(nsd.getNs())){
                            JOptionPane.showMessageDialog(nsd, LanguageSupport.getText("update_ski_level_success"),LanguageSupport.getText("update_ski_level_title"),JOptionPane.INFORMATION_MESSAGE);
                            nsd.getController().fillTable(null);
                            nsd.dispose();
                        }
                    }
                    else
                        return;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),LanguageSupport.getText("update_ski_level_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        nsd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(nsd, LanguageSupport.getText("delete_ski_level_confirm"),LanguageSupport.getText("delete_ski_level_title"),JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    try {
                        boolean b = Communication.getInstance().obrisiNivoSkijanja(nsd.getNs());
                        if(b){
                            JOptionPane.showMessageDialog(nsd, LanguageSupport.getText("delete_ski_level_success"),LanguageSupport.getText("delete_ski_level_title"),JOptionPane.INFORMATION_MESSAGE);
                            nsd.getController().fillTable(null);
                            nsd.dispose();
                        }
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),LanguageSupport.getText("delete_ski_level_title"),JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        nsd.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nsd.dispose();
            }
        });
    }
    
     private void fillFields() {
        if(nsd.getNs() == null){
            nsd.getjTextFieldName().setText("");
            nsd.getjButtonAdd().setVisible(true);
            nsd.getjButtonChange().setVisible(false);
            nsd.getjButtonSave().setVisible(false);
            nsd.getjButtonDelete().setVisible(false);
        }
        else{
            nsd.getjTextFieldName().setText(nsd.getNs().getNazivNivoa());
            nsd.getjButtonAdd().setVisible(false);
            nsd.getjButtonSave().setVisible(false);
            nsd.getjTextFieldName().setEnabled(false);
            
        }
    }

    private boolean validation() {
            nsd.getjLabelValidation().setText("");
            String name = nsd.getjTextFieldName().getText();
            boolean valid = true;
            if(name.isEmpty()){
                valid=false;
                nsd.getjLabelValidation().setText(LanguageSupport.getText("licence_name_validation_empty"));
            }else if(!name.matches("^[a-zA-Z ]+$")){
                nsd.getjLabelValidation().setText(LanguageSupport.getText("licence_name_validation_invalid"));
                valid=false;
            }   
            return valid;
    }

    private boolean isEdited() {
        if(nsd.getNs().getNazivNivoa().equals(nsd.getjTextFieldName().getText())){
            nsd.getjLabelValidation().setText(LanguageSupport.getText("no_changes"));
            return false;
        }
        return true;
    }

    private void setLanguage() {
        nsd.getjLabel1().setText(LanguageSupport.getText("ski_level_name"));
        nsd.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        nsd.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        nsd.getjButtonDelete().setText(LanguageSupport.getText("delete_btn"));
        nsd.getjButtonChange().setText(LanguageSupport.getText("change_btn"));
        nsd.getjButtonSave().setText(LanguageSupport.getText("save_changes_btn"));
        nsd.setTitle(LanguageSupport.getText("ski_level_dialog_title"));
    }
}
