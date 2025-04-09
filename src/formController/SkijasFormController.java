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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import model.NivoSkijanja;
import model.Skijas;
import table_model.SkijasTableModel;
import uidialog.SkijasDialog;
import uiform.SkijasForm;

/**
 *
 * @author milan
 */
public class SkijasFormController {
    private SkijasForm sf;

    public SkijasFormController(SkijasForm sf) {
        this.sf = sf;
        addActionListener();
    }
    
    private void addActionListener() {
        sf.searchActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = sf.getjTextFieldName().getText();
                    String surname = sf.getjTextFieldSurname().getText();
                    NivoSkijanja ns = (NivoSkijanja) sf.getjComboNivo().getSelectedItem();
                    sf.getjTextFieldName().setBorder(new LineBorder(Color.black,1));
                    sf.getjTextFieldSurname().setBorder(new LineBorder(Color.black,1));

                    if(name.isEmpty() && surname.isEmpty() && ns==null){
                        JOptionPane.showMessageDialog(sf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    boolean valid = true;

                    if(!name.isEmpty() && !name.matches("^[a-zA-Z ]+$")){
                        valid = false;
                        sf.getjTextFieldName().setBorder(new LineBorder(Color.red,2));
                    }
                    if(!surname.isEmpty() && !surname.matches("^[a-zA-Z ]+$")){
                        valid = false;
                        sf.getjTextFieldSurname().setBorder(new LineBorder(Color.red,2));
                    }
                    if(!valid){
                        JOptionPane.showMessageDialog(sf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Skijas s = new Skijas();
                    s.setIme(name);
                    s.setPrezime(surname);
                    s.setNivoSkijanja(ns);
                    List<Skijas> list = Communication.getInstance().vratiListuSkijas(s);
                    fillTable(list);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sf, "Greska prilikom filtriranja instruktora.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sf.getjTextFieldName().setText("");
                sf.getjTextFieldSurname().setText("");
                sf.getjTextFieldName().setBorder(new LineBorder(Color.black,1));
                sf.getjTextFieldSurname().setBorder(new LineBorder(Color.black,1));
                sf.getjComboNivo().setSelectedIndex(-1);
                fillTable(null);
            }
        });
        
        sf.addActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cordinator.getInstance().openSkijasDialog(sf, null);
            }
        });
        
        sf.detailsFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = sf.getjTableSkijas().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(sf, "Izaberite skijasa iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                SkijasTableModel stm = (SkijasTableModel) sf.getjTableSkijas().getModel();
                Skijas s = stm.getList().get(row);
                Cordinator.getInstance().openSkijasDialog(sf, s);
            }
        });
        
        
        sf.backActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sf.dispose();
            }
        });
    }
    public void openForm(){
        fillComboBox();
        fillTable(null);
        sf.setVisible(true);
    }
    public void fillTable(List<Skijas> list) {
        try {
            if(list==null)
                 list = Communication.getInstance().vratiListuSviSkijas();
            SkijasTableModel stm = new SkijasTableModel(list);
            sf.getjTableSkijas().setModel(stm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(sf, "Greska prilikom ucitavanja podatakaaa.\n"+ex.getMessage(),"Ucitavanje podataka",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void fillComboBox(){
        List<NivoSkijanja> list;
        try {
            list = Communication.getInstance().vratiListuSviNivoSkijanja();
            for(NivoSkijanja ns : list)
                sf.getjComboNivo().addItem(ns);
            sf.getjComboNivo().setSelectedItem(null);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(sf, "Greska prilikom ucitavanja podatakaaa.\n"+ex.getMessage(),"Ucitavanje podataka",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
