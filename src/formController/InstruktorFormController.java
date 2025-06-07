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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Instruktor;
import table_model.InstructorTableModel;
import uiform.GlavnaForm;
import uiform.InstruktorForm;

/**
 *
 * @author milan
 */
public class InstruktorFormController {
    private InstruktorForm inf;

    public InstruktorFormController(InstruktorForm inf) {
        this.inf = inf;
        addActionListener();
    }
    public void openForm(){
        fillTable(null);
        setLanguage();
        inf.setVisible(true);
    }

    private void addActionListener() {
        inf.searchActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    
                    String name = inf.getjTextFieldName().getText().trim();
                    String surname = inf.getjTextFieldSurname().getText().trim();
                    Instruktor i = new Instruktor();
                    i.setIme(name);
                    i.setPrezime(surname);
                    
                    if(!validation(i))
                        return;
                    
                    List<Instruktor> list = Communication.getInstance().vratiListuInstruktor(i);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(inf, LanguageSupport.getText("search_instructor_error"),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(inf, LanguageSupport.getText("search_instructor_success"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inf, LanguageSupport.getText("error_loading_instructor")+"\n"+ex.getMessage(),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean validation(Instruktor i) {
                if(i.getIme().isBlank() && i.getPrezime().isBlank()){
                        JOptionPane.showMessageDialog(inf, LanguageSupport.getText("search_validation"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                        return false;
                    }
                boolean valid = true;
                if(!i.getIme().isBlank() && !i.getIme().matches("^[a-zA-Z ]+$")){
                inf.getjTextFieldName().setBorder(new LineBorder(Color.red,2));
                valid = false;
                }
                if(!i.getPrezime().isBlank() && !i.getPrezime().matches("^[a-zA-Z ]+$")){
                    inf.getjTextFieldSurname().setBorder(new LineBorder(Color.red,2));
                    valid = false;
                }
                if(!valid){
                    JOptionPane.showMessageDialog(inf, LanguageSupport.getText("search_error"),LanguageSupport.getText("search_title"),JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                return valid;
            }
        });
        
        inf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inf.getjTextFieldName().setText("");
                inf.getjTextFieldSurname().setText("");
                defaultBorders();
                fillTable(null);
            }
        });
        
        inf.backActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inf.dispose();
            }
        });
        
        inf.detailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = inf.getjTableInstructor().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(inf, LanguageSupport.getText("choose_instructor"),LanguageSupport.getText("wrong_choice"),JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                InstructorTableModel itm = (InstructorTableModel) inf.getjTableInstructor().getModel();
                Instruktor i = itm.getList().get(row);
                Cordinator.getInstance().openInstruktorNalogForm(null, i);
            }
        }
        );
    }
    private void defaultBorders() {
                inf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                inf.getjTextFieldSurname().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
    private void fillTable(List<Instruktor> list) {
        try {
            if(list==null)
                 list = Communication.getInstance().vratiListuSviInstruktor();
            InstructorTableModel itm = new InstructorTableModel(list);
            inf.getjTableInstructor().setModel(new InstructorTableModel(list));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, LanguageSupport.getText("error_loading_instructor")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_instructor"),JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setLanguage() {
        inf.getjButtonFilter().setText(LanguageSupport.getText("search_btn"));
        inf.getjButtonClearFilter().setText(LanguageSupport.getText("clear_filter_btn"));
        inf.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        inf.getjButtonDetails().setText(LanguageSupport.getText("details_btn"));
        inf.getjLabelName().setText(LanguageSupport.getText("name"));
        inf.getjLabelSurname().setText(LanguageSupport.getText("surname"));
        inf.getjLabelSearchCriteria().setText(LanguageSupport.getText("search_criteria"));
        inf.setTitle(LanguageSupport.getText("instructors"));
    }
}
