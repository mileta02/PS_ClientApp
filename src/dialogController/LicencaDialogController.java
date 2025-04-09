/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Licenca;
import uidialog.LicencaDialog;

/**
 *
 * @author milan
 */
public class LicencaDialogController {
    private LicencaDialog ld;

    public LicencaDialogController(LicencaDialog ld) {
        this.ld = ld;
        addActionListener();
    }
    
    public void openForm(){
        ld.setLocationRelativeTo(null);
        fillFields();
        ld.setVisible(true);
    }

    private void addActionListener() {
        ld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation())
                    return;
                String naziv = ld.getjTextFieldNaziv().getText();
                String zvanje = ld.getjTextFieldZvanje().getText();

                Licenca l = new Licenca();
                l.setNazivLicence(naziv);
                l.setZvanjeInstruktora(zvanje);

                try {
                    if(Communication.getInstance().kreirajLicenca(l)){
                        JOptionPane.showMessageDialog(ld, "Uspešno kreirana licenca.","Kreiranje licence",JOptionPane.INFORMATION_MESSAGE);
                        ld.getController().fillTable(null);
                        ld.dispose();
                    }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ld, "Greška prilikom kreiranja licence. \n"+ex.getMessage(),"Kreiranje licence",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ld.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ld.getjButtonChange().setVisible(false);
                ld.getjButtonDelete().setVisible(false);
                ld.getjButtonSaveChanges().setVisible(true);
                ld.getjTextFieldNaziv().setEnabled(true);
                ld.getjTextFieldZvanje().setEnabled(true);
            }
        });
        
        ld.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validation() || !isEdited())
                    return;

                ld.getL().setNazivLicence(ld.getjTextFieldNaziv().getText());
                ld.getL().setZvanjeInstruktora(ld.getjTextFieldZvanje().getText());
                try {
                    if(Communication.getInstance().promeniLicenca(ld.getL())){
                        JOptionPane.showMessageDialog(ld, "Uspešno ažurirana licenca.","Ažuriranje licence",JOptionPane.INFORMATION_MESSAGE);
                        ld.getController().fillTable(null);
                        ld.dispose();
                    }
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(ld, "Greška prilikom ažuriranja licence. \n"+ex.getMessage(),"Ažuriranje licence",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        ld.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(ld, "Da li ste sigurni da želite da obrišete licencu?","Brisanje licence",JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    try{
                    boolean b = Communication.getInstance().obrisiLicenca(ld.getL());
                    if(b){
                        JOptionPane.showMessageDialog(ld, "Uspešno obrisana licenca.","Brisanje licence",JOptionPane.INFORMATION_MESSAGE);
                        ld.getController().fillTable(null);
                        ld.dispose();
                    }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(ld, "Greška prilikom brisanja licence. \n"+ex.getMessage(),"Brisanje licence",JOptionPane.ERROR_MESSAGE);
                    }
                    }else{
                    return;
                }
            }
        });
        
        ld.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ld.dispose();
            }
        });
    }
    
    private void fillFields() {
        if(ld.getL()==null){
            ld.getjButtonChange().setVisible(false);
            ld.getjButtonSaveChanges().setVisible(false);
            ld.getjButtonDelete().setVisible(false);
            return;
        }
        ld.getjTextFieldNaziv().setEnabled(false);
        ld.getjTextFieldZvanje().setEnabled(false);
        ld.getjTextFieldNaziv().setText(ld.getL().getNazivLicence());
        ld.getjTextFieldZvanje().setText(ld.getL().getZvanjeInstruktora());
    }
    
    private boolean validation(){
        String naziv = ld.getjTextFieldNaziv().getText();
        String zvanje = ld.getjTextFieldZvanje().getText();
        boolean valid = true;
        ld.getjLabelNaziv().setText("");
        ld.getjLabelZvanje().setText("");
        if(naziv.isEmpty()){
            ld.getjLabelNaziv().setText("Unesite naziv");
            valid=false;
        } else if(!naziv.matches("^[a-zA-Z ]+$")){
            ld.getjLabelNaziv().setText("Naziv mora sadržati slova");
            valid=false;
        }
        if(zvanje.isEmpty()){
            ld.getjLabelZvanje().setText("Unesite zvanje");
            valid=false;
        }else if(!zvanje.matches("^[a-zA-Z ]+$")){
            ld.getjLabelZvanje().setText("Zvanje mora sadržati slova");
            valid=false;
        }
        return valid;
    }
    
    private boolean isEdited(){
        String naziv = ld.getjTextFieldNaziv().getText();
        String zvanje = ld.getjTextFieldZvanje().getText();
        if(naziv.equals(ld.getL().getNazivLicence()) && zvanje.equals(ld.getL().getZvanjeInstruktora())){
            ld.getjLabelNaziv().setText("Niste izvršili izmenu");
            ld.getjLabelZvanje().setText("Niste izvršili izmenu");
            return false;
        }
        return true;
    }
}
