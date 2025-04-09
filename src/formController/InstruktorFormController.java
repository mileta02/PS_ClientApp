/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formController;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Instruktor;
import table_model.InstructorTableModel;
import uiform.InstruktoriForm;

/**
 *
 * @author milan
 */
public class InstruktorFormController {
    private InstruktoriForm inf;

    public InstruktorFormController(InstruktoriForm inf) {
        this.inf = inf;
        addActionListener();
    }
    public void openForm(){
        fillTable(null);
        inf.setVisible(true);
    }

    private void addActionListener() {
        inf.searchActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = inf.getjTextFieldName().getText();
                    String surname = inf.getjTextFieldSurname().getText();
                    if(name.isEmpty() && surname.isEmpty()){
                        JOptionPane.showMessageDialog(inf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    Instruktor i = new Instruktor();
                    i.setIme(name);
                    i.setPrezime(surname);
                    List<Instruktor> list = Communication.getInstance().vratiListuInstruktor(i);
                    fillTable(list);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(inf, "Greska prilikom filtriranja instruktora.\n"+ex.getMessage(),"Filtriranje podataka",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        inf.clearFilterActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inf.getjTextFieldName().setText("");
                inf.getjTextFieldSurname().setText("");
                fillTable(null);
            }
        });
        
        inf.backActionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inf.dispose();
            }
        });
    }
    
    private void fillTable(List<Instruktor> list) {
        try {
            if(list==null)
                 list = Communication.getInstance().vratiListuSviInstruktor();
            InstructorTableModel itm = new InstructorTableModel(list);
            inf.getjTableInstructor().setModel(new InstructorTableModel(list));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(inf, "Greska prilikom ucitavanja podataka.\n"+ex.getMessage(),"Ucitavanje podataka",JOptionPane.ERROR_MESSAGE);
        }
    }
}
