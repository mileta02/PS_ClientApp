/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dialogController;

import communication.Communication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.NivoSkijanja;
import model.Skijas;
import uidialog.SkijasDialog;

/**
 *
 * @author milan
 */
public class SkijasDialogController {
    private SkijasDialog sd;

    public SkijasDialogController(SkijasDialog sd) {
        this.sd = sd;
        addActionListener();
    }
    public void openForm(){
        sd.setLocationRelativeTo(null);
        fillComboBox();
        fillFields();
        sd.setVisible(true);
        
    }

    private void addActionListener() {
        sd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
            
                    String name = sd.getjTextFieldName().getText();
                    String surname = sd.getjTextFieldSurname().getText();
                    String num = sd.getjTextFieldPhoneNum().getText();
                    NivoSkijanja ns = (NivoSkijanja) sd.getjComboBoxNivo().getSelectedItem();
                    Skijas s = new Skijas(0, name, surname, num, ns);
                    
                    if(!validation(s)){
                        return;
                    }
                    boolean b = Communication.getInstance().kreirajSkijas(s);
                    if(b){
                        JOptionPane.showMessageDialog(sd, "Uspešno kreiranje Skijaš.\n","Kreiranje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        sd.dispose();
                        sd.getController().fillTable(null);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sd, "Greska prilikom kreiranja skijaša.\n"+ex.getMessage(),"Kreiranje skijaša",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sd.changeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.getjButtonChange().setVisible(false);
                sd.getjButtonSave().setVisible(true);
                sd.getjButtonDelete().setVisible(false);
                sd.getjTextFieldName().setEnabled(true);
                sd.getjTextFieldPhoneNum().setEnabled(true);
                sd.getjTextFieldSurname().setEnabled(true);
                sd.getjComboBoxNivo().setEnabled(true);
            }
        });
        
        sd.saveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = sd.getjTextFieldName().getText();
                    String surname = sd.getjTextFieldSurname().getText();
                    String num = sd.getjTextFieldPhoneNum().getText();
                    NivoSkijanja ns = (NivoSkijanja) sd.getjComboBoxNivo().getSelectedItem();
                    Skijas sk = new Skijas(sd.getS().getIdSkijas(), name, surname, num, ns);

                    if(!validation(sk)){
                        return;
                    }


                    if(name.equals(sd.getS().getIme()) && surname.equals(sd.getS().getPrezime()) && num.equals(sd.getS().getBrojTelefona()) && ns.getIdNivoSkijanja()==sd.getS().getNivoSkijanja().getIdNivoSkijanja()){
                        JOptionPane.showMessageDialog(sd, "Niste izmenili podatke.\n","Ažuriranje skijaša.",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    boolean b = Communication.getInstance().promeniSkijas(sk);
                    if(b){
                        JOptionPane.showMessageDialog(sd, "Uspešno ažuriran skijaš.\n","Ažuriranje skijaša",JOptionPane.INFORMATION_MESSAGE);
                        sd.getController().fillTable(null);
                        sd.dispose();
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sd, "Greska prilikom ažuriranja skijaša.\n"+ex.getMessage(),"Ažuriranje skijaša",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sd.deleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i =JOptionPane.showConfirmDialog(sd, "Da li ste sigurni da želite da obrišete skijaša?","Brisanje skijaša",JOptionPane.YES_NO_OPTION);
        
                if(i == JOptionPane.YES_OPTION){
                    try {

                        boolean b = Communication.getInstance().obrisiSkijas(sd.getS());
                        if(b){
                            JOptionPane.showMessageDialog(sd, "Uspešno obrisan skijaš.","Brisanje skijaša",JOptionPane.INFORMATION_MESSAGE);
                            sd.getController().fillTable(null);
                            sd.dispose();
                            }
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(sd, "Greška prilikom brisanja skijaša.","Brisanje skijaša",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        sd.backActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sd.dispose();
            }
        });
    }
    private void fillComboBox() {
        List<NivoSkijanja> list;
        try {
            list = Communication.getInstance().vratiListuSviNivoSkijanja();
            for(NivoSkijanja ns : list){
                sd.getjComboBoxNivo().addItem(ns);
                if(sd.getS()==null)
                    sd.getjComboBoxNivo().setSelectedItem(null);
                else if(ns.getIdNivoSkijanja()==sd.getS().getNivoSkijanja().getIdNivoSkijanja())
                    sd.getjComboBoxNivo().setSelectedItem(ns);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(sd, "Greska prilikom ucitavanja podatakaaa.\n"+ex.getMessage(),"Ucitavanje podataka",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void fillFields() {
        if(sd.getS() == null){
            sd.getjButtonDelete().setVisible(false);
            sd.getjButtonChange().setVisible(false);
            sd.getjButtonSave().setVisible(false);
        }
        else{
            sd.getjTextFieldName().setText(sd.getS().getIme());
            sd.getjTextFieldPhoneNum().setText(sd.getS().getBrojTelefona());
            sd.getjTextFieldSurname().setText(sd.getS().getPrezime());
            sd.getjButtonAdd().setVisible(false);
            sd.getjButtonSave().setVisible(false);
            sd.getjComboBoxNivo().setSelectedItem(sd.getS().getNivoSkijanja());
            sd.getjTextFieldName().setEnabled(false);
            sd.getjTextFieldPhoneNum().setEnabled(false);
            sd.getjTextFieldSurname().setEnabled(false);
            sd.getjComboBoxNivo().setEnabled(false);
        }
    }
    
    private boolean validation(Skijas sk) {
                boolean validate = true;
                    sd.getjLabelName().setText("");
                    sd.getjLabelSurname().setText("");
                    sd.getjLabelNum().setText("");
                    sd.getjLabelNivo().setText("");

                    if(sk.getIme().isEmpty()){
                        validate=false;
                        sd.getjLabelName().setText("Unesite ime");
                    }else if(!sk.getIme().matches("^[a-zA-Z ]+$")){
                        validate=false;
                        sd.getjLabelName().setText("Ime mora sadržati slova");
                    }
                    if(sk.getPrezime().isEmpty()){
                        validate=false;
                        sd.getjLabelSurname().setText("Unesite prezime");
                    }else if(!sk.getPrezime().matches("^[a-zA-Z ]+$")){
                        validate=false;
                        sd.getjLabelSurname().setText("Prezime mora sadržati slova");
                    }
                    if(sk.getBrojTelefona().isEmpty()){
                        validate=false;
                        sd.getjLabelNum().setText("Unesite broj");
                    }else if (!sk.getBrojTelefona().matches("\\+?[0-9]{9,15}")) {
                        sd.getjLabelNum().setText("Broj mora sadržati 9-15 cifara");
                        validate = false;
                    }
                    if(sk.getNivoSkijanja()==null){
                        validate=false;
                        sd.getjLabelNivo().setText("Unesite nivo skijanja");
                    }
                    return validate;
            }
}
