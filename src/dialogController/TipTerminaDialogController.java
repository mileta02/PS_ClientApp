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
import model.TipTermina;
import uidialog.TipTerminaDialog;

/**
 *
 * @author milan
 */
public class TipTerminaDialogController {
    private TipTerminaDialog ttd;

    public TipTerminaDialogController(TipTerminaDialog ttd) {
        this.ttd = ttd;
        addActionListener();
    }
    
    public void openForm(){
        ttd.setLocationRelativeTo(null);
        fillFields();
        setLanguage();
        ttd.setVisible(true);
    }

    private void addActionListener() {
        ttd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation())
                    return;
                String name = ttd.getjTextFieldName().getText();
                String priceString = ttd.getjTextFieldPrice().getText();
                double price = Double.parseDouble(priceString);
                TipTermina tt = new TipTermina();
                tt.setCenaSata(price);
                tt.setNazivTipa(name);

                try {
                    boolean b = Communication.getInstance().kreirajTipTermina(tt);
                    if(b){
                        JOptionPane.showMessageDialog(ttd, LanguageSupport.getText("create_type_success"),LanguageSupport.getText("create_type_title"),JOptionPane.INFORMATION_MESSAGE);
                        ttd.dispose();
                        ttd.getController().fillTable(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, ex.getMessage(),LanguageSupport.getText("create_type_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ttd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttd.getjButtonChange().setVisible(false);
                ttd.getjButtonDelete().setVisible(false);
                ttd.getjButtonSaveChanges().setEnabled(true);
                ttd.getjTextFieldName().setEnabled(true);
                ttd.getjTextFieldPrice().setEnabled(true);
            }
        });
        
        ttd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation() || !isEdited())
                    return;

                try{
                    int i =JOptionPane.showConfirmDialog(ttd, LanguageSupport.getText("update_type_confirm"),LanguageSupport.getText("update_type_title"),JOptionPane.YES_NO_OPTION);
        
                    if(i == JOptionPane.YES_OPTION){
                        String name = ttd.getjTextFieldName().getText();
                        double price = Double.parseDouble(ttd.getjTextFieldPrice().getText());
                        ttd.getTt().setNazivTipa(name);
                        ttd.getTt().setCenaSata(price);
                        boolean b = Communication.getInstance().promeniTipTermina(ttd.getTt());
                        if(b){
                            JOptionPane.showMessageDialog(ttd, LanguageSupport.getText("update_type_success"),LanguageSupport.getText("update_type_title"),JOptionPane.INFORMATION_MESSAGE);
                            ttd.getController().fillTable(null);
                            ttd.dispose();
                        }
                    }else
                        return;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, ex.getMessage(),LanguageSupport.getText("update_type_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ttd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(ttd, LanguageSupport.getText("delete_type_confirm"),LanguageSupport.getText("delete_type_title"),JOptionPane.YES_NO_OPTION);
        
                if(i == JOptionPane.YES_OPTION){
                try {
                    boolean b = Communication.getInstance().obrisiTipTermina(ttd.getTt());
                    if(b){
                        JOptionPane.showMessageDialog(ttd, LanguageSupport.getText("delete_type_success"),LanguageSupport.getText("delete_type_title"),JOptionPane.INFORMATION_MESSAGE);
                        ttd.getController().fillTable(null);
                        ttd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ttd, ex.getMessage(),LanguageSupport.getText("delete_type_title"),JOptionPane.ERROR_MESSAGE);
                }
                }
            }
        });
        
        ttd.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ttd.dispose();
            }
        });
    }
    
    private void fillFields() {
        if(ttd.getTt()==null){
            ttd.getjButtonDelete().setVisible(false);
            ttd.getjButtonChange().setVisible(false);
            ttd.getjButtonSaveChanges().setVisible(false);
        }else{
            ttd.getjButtonAdd().setVisible(false);
            ttd.getjButtonSaveChanges().setEnabled(false);
            ttd.getjTextFieldName().setText(ttd.getTt().getNazivTipa());
            ttd.getjTextFieldPrice().setText(Double.toString(ttd.getTt().getCenaSata()));
            ttd.getjTextFieldName().setEnabled(false);
            ttd.getjTextFieldPrice().setEnabled(false);
        }
    }
    
    private boolean validation(){
        String name = ttd.getjTextFieldName().getText();
        String priceString = ttd.getjTextFieldPrice().getText();
        ttd.getjLabelPriceValidation().setText("");
        ttd.getjLabelNameValidation().setText("");
        double price = 0;
        
        boolean valid = true;
        if(name.isEmpty()){
            valid=false;
            ttd.getjLabelNameValidation().setText(LanguageSupport.getText("licence_name_validation_empty"));
        }else if(!name.matches("^[a-zA-Z ]+$")){
            ttd.getjLabelNameValidation().setText(LanguageSupport.getText("licence_name_validation_invalid"));
            valid=false;
        }
        if(priceString.isEmpty()){
            valid=false;
            ttd.getjLabelPriceValidation().setText(LanguageSupport.getText("type_price_validation_empty"));
        }else {
            try {
                price = Double.parseDouble(priceString);
                if (price < 0) {
                    valid = false;
                    ttd.getjLabelPriceValidation().setText(LanguageSupport.getText("type_price_validation_invalid"));
                } else {
                    ttd.getjLabelPriceValidation().setText("");
                }
            } catch (NumberFormatException e) {
                valid = false;
                ttd.getjLabelPriceValidation().setText(LanguageSupport.getText("type_price_validation_invalid"));
            }
        }
        return valid;
    }

    private boolean isEdited() {
        if(ttd.getTt().getNazivTipa().equals(ttd.getjTextFieldName().getText()) && ttd.getTt().getCenaSata()==Double.parseDouble(ttd.getjTextFieldPrice().getText())){
            ttd.getjLabelNameValidation().setText(LanguageSupport.getText("no_changes"));
            ttd.getjLabelPriceValidation().setText(LanguageSupport.getText("no_changes"));
            return false;
        }
        return true;
    }

    private void setLanguage() {
        ttd.getjLabel1().setText(LanguageSupport.getText("type_name"));
        ttd.getjLabel2().setText(LanguageSupport.getText("type_price"));
        ttd.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        ttd.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        ttd.getjButtonDelete().setText(LanguageSupport.getText("delete_btn"));
        ttd.getjButtonChange().setText(LanguageSupport.getText("change_btn"));
        ttd.getjButtonSaveChanges().setText(LanguageSupport.getText("save_changes_btn"));
        ttd.setTitle(LanguageSupport.getText("type_dialog_title"));
    }
}
