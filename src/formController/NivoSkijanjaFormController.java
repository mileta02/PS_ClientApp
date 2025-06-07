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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.NivoSkijanja;
import table_model.NivoSkijanjaTableModel;
import uidialog.NivoSkijanjaDialog;
import uiform.NivoSkijanjaForm;

/**
 *
 * @author milan
 */
public class NivoSkijanjaFormController {
    private NivoSkijanjaForm nsf;

    public NivoSkijanjaFormController(NivoSkijanjaForm nsf) {
        this.nsf = nsf;
        addActionListener();
    }

    private void addActionListener() {
        nsf.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    
                    String name = nsf.getjTextFieldName().getText().trim();
                    NivoSkijanja ns = new NivoSkijanja();
                    ns.setNazivNivoa(name);
                    
                    if(!validation(ns))
                        return;
                    
                    List<NivoSkijanja> list = Communication.getInstance().vratiListuNivoSkijanja(ns);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("search_ski_level_error"),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("search_ski_level_success"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("error_loading_ski_level")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_ski_level"),JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        
        nsf.clearFilterActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nsf.getjTextFieldName().setText("");
                defaultBorders();
                fillTable(null);
            }
        });
        
        nsf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openNivoSkijanjaDialog(nsf, null);
            }
        });
        
        nsf.detailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int row = nsf.getjTableNivoSkijanja().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("choose_ski_level"),LanguageSupport.getText("wrong_choice"),JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                NivoSkijanjaTableModel nstm = (NivoSkijanjaTableModel) nsf.getjTableNivoSkijanja().getModel();
                NivoSkijanja ns = nstm.getList().get(row);
                Cordinator.getInstance().openNivoSkijanjaDialog(nsf, ns);
            }
        });
        
        nsf.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nsf.dispose();
            }
        });
    }
    public void openForm(){
        fillTable(null);
        setLanguage();
        nsf.setVisible(true);
    }
    
    public void fillTable(List<NivoSkijanja> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviNivoSkijanja();
            NivoSkijanjaTableModel nstm = new NivoSkijanjaTableModel(list);
            nsf.getjTableNivoSkijanja().setModel(nstm);
        } catch (Exception ex) {
            Logger.getLogger(NivoSkijanjaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void defaultBorders() {
        nsf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    private boolean validation(NivoSkijanja ns) {
        if(ns.getNazivNivoa().isBlank()){
            JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("search_validation"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if(!ns.getNazivNivoa().matches("^[a-zA-Z ]+$")){
            nsf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            JOptionPane.showMessageDialog(nsf, LanguageSupport.getText("search_error"),LanguageSupport.getText("search_title"),JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void setLanguage() {
        nsf.getjButtonAdd().setText(LanguageSupport.getText("add_btn"));
        nsf.getjButtonSearch().setText(LanguageSupport.getText("search_btn"));
        nsf.getjButtonClearFilter().setText(LanguageSupport.getText("clear_filter_btn"));
        nsf.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        nsf.getjButtonDetails().setText(LanguageSupport.getText("details_btn"));
        nsf.getjLabel1().setText(LanguageSupport.getText("search_criteria"));
        nsf.getjLabel2().setText(LanguageSupport.getText("ski_level_name"));
        nsf.setTitle(LanguageSupport.getText("ski_level"));
    }
    
}
