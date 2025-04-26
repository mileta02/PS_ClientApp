/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

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
                        JOptionPane.showMessageDialog(nsd, "Sistem je kreirao nivo skijanja.","Kreiranje nivoa skijanja",JOptionPane.INFORMATION_MESSAGE);
                        nsd.getController().fillTable(null);
                        nsd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),"Kreiranje nivoa skijanja",JOptionPane.ERROR_MESSAGE);
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

                    nsd.getNs().setNazivNivoa(nsd.getjTextFieldName().getText());
                    boolean b = Communication.getInstance().promeniNivoSkijanja(nsd.getNs());
                    if(b){
                        JOptionPane.showMessageDialog(nsd, "Sistem je zapamtio nivo skijanja.","Ažuriranje nivoa skijanja",JOptionPane.INFORMATION_MESSAGE);
                        nsd.getController().fillTable(null);
                        nsd.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),"Ažuriranje nivoa skijanja",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        nsd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(nsd, "Da li ste sigurni da želite da obrišete nivo skijanja?","Brisanje nivoa skijanja",JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    try {
                        boolean b = Communication.getInstance().obrisiNivoSkijanja(nsd.getNs());
                        if(b){
                            JOptionPane.showMessageDialog(nsd, "Sistem je obrisao nivo skijanja.","Brisanje nivoa skijanja",JOptionPane.INFORMATION_MESSAGE);
                            nsd.getController().fillTable(null);
                            nsd.dispose();
                        }
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(nsd, ex.getMessage(),"Brisanje nivoa skijanja",JOptionPane.ERROR_MESSAGE);
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
                nsd.getjLabelValidation().setText("Unesite naziv");
            }else if(!name.matches("^[a-zA-Z ]+$")){
                nsd.getjLabelValidation().setText("Naziv mora sadržati slova");
                valid=false;
            }   
            return valid;
    }

    private boolean isEdited() {
        if(nsd.getNs().getNazivNivoa().equals(nsd.getjTextFieldName().getText())){
            nsd.getjLabelValidation().setText("Niste izvršili izmenu");
            return false;
        }
        return true;
    }
}
