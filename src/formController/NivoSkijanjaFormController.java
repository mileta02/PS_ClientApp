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
                    if(!validation())
                        return;
                    String name = nsf.getjTextFieldName().getText();

                    NivoSkijanja ns = new NivoSkijanja();
                    ns.setNazivNivoa(name);
                    
                    List<NivoSkijanja> list = Communication.getInstance().vratiListuNivoSkijanja(ns);
                    fillTable(list);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsf, "Greska prilikom ucitavanja nivoa skijanja. \n"+ex.getMessage(),"Ucitavanje nivoa skijanja",JOptionPane.ERROR_MESSAGE);

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
                    JOptionPane.showMessageDialog(nsf, "Izaberite nivo skijanja iz tabele","Pogrešan izbor",JOptionPane.INFORMATION_MESSAGE);
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

    private boolean validation() {
        String name = nsf.getjTextFieldName().getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(nsf, "Unesite  kriterijum pretrage","Pretraga",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if(!name.matches("^[a-zA-Z ]+$")){
            nsf.getjTextFieldName().setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            JOptionPane.showMessageDialog(nsf, "Pogrešan unos","Pretraga",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
}
