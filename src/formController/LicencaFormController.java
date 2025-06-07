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
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.Licenca;
import table_model.LicenceTableModel;
import uidialog.LicencaDialog;
import uiform.LicencaForm;
/**
 *
 * @author milan
 */
public class LicencaFormController {
    private LicencaForm lf;

    public LicencaFormController(LicencaForm lf) {
        this.lf = lf;
        addActionListener();
    }

    private void addActionListener() {
        lf.searchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    defaultBorders();
                    
                    String name = lf.getjTextFieldName().getText().trim();
                    String zvanje = lf.getjTextFieldZvanje().getText().trim();
                    Licenca l = new Licenca();
                    l.setNazivLicence(name);
                    l.setZvanjeInstruktora(zvanje);
                    
                    if(!validation(l))
                        return;
                    
                    List<Licenca> list = Communication.getInstance().vratiListuLicenca(l);
                    if(list.isEmpty()){
                        JOptionPane.showMessageDialog(lf, LanguageSupport.getText("search_licence_error"),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(lf, LanguageSupport.getText("search_licence_success"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
                    fillTable(list);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, ex.getMessage(),LanguageSupport.getText("search_title"),JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        lf.clearFilterActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lf.getjTextFieldName().setText("");
                lf.getjTextFieldZvanje().setText("");
                defaultBorders();
                fillTable(null);
            }
        });
        
        lf.detailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = lf.getjTableLicence().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(lf, LanguageSupport.getText("choose_licence"),LanguageSupport.getText("wrong_choice"),JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                LicenceTableModel ltm = (LicenceTableModel) lf.getjTableLicence().getModel();
                Licenca l = ltm.getList().get(row);
                Cordinator.getInstance().openLicencaDialog(lf, l);
            }
        });
        lf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openLicencaDialog(lf, null);
            }
        });
        
        lf.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lf.dispose();
            }
        }
        );
    }
    public void openForm(){
        fillTable(null);
        setLanguage();
        lf.setVisible(true);
    }

    public void fillTable(List<Licenca> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviLicenca();
            LicenceTableModel ltm = new LicenceTableModel(list);
            lf.getjTableLicence().setModel(ltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(lf, LanguageSupport.getText("error_loading_licence")+"\n"+ex.getMessage(),LanguageSupport.getText("loading_licence"),JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
     private boolean validation(Licenca l) {
        boolean valid = true;

        if(l.getNazivLicence().isBlank() && l.getZvanjeInstruktora().isBlank()){
            JOptionPane.showMessageDialog(lf, LanguageSupport.getText("search_validation"),LanguageSupport.getText("search_title"),JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(!l.getNazivLicence().isBlank() && !l.getNazivLicence().matches("^[a-zA-Z ]+$")){
            lf.getjTextFieldName().setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!l.getZvanjeInstruktora().isBlank() && !l.getZvanjeInstruktora().matches("^[a-zA-Z ]+$")){
            lf.getjTextFieldZvanje().setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!valid){
            JOptionPane.showMessageDialog(lf, LanguageSupport.getText("search_error"),LanguageSupport.getText("search_title"),JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return valid;
            }

    private void defaultBorders() {
        lf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lf.getjTextFieldZvanje().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    private void setLanguage() {
        lf.getjButtonAddLicence().setText(LanguageSupport.getText("add_btn"));
        lf.getjButtonFilter().setText(LanguageSupport.getText("search_btn"));
        lf.getjButtonClearFilter().setText(LanguageSupport.getText("clear_filter_btn"));
        lf.getjButtonBack().setText(LanguageSupport.getText("back_btn"));
        lf.getjButtonDetails().setText(LanguageSupport.getText("details_btn"));
        lf.getjLabelName().setText(LanguageSupport.getText("licence_name"));
        lf.getjLabelZvanje().setText(LanguageSupport.getText("licence_title"));
        lf.getjLabel3().setText(LanguageSupport.getText("search_criteria"));
        lf.setTitle(LanguageSupport.getText("licence"));
    }
}
