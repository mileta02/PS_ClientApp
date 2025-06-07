/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import Language.LanguageSupport;
import communication.Communication;
import cordinator.Cordinator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Instruktor;
import model.Termin;
import model.TipTermina;
import table_model.TerminTableModel;
import uidialog.TerminDetaljiDialog;
import uidialog.TerminDialog;
import uiform.TerminForm;

/**
 *
 * @author milan
 */
public class TerminFormController {
    private TerminForm tf;

    public TerminFormController(TerminForm tf) {
        this.tf = tf;
        addActionListener();
    }
    
    public void openForm(){
        fillComboBoxes();
        fillTable(null);
        setLanguage();
        tf.setVisible(true);
    }

    private void addActionListener() {
        tf.searchActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    Termin ter = new Termin();
                    if(!validation(ter))
                        return;

                    List<Termin> list = Communication.getInstance().vratiListuTermin(ter);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(tf, LanguageSupport.getText("search_appointment_error"),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(tf, LanguageSupport.getText("search_appointment_success"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tf, LanguageSupport.getText("error_loading_appointment")+"\n"+ex.getMessage(),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(Termin ter) {
                boolean valid = true;
                String numText = tf.getjTextFieldNum().getText().trim();
                Instruktor i = (Instruktor) tf.getjComboInstruktor().getSelectedItem();
                TipTermina t = (TipTermina) tf.getjComboTipTermina().getSelectedItem();
                
                if(i==null && t==null && numText.isBlank() && !tf.getjCheckBoxFuture().isSelected()){
                    JOptionPane.showMessageDialog(tf, LanguageSupport.getText("search_validation"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
                LocalDate date = (tf.getjCheckBoxFuture().isSelected()) ? LocalDate.now() : null;;
                int num = 0;
                if(!numText.isBlank()){
                         try {
                            num = Integer.parseInt(numText);
                            if(num<=0)
                                throw new Exception("Broj manji od 0");
                        } catch (Exception ex) {
                            tf.getjTextFieldNum().setBorder(new LineBorder(Color.RED,2));
                            valid = false;
                        }
                    }

                if(!valid){
                    JOptionPane.showMessageDialog(tf, LanguageSupport.getText("search_error"),LanguageSupport.getText("search_title"),JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                ter.setDatum(date);
                ter.setInstruktor(i);
                ter.setMaxBrojSkijasa(num);
                ter.setTipTermina(t);
                return valid;
            }
        });
        
        tf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.getjComboInstruktor().setSelectedItem(null);
                tf.getjComboTipTermina().setSelectedItem(null);
                tf.getjTextFieldNum().setText("");
                tf.getjCheckBoxFuture().setSelected(false);
                defaultBorders();
                fillTable(null);
            }
        });
        
        tf.addActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openTerminDialog(tf);
            }
        });
        
        tf.detailsActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tf.getjTableTermin().getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(tf, LanguageSupport.getText("choose_appointment"), LanguageSupport.getText("wrong_choice"), JOptionPane.WARNING_MESSAGE);
                    return;
                }   

                TerminTableModel ttm = (TerminTableModel) tf.getjTableTermin().getModel();
                List<Termin> list = ttm.getList();
                Termin t = list.get(row);
                Cordinator.getInstance().openTerminDetaljiDialog(tf, t);
            }
        });
        
        tf.backActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.dispose();
            }
        });
    }
    
    public void fillTable(List<Termin> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviTermin();
            TerminTableModel ttm = new TerminTableModel(list);
            tf.getjTableTermin().setModel(ttm);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(tf, LanguageSupport.getText("error_loading_appointment")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_appointment"),JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillComboBoxes() {
        try {
            List<Instruktor> listIns = Communication.getInstance().vratiListuSviInstruktor();
            for(Instruktor i : listIns){
                tf.getjComboInstruktor().addItem(i);
            }
            tf.getjComboInstruktor().setSelectedItem(null);
            
            List<TipTermina> listTip = Communication.getInstance().vratiListuSviTipTermina();
            for(TipTermina t : listTip){
                tf.getjComboTipTermina().addItem(t);
            }
            tf.getjComboTipTermina().setSelectedItem(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tf, LanguageSupport.getText("error_loading_appointment")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_appointment"),JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void defaultBorders() {
        tf.getjTextFieldNum().setBorder(new LineBorder(Color.black,1));
    }

    private void setLanguage() {
        tf.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        tf.getjButtonFilter().setText(LanguageSupport.getText("search_btn"));
        tf.getjButtonClearFilter().setText(LanguageSupport.getText("clear_filter_btn"));
        tf.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        tf.getjButtonDetails().setText(LanguageSupport.getText("details_btn"));
        tf.getjLabel1().setText(LanguageSupport.getText("instructor"));
        tf.getjLabel2().setText(LanguageSupport.getText("type_of_appointment"));
        tf.getjLabel3().setText(LanguageSupport.getText("search_criteria"));
        tf.getjLabel4().setText(LanguageSupport.getText("skiers_num"));
        tf.getjCheckBoxFuture().setText(LanguageSupport.getText("future_appointments"));
        tf.setTitle(LanguageSupport.getText("appointments"));
    }
    
}
