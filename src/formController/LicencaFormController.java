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
                    if(!validation())
                        return;

                    String name = lf.getjTextFieldName().getText();
                    String zvanje = lf.getjTextFieldZvanje().getText();
                    Licenca l = new Licenca();
                    l.setNazivLicence(name);
                    l.setZvanjeInstruktora(zvanje);

                    List<Licenca> list = Communication.getInstance().vratiListuLicenca(l);
                    fillTable(list);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(lf, "Greska prilikom filtriranja instruktora.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(lf, "Izaberite licencu iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
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
        lf.setVisible(true);
    }

    public void fillTable(List<Licenca> list) {
        try {
            if(list==null)
                list = Communication.getInstance().vratiListuSviLicenca();
            LicenceTableModel ltm = new LicenceTableModel(list);
            lf.getjTableLicence().setModel(ltm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(lf, "Greska prilikom ucitavanja licenci. \n"+ex.getMessage(),"Ucitavanje licenci",JOptionPane.ERROR_MESSAGE);
            
        }
    }
    
     private boolean validation() {
        boolean valid = true;
        String name = lf.getjTextFieldName().getText();
        String zvanje = lf.getjTextFieldZvanje().getText();
        if(name.isEmpty() && zvanje.isEmpty()){
            JOptionPane.showMessageDialog(lf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if(!name.isEmpty() && !name.matches("^[a-zA-Z ]+$")){
            lf.getjTextFieldName().setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!zvanje.isEmpty() && !zvanje.matches("^[a-zA-Z ]+$")){
            lf.getjTextFieldZvanje().setBorder(new LineBorder(Color.red,2));
            valid = false;
        }
        if(!valid){
            JOptionPane.showMessageDialog(lf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return valid;
            }

    private void defaultBorders() {
        lf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        lf.getjTextFieldZvanje().setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}
